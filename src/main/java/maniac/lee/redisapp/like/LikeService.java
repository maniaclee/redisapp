package maniac.lee.redisapp.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by peng on 16/6/16.
 */
@Component
public class LikeService {

    @Autowired
    private RedisTemplate<String, String> likeRedisTemplate;
    ValueOperations<String, String> valueOperations;

    @PostConstruct
    public void init() {
        valueOperations = likeRedisTemplate.opsForValue();
    }

    public Long like(String id) {
        return valueOperations.increment(id, 1);
    }

}
