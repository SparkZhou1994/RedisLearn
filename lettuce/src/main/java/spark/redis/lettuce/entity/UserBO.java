package spark.redis.lettuce.entity;

import lombok.Data;

/**
 * @ClassName UserBO
 * @Description TODO
 * @Author Spark
 * @Date 9/24/2019 3:52 PM
 * @Version 1.0
 **/
@Data
public class UserBO {
    private String username;
    private String password;
    private Integer age;
}
