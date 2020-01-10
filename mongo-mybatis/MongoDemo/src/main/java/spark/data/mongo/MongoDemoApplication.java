package spark.data.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @ClassName MongoDemoApplication
 * @Description TODO
 * @Author Spark
 * @Date 10/17/2019 1:47 PM
 **/
@SpringBootApplication
public class MongoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDemoApplication.class, args);
    }
}
