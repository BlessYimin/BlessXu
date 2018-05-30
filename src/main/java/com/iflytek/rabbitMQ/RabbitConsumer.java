package com.iflytek.rabbitMQ;

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
@RabbitListener(queues = RabbitConstant.QUEUE_NAME)
public class RabbitConsumer {

    @RabbitHandler
    public void onMessage(String message) {
        System.out.println("Receiver1  : " + message);
    }
}
