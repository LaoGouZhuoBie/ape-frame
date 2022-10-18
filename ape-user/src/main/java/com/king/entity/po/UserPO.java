package com.king.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.king.entity.BaseEntity;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * PO: 数据库映射类
 *
 */
@Data
@TableName("user")
public class UserPO extends BaseEntity {


    /**
     * 主键自增
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;


    /**
     * 年龄
     */
    private Integer age;


}
