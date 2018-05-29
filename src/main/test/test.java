/**
 * @ClassName test
 * @Description
 * @Author BlessXu
 * @Data 2018/5/29 16:56
 * @Version 1.0
 **/

import com.alibaba.fastjson.JSON;
import com.iflytek.rabbitMQ.RabbitSender;
import com.iflytek.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:spring/spring-mvc.xml","classpath:spring/applicationContext.xml"}) //加载配置文件
public class test{

    @Autowired
    private HelloService helloService;
    @Test
    public void testUser(){
        System.out.println(JSON.toJSONString(helloService.getUser("1")));
    }

    @Test
    public void rabbitTest(){
        RabbitSender rabbitSender=new RabbitSender();
        rabbitSender.sendMsg("bless");
    }
}