package top.lzp.springbootssm.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.lzp.springbootssm.entity.User;
import top.lzp.springbootssm.provider.UserProvider;


import java.util.List;

/**
 * @author Lu
 * @date 2020/4/12:07:06:36
 * @description
 */
@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    User findUserById(int id);

    /*@Insert("insert into user(username,password) values(#{username},#{password})")
    void save(User user);*/

    @InsertProvider(type = UserProvider.class,method = "saveUser")
    void save(User user);

    @DeleteProvider(type = UserProvider.class,method = "deleteUser")
    void deleteUser(User user) throws Exception;

    @Update("update user set username = #{username},password = #{password} where id = #{id}")
    void modifyUser(User userInSql);
}
