package spark.redis.lettuce.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import spark.redis.lettuce.entity.UserBO;

import javax.annotation.PreDestroy;
import java.time.Duration;

/**
 * @ClassName SchedulerTask
 * @Description TODO
 * @Author Spark
 * @Date 9/24/2019 3:40 PM
 * @Version 1.0
 **/
@Component
@Slf4j
public class SchedulerTask {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final Long LOCK_TIME_OUT = 5000L;

    private static final String CLOSE_ORDER_TASK_LOCK = "CLOSE_ORDER_TASK_LOCK";

    @PreDestroy
    public void delLock(){
        redisTemplate.delete(CLOSE_ORDER_TASK_LOCK);
    }

    @Scheduled(cron = "*/6 * * * * ?")
    private void redisSetTask() {
        log.info("start close order");
        Boolean setAbsentResult = redisTemplate.opsForValue().setIfAbsent(CLOSE_ORDER_TASK_LOCK,String.valueOf(System.currentTimeMillis() + LOCK_TIME_OUT),Duration.ofMillis(5L));
        if(setAbsentResult){
            closeOrder();
        }else{
            String lockValueStr = (String)redisTemplate.opsForValue().get(CLOSE_ORDER_TASK_LOCK);
            if(lockValueStr != null && System.currentTimeMillis() > Long.parseLong(lockValueStr)){
                String getSetResult = (String)redisTemplate.opsForValue().getAndSet(CLOSE_ORDER_TASK_LOCK,String.valueOf(System.currentTimeMillis() + LOCK_TIME_OUT));
                if(getSetResult == null || (getSetResult != null && lockValueStr.equals(getSetResult))){
                    closeOrder();
                }else{
                    log.warn("close order does't get lock");
                }
            }else{
                log.warn("close order does't get lock");
            }
        }
        log.info("end close order");
    }

    private void closeOrder() {
        UserBO user = new UserBO();
        user.setUsername("admin");
        user.setAge(20);
        redisTemplate.opsForValue().set("test",user);
        log.info("close order delete key");
    }
}
