package spark.redis.sentinel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SentinelMethod
 * @Description TODO
 * @Author Spark
 * @Date 8/26/2019 9:44 AM
 * @Version 1.0
 **/
public class SentinelMethod {
    private static Logger logger = LoggerFactory.getLogger(SentinelMethod.class);
    public static void main(String[] args) {
        String masterName = "mym aster";
        Set<String> sentinels = new HashSet<String>();
        sentinels.add("192.168.4.128:26379");
        sentinels.add("192.168.4.128:26380");
        sentinels.add("192.168.4.128:26381");
        JedisSentinelPool sentinelPool = new JedisSentinelPool(masterName,sentinels);
        Integer counter = 0;
        while(true){
            counter ++;
            Jedis jedis = null;
            try {
                jedis = sentinelPool.getResource();
                Integer index = new Random().nextInt(10000);
                String key = "k-" + index;
                String value = "v-" + index;
                jedis.set(key,value);
                if(counter % 100 == 0){
                    logger.info("{} value is {}", key, jedis.get(key));
                }
                TimeUnit.MILLISECONDS.sleep(10);
            }catch(Exception e) {
                logger.error(e.getMessage(), e);
            }finally {
                if(jedis != null){
                    jedis.close();
                }
            }
        }
    }
}
