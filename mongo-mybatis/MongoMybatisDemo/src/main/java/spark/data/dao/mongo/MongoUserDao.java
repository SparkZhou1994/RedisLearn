package spark.data.dao.mongo;

import spark.data.entity.UserBO;

/**
 * @ClassName MybatisUserDao
 * @Description TODO
 * @Author Spark
 * @Date 10/18/2019 9:52 AM
 **/
public interface MongoUserDao {
    void insertUserForMongo(UserBO user);
    UserBO selectByUsernameForMongo(String username);
}
