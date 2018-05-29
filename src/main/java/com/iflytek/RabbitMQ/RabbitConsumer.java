package com.iflytek.RabbitMQ;

import com.iflytek.constants.RabbitConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName RabbitConsumer
 * @Description
 * @Author BlessXu
 * @Data 2018/5/29 20:24
 * @Version 1.0
 **/

@Component
public class RabbitConsumer {

    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.QUEUE_NAME)
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }
}
