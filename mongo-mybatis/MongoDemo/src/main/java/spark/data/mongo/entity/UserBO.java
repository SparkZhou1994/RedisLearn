package spark.data.mongo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @ClassName UserBO
 * @Description TODO
 * @Author Spark
 * @Date 10/17/2019 1:48 PM
 **/
@Data
@Document(collection = "user")
public class UserBO implements Serializable {
    private static final Long serialVersionUID = -3258839839160856613L;
    private String username;
    private String password;
    private String ipAddress;
}
