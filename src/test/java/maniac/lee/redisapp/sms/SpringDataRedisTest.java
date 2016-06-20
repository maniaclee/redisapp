package maniac.lee.redisapp.sms;

import maniac.lee.redisapp.like.LikeConfig;
import maniac.lee.redisapp.like.LikeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by peng on 16/6/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration(exclude = {DataSourceTransactionManagerAutoConfiguration.class, DataSourceAutoConfiguration.class})
@EnableAspectJAutoProxy
@ContextConfiguration(classes = {SmsConfig.class, LikeConfig.class})
public class SpringDataRedisTest {

    @Autowired
    private SmsService smsService;
    @Autowired
    private LikeService likeService;

    @Test
    public void sms() {
        String phone = "15000624790";
        String code = "456545";
        System.out.println(smsService.getMessage(phone));
        smsService.writeMessage(phone, code);
        System.out.println(smsService.validateMessage(phone, code));
    }

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            System.out.println(SmsService.genRandom());
        }
    }

    @Test
    public void like() {
        String id = "shit";
        System.out.println(likeService.like(id));
        System.out.println(likeService.like(id));
    }

}
