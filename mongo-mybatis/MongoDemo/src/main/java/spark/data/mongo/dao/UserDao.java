package spark.data.mongo.dao;

import spark.data.mongo.entity.UserBO;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author Spark
 * @Date 10/18/2019 9:52 AM
 **/
public interface UserDao {
    void insertUser(UserBO user);
    UserBO selectByUsername(String username);
}
