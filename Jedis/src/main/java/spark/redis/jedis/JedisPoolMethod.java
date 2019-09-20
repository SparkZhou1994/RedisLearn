package spark.redis.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @ClassName JedisPoolMethod
 * @Description TODO
 * @Author Spark
 * @Date 8/22/2019 12:12 PM
 * @Version 1.0
 **/
public class JedisPoolMethod {

    private static GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
    private static JedisPool jedisPool = new JedisPool(poolConfig, "192.168.4.128", 6379);

    public static void main(String[] args) {
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            jedis.set("hello", "world");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
    }
}
