import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by zhang on 2018/2/13.
 */
public class Customer {
    private static final String QUEUE_NAME = "rabbirmqTest";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setPassword("zhang");
        factory.setUsername("zhang");
        Connection connection = factory.newConnection();//链接
        Channel channel = connection.createChannel();
        //channel.queueDeclare(QUEUE_NAME,false,false,false,null);   // 声明一个队列：名称、持久性的（重启仍存在此队列）、非私有的、非自动删除的

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);//队列声明
        System.out.println("waiting......");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "utf-8");
                System.out.println("收到的信息是：" + message);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
        System.out.println("wanle");
    }
}
