package com.king.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {


    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;


    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    /**
     * 更新人
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;


    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


    /**
     * 逻辑删除
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleteFlag;


    /**
     * 乐观锁版本号
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

}
