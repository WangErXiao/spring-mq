import com.yao.consumer.FirstConsumer;
import com.yao.producer.FirstProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by root on 15-3-15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mq-conn.xml" })
public class TestProducerConsumer {
    @Autowired
    private FirstProducer firstProducer;
    @Autowired
    private FirstConsumer firstConsumer;

    @Test
    public void send(){
        firstProducer.sendDataToQueue("first message");
       // System.out.println(firstConsumer.getMsg());
    }

    @Test
    public void pull(){
        System.out.println(firstConsumer.getMsg());
    }
}
