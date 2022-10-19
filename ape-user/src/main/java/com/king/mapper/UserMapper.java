package com.king.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.king.entity.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
public interface UserMapper extends BaseMapper<UserPO> {

}
