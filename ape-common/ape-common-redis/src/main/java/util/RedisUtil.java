package util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 增
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 增 如果键不存在新增 如果存在则不新增  通常用来加锁
     * @param key
     * @param value
     * @param time
     * @param timeUnit
     * @return
     */
    public boolean setNx(String key, String value, Long time, TimeUnit timeUnit){
        return redisTemplate.opsForValue().setIfAbsent(key,value,time,timeUnit);
    }

    /**
     * 查
     * @param key
     * @return
     */
    public String get(String key){
        String value = (String) redisTemplate.opsForValue().get(key);
        return value;
    }

    /**
     * 删
     * @param key
     * @return
     */
    public boolean del(String key){
        return redisTemplate.delete(key);
    }

}
