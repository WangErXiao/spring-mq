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
       for (int i=0;i<10;i++){
           firstProducer.sendDataToQueue("first message:"+i);
       }
    }

    @Test
    public void pull(){
        for (int i=0;i<10;i++) {
            System.out.println(firstConsumer.getMsg());
        }
    }
}
