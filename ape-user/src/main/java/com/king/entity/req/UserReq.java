package com.king.entity.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Package: com.king.entity.req
 * @ClassName: UserReq
 * @author: zhangkanglei
 * @createTime: 2022-10-19 19:39
 * @Description:
 */
@Data
public class UserReq {
    /**
     * 名称
     */
    private String name;


    /**
     * 年龄
     */
    private Integer age;

}
