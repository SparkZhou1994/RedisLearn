package spark.data.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UserBO
 * @Description TODO
 * @Author Spark
 * @Date 10/17/2019 1:11 PM
 **/
@Data
public class UserBO implements Serializable {
    private static final Long serialVersionUID = -3258839839160856613L;
    private String username;
    private String password;
    private String ipAddress;
}
