package com.iflytek.RabbitMQ;

import com.iflytek.constants.RabbitConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @ClassName RabbitSender
 * @Description
 * @Author BlessXu
 * @Data 2018/5/29 20:21
 * @Version 1.0
 **/

@Component
public class RabbitSender implements RabbitTemplate.ConfirmCallback
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        this.rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
        this.rabbitTemplate.convertAndSend(RabbitConstant.EXCHANGE_NAME,
                RabbitConstant.ROUTING_KEY, content, correlationId);
    }

    //回调
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println(" 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息成功消费");
        } else {
            System.out.println("消息消费失败:" + cause);
        }
    }
}