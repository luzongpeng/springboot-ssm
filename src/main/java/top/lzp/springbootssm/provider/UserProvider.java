package top.lzp.springbootssm.provider;

import top.lzp.springbootssm.entity.User;

/**
 * @author Lu
 * @date 2020/4/12:07:38:44
 * @description
 */
public class UserProvider {
    public String saveUser(User user){
        if (user.getId() == null){
            return "insert into user(username,password) values(#{username},#{password})";
        }else {
            return "insert into user values(#{id},#{username},#{password})";
        }

    }
}
