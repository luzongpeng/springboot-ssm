package top.lzp.springbootssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.lzp.springbootssm.dao.UserMapper;
import top.lzp.springbootssm.entity.User;

import java.util.List;

/**
 * @author Lu
 * @date 2020/4/12:07:05:43
 * @description
 */
@Controller
public class TestController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/findAll")
    public String findAll(){
        //查询全部
        List<User> userList = userMapper.findAll();
        for (User user:userList){
            System.out.println(user);
        }
        return "";
    }

    @RequestMapping("/findUserById")
    public String findUserById(int id){
        User user = userMapper.findUserById(id);
        System.out.println(user);
        return "null";
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        userMapper.save(user);
        return "null";
    }



}
