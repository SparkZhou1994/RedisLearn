package spark.data.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import spark.data.mybatis.entity.UserBO;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author Spark
 * @Date 10/17/2019 1:09 PM
 **/
public interface UserDao {
    UserBO selectByUsername(@Param("username")String username);
    void insertUser(UserBO userBO);
}
