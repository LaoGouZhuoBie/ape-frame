package com.king.controller;


import com.king.bean.Result;
import com.king.entity.req.UserReq;
import com.king.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/a")
    public String test(){
        return "hello";
    }


    @PostMapping("/user")
    public Result add(@RequestBody UserReq userReq){
        System.out.println(userReq);
        return userService.add(userReq);
    }

    @PutMapping("/user/{id}")
    public Integer update(@PathVariable Integer id){
        return userService.update(id);
    }

}
