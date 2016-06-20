package maniac.lee.redisapp.sms;

import com.google.common.base.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * Created by peng on 16/6/16.
 */
@Component
public class SmsService {

    @Autowired
    private RedisTemplate<String, String> smsRedisTemplate;
    ValueOperations<String, String> valueOperations;

    @PostConstruct
    public void init() {
        valueOperations = smsRedisTemplate.opsForValue();
    }

    public boolean hasMessage(String phone) {
        return valueOperations.getOperations().hasKey(phone);
    }

    public void writeMessage(String phone, String code) {
        valueOperations.set(phone, code, 60, TimeUnit.SECONDS);
    }

    public boolean validateMessage(String phone, String code) {
        return Objects.equal(valueOperations.get(phone), code);
    }

    public String getMessage(String phone) {
        return valueOperations.get(phone);
    }

    public static String genRandom() {
        return genRandom(6);
    }

    public static String genRandom(int digits) {
        if (digits <= 0)
            throw new IllegalArgumentException("at least 1 digit is need.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }

}
