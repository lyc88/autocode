package com.example.demo.racketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author lyc
 * @date 2020/10/26 14:44
 * @describe
 */
public class ConsumerTest01 {

    public static void main(String[] args) throws InterruptedException, MQClientException {

        // 实例化消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name");

        // 设置NameServer的地址
        consumer.setNamesrvAddr("127.0.0.1:9876");

        // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息
        consumer.subscribe("TopicTest", "*");
        // 注册回调实现类来处理从broker拉取回来的消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                try {
                    msgs.stream().forEach(e->{
                        //模拟耗时操作2分钟，大于设置的消费超时时间
                      /*  try {
                            //Thread.sleep(1000L * 60 * 2);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }*/
                        String s = new String(e.getBody());
                            if(s.equalsIgnoreCase("Hello RocketMQ 2")){
                                print(null);
                                throw new NullPointerException("aaaa");
                            }
                            System.out.println(Thread.currentThread().getName()+s);

                    });
                }catch (Throwable ex){

                    ex.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
               // System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
               // throw new RuntimeException("aaaa");
                // 标记该消息已经被成功消费
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 启动消费者实例
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }


    public static int  print(Object o){
        try {
            System.out.println(o);
            return 1;
        }catch (Exception e){
            return 4;
        }
    }
}
