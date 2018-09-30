package springboot.sharding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.sharding.entity.Order;
import springboot.sharding.mapper.OrderMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mr.PanYang on 2018/9/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 单片查询
     */
    @Test
    public void getByUserId() {
        List<Order> byUserId = orderMapper.findByUserId(5);
        for (Order order : byUserId) {
            System.out.println(order);
        }
    }
}
