package maniac.lee.redisapp.sms;

import maniac.lee.redisapp.RedisConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by peng on 16/6/14.
 */
@Configuration
public class SmsConfig extends RedisConfig {

    @Bean
    public RedisTemplate smsRedisTemplate() {
        return buildredisTemplate(new StringRedisSerializer());
    }

}
