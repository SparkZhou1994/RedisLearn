package spark.redis.lettuce.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RedisConfig
 * @Description TODO
 * @Author Spark
 * @Date 9/20/2019 4:42 PM
 * @Version 1.0
 **/
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
}
