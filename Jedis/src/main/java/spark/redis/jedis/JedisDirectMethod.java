package spark.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName JedisDirectMethod
 * @Description TODO
 * @Author Spark
 * @Date 8/21/2019 5:05 PM
 * @Version 1.0
 **/
public class JedisDirectMethod {
    private static Jedis jedis = new Jedis("192.168.4.128", 6379);

    public static void main(String[] args) {
        getSetForString();
        getSetForHash();
        getSetForList();
        getSetForSet();
        getSetForZSet();
    }

    private static void getSetForString() {
        jedis.set("hello","world");
        String value = jedis.get("hello");
        System.out.println(value);
        Long counter = jedis.incr("counter");
        System.out.println(counter);
    }

    private static void getSetForHash() {
        jedis.hset("myhash", "f1", "v1");
        jedis.hset("myhash", "f2", "v2");
        Map<String,String> map = jedis.hgetAll("myhash");
        for(String key : map.keySet()) {
            String value = map.get(key);
            System.out.print(key);
            System.out.print(" -> ");
            System.out.print(value);
            System.out.print("\n");
        }
    }

    private static void getSetForList() {
        jedis.rpush("mylist","1");
        jedis.rpush("mylist","2");
        jedis.rpush("mylist","3");
        List<String> items = jedis.lrange("mylist",0 , -1);
        for(String item : items) {
            System.out.println(item);
        }
    }

    private static void getSetForSet() {
        jedis.sadd("myset","a");
        jedis.sadd("myset","b");
        jedis.sadd("myset","a");
        Set<String> set = jedis.smembers("myset");
        for(String item : set) {
            System.out.println(item);
        }
    }

    private static void getSetForZSet() {
        jedis.zadd("myzset", 99, "tom");
        jedis.zadd("myzset", 66, "peter");
        jedis.zadd("myzset", 33, "james");
        Set<Tuple> zset = jedis.zrangeWithScores("myzset", 0, -1);
        for(Tuple tuple : zset) {
            System.out.print(tuple.getElement());
            System.out.print(" -> ");
            System.out.print(tuple.getScore());
            System.out.print("\n");
        }
    }
}
