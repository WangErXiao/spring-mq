import com.yao.consumer.FirstConsumer;
import com.yao.model.Dog;
import com.yao.model.Message;
import com.yao.producer.FirstProducer;
import com.yao.utils.JsonConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

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
           firstProducer.sendDataToQueue(new Dog(){{
                setName("dog");
                setAge((int)((Math.random()+1)*10));
           }});
       }
    }
    @Test
    public void pull(){
        for (int i=0;i<10;i++) {
            Message message=(Message)firstConsumer.getMsg();
            System.out.println(message.getBody());
            //Dog dog= JsonConverter.json2Obj(message,Dog.class);
            //System.out.println("dog name:"+dog.getName());
            //System.out.println("dog age:"+dog.getAge());
        }
    }
}
