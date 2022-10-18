package util;


import exception.ShareLockException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Redis分布式锁
 */
@Component
public class RedisShareLockUtil {

    @Resource
    private RedisUtil redisUtil;

    private Long TIME_OUT = 1000L;

    /**
     * @Author:
     * @Description: 加锁
     * @DateTime: 2022/9/24 21:25
     */
    public boolean lock(String lockKey, String requestId, Long time) {
        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0) {
            throw new ShareLockException("分布式锁-加锁参数异常");
        }
        long currentTime = System.currentTimeMillis();
        //锁失效时间
        long outTime = currentTime + TIME_OUT;
        Boolean result = false;
        while (currentTime < outTime) {
            result = redisUtil.setNx(lockKey, requestId, time, TimeUnit.MILLISECONDS);
            if (result) {
                return result;
            }

            //小小睡眠一会儿
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            currentTime = System.currentTimeMillis();
        }
        return result;
    }

    /**
     * @Author:
     * @Description:解锁
     * @DateTime: 2022/9/24 21:25
     */
    public boolean unLock(String key, String requestId) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(requestId)) {
            throw new ShareLockException("分布式锁-解锁-参数异常");
        }
        try {
            String value = redisUtil.get(key);
            if (requestId.equals(value)) {
                redisUtil.del(key);
                return true;
            }
        } catch (Exception e) {
            //补日志
        }
        return false;
    }

    /**
     * @Author:
     * @Description: 尝试加锁
     * @DateTime: 2022/9/24 21:26
     */
    public boolean tryLock(String lockKey, String requestId, Long time) {
        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0) {
            throw new ShareLockException("分布式锁-尝试加锁参数异常");
        }
        return redisUtil.setNx(lockKey, requestId, time, TimeUnit.MILLISECONDS);
    }

}
