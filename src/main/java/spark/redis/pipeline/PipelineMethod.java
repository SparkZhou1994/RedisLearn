package spark.redis.pipeline;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * @ClassName PipelineMethod
 * @Description Pipeline 操作不是原子的
 * @Author Spark
 * @Date 8/22/2019 12:32 PM
 * @Version 1.0
 **/
public class PipelineMethod {

    private static Jedis jedis = new Jedis("192.168.4.128", 6379);

    public static void main(String[] args) {
        for(Integer i = 0; i < 100; i++){
            Pipeline pipeline = jedis.pipelined();
            for(Integer j = i*100; j < (i+1)*100; j++){
                pipeline.hset("hashkey:" + j, "field" + j, "value" + j);
            }
            pipeline.syncAndReturnAll();
        }
    }
}
