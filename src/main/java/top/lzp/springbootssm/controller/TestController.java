package top.lzp.springbootssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String findUserById(@RequestParam(value = "id",required = false,defaultValue = "1") int id){
        User user = userMapper.findUserById(id);
        System.out.println(user);
        return "null";
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        userMapper.save(user);
        return "null";
    }

    //删
    @RequestMapping("/deleteUser")
    public String deleteUser(User user){
        try {
            userMapper.deleteUser(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "null";
    }

    //改
    @RequestMapping("/modifyUser")
    public String modifyUser(User user){
        User userInSql =userMapper.findUserById(user.getId());
        userInSql.setUsername(user.getUsername());
        userInSql.setPassword(user.getPassword());
        userMapper.modifyUser(userInSql);
        return "null";
    }



}
