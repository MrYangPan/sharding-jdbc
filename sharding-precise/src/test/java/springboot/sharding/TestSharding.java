package springboot.sharding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.sharding.entity.Order;
import springboot.sharding.mapper.OrderMapper;

/**
 * Created by Mr.PanYang on 2018/9/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSharding {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void add() {
        Order order = new Order();
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                order.setUserId(i);
                order.setOrderId(j);
                orderMapper.insert(order);
            }
        }
    }

}
