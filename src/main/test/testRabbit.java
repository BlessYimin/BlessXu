import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName testRabbit
 * @Description
 * @Author BlessXu
 * @Data 2018/5/30 14:14
 * @Version 1.0
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-mvc.xml","classpath:spring/applicationContext.xml","classpath:spring/rabbitMQ.xml"})
public class testRabbit {


    @Test
    public void send() throws Exception{
        System.out.println("");
//        amqpTemplate.convertAndSend("com.iflytek", "bless");
    }
}
