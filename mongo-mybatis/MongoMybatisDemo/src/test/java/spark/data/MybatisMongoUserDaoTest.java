package spark.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spark.data.dao.mongo.MongoUserDao;
import spark.data.dao.mybatis.MybatisUserDao;
import spark.data.entity.UserBO;

/**
 * @ClassName MybatisMongoUserDaoTest
 * @Description TODO
 * @Author Spark
 * @Date 10/18/2019 11:06 AM
 **/
@SpringBootTest
public class MybatisMongoUserDaoTest {

    @Autowired
    private MybatisUserDao mybatisUserDao;

    @Autowired
    private MongoUserDao mongoUserDao;

    @Test
    @Disabled
    public void insertUser(){
        UserBO userBO = new UserBO();
        userBO.setUsername("Spark");
        userBO.setPassword("123");
        userBO.setIpAddress("192.168.1.2");
        mongoUserDao.insertUserForMongo(userBO);
        mybatisUserDao.insertUserForMybatis(userBO);
    }

    @Test
    public void findByUsername(){
        System.out.println("Mongo:" + mongoUserDao.selectByUsernameForMongo("Spark"));
        System.out.println("Mybatis:" + mybatisUserDao.selectByUsernameForMybatis("Spark"));
    }
}
