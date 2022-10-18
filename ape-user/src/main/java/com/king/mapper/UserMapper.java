package com.king.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.king.entity.po.UserPO;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper extends BaseMapper<UserPO> {

}
