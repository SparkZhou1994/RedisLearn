package spark.data.dao.mybatis;

import org.apache.ibatis.annotations.Param;
import spark.data.entity.UserBO;

/**
 * @ClassName MybatisUserDao
 * @Description TODO
 * @Author Spark
 * @Date 10/17/2019 1:09 PM
 **/
public interface MybatisUserDao {
    UserBO selectByUsernameForMybatis(@Param("username") String username);
    void insertUserForMybatis(UserBO userBO);
}
