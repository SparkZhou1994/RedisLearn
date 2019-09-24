package spark.redis.lettuce.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import spark.redis.lettuce.entity.UserBO;

/**
 * @ClassName SchedulerTask
 * @Description TODO
 * @Author Spark
 * @Date 9/24/2019 3:40 PM
 * @Version 1.0
 **/
@Component
public class SchedulerTask {

    @Autowired
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "*/6 * * * * ?")
    private void redisSetTask() {
        UserBO user = new UserBO();
        user.setUsername("admin");
        user.setAge(20);
        redisTemplate.opsForValue().set("test",user);
    }
}
