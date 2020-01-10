package spark.data.dao.mongo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import spark.data.dao.mongo.MongoUserDao;
import spark.data.entity.UserBO;

/**
 * @ClassName MongoUserDaoImpl
 * @Description TODO
 * @Author Spark
 * @Date 10/18/2019 9:53 AM
 **/
@Component
public class MongoUserDaoImpl implements MongoUserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertUserForMongo(UserBO user) {
        mongoTemplate.save(user);
    }

    @Override
    public UserBO selectByUsernameForMongo(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        return mongoTemplate.findOne(query, UserBO.class);
    }
}
