package com.ljj.springdatajpa.controller;

import com.ljj.springdatajpa.dao.UserJPA;
import com.ljj.springdatajpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2019/7/23 22:10
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserJPA userJPA;

    @GetMapping("/findAll")
    public List<User> findUserList(){
        return userJPA.findAll();
    }

    @GetMapping("/get/{userId}")
    public User getUserById(@PathVariable Integer userId){
        return userJPA.getOne(userId);
    }

    @GetMapping("/update/{userId}")
    public String updateUserAgeAddOne(@PathVariable Integer userId){
        User user = userJPA.getOne(userId);
        user.setAge(user.getAge() + 1);
        userJPA.save(user);
        return "年龄加1了";
    }

    @GetMapping("/findByAge/{age}")
    public List<User> findByAge(@PathVariable int age){
        return userJPA.findByAge(age);
    }

    @GetMapping("/deleteUserOne/{id}")
    public String deleteUserOne(@PathVariable int id){
        userJPA.deleteUserOne(id);
        return String.format("id=%s的用户删除成功", id);
    }
}
