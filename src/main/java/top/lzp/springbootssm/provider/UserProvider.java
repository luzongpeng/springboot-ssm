package top.lzp.springbootssm.provider;

import top.lzp.springbootssm.entity.User;

/**
 * @author Lu
 * @date 2020/4/12:07:38:44
 * @description
 */
public class UserProvider {
    //添加用户
    public String saveUser(User user){
        if (user.getId() == null){
            return "insert into user(username,password) values(#{username},#{password})";
        }else {
            return "insert into user values(#{id},#{username},#{password})";
        }
    }
    //删除用户
    public String deleteUser(User user){
        if (user.getId() != null){
            return "delete from user where id = #{id}";
        }else if (user.getUsername() != null) {
            return "delete from user where username = #{username}";
        }else if (user.getPassword() != null){
            return "delete from user where password = #{password}";
        }else {
            throw new RuntimeException("请输入用户名、ID或密码");
        }
    }


}
