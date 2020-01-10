package spark.data.mongo.test.dao;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spark.data.mongo.MongoDemoApplication;
import spark.data.mongo.dao.UserDao;
import spark.data.mongo.entity.UserBO;

/**
 * @ClassName UserDaoTest
 * @Description TODO
 * @Author Spark
 * @Date 10/18/2019 11:06 AM
 **/
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    @Disabled
    public void insertUser(){
        UserBO userBO = new UserBO();
        userBO.setUsername("Spark");
        userBO.setPassword("123");
        userBO.setIpAddress("192.168.1.2");
        userDao.insertUser(userBO);
    }

    @Test
    public void findByUsername(){
        System.out.println(userDao.selectByUsername("Spark").getUsername());
    }
}
