import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by zhang on 2018/2/13.
 */
public class Rabbitmq {
    private static final String QUEUE_NAME = "rabbirmqTest";

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPassword("zhang");
        factory.setUsername("zhang");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);   // 声明一个队列：名称、持久性的（重启仍存在此队列）、非私有的、非自动删除的
        String mesage = "hello rabbitmq I am coming";
        channel.basicPublish("", QUEUE_NAME, null, mesage.getBytes("UTF-8"));
        System.out.println("发送成功");
        System.out.println(factory.getHost());
        System.out.println(factory.getPort());
        System.out.println(factory.getPassword());
        System.out.println(factory.getUsername());
        channel.close();
        connection.close();
        /**
         localhost
         5672
         guest
         guest
         */
    }
}
