package com.king.service;

import com.king.bean.Result;
import com.king.entity.po.UserPO;
import com.king.entity.req.UserReq;
import com.king.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package: com.king.service
 * @ClassName: UserService
 * @author: zhangkanglei
 * @createTime: 2022-10-19 19:40
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Result add(UserReq userReq) {
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(userReq,userPO);
        int insert = userMapper.insert(userPO);
        int d = 1 / 0;
        return Result.ok();
    }

    public Integer update(Integer id) {
        UserPO userPO = userMapper.selectById(id);
        userPO.setAge(80);
        userPO.setName("dasdw");
        int i = userMapper.updateById(userPO);
        return i;
    }
}
