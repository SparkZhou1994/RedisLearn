package spark.data.mongo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import spark.data.mongo.dao.UserDao;
import spark.data.mongo.entity.UserBO;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author Spark
 * @Date 10/18/2019 9:53 AM
 **/
@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertUser(UserBO user) {
        mongoTemplate.save(user);
    }

    @Override
    public UserBO selectByUsername(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        return mongoTemplate.findOne(query, UserBO.class);
    }
}
