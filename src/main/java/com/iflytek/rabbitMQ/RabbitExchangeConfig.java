package com.iflytek.rabbitMQ;

import com.iflytek.constants.RabbitConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitExchangeConfig
 * @Description
 * @Author BlessXu
 * @Data 2018/5/29 20:14
 * @Version 1.0
 **/

@Configuration
public class RabbitExchangeConfig
{
    //直连交换机
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(RabbitConstant.EXCHANGE_NAME);
    }

    //队列
    @Bean
    public Queue queue() {
        return new Queue(RabbitConstant.QUEUE_NAME);
    }

    //绑定
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(this.queue()).to(this.defaultExchange()).with(RabbitConstant.ROUTING_KEY);
    }
}
