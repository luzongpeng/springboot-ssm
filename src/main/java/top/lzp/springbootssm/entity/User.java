package top.lzp.springbootssm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

/**
 * @author Lu
 * @date 2020/4/12:06:56:41
 * @description
 */
@Setter
@Getter
@ToString
@Repository
public class User {
    private Integer id;
    private String username;
    private String password;

}
