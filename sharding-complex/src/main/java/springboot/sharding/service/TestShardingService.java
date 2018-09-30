package springboot.sharding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.sharding.entity.Order;
import springboot.sharding.entity.OrderItem;
import springboot.sharding.mapper.OrderItemMapper;
import springboot.sharding.mapper.OrderMapper;

import java.util.List;

/**
 * Created by Mr.PanYang on 2018/9/21.
 * <p>
 * 支持本地事物
 */
@Service
@Transactional
public class TestShardingService {

    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private OrderMapper orderMapper;

    public void initData() {
        orderMapper.createIfNotExistsTable();
        orderItemMapper.createIfNotExistsTable();
        orderMapper.truncateTable();
        orderItemMapper.truncateTable();
    }

    public void dropAllTables() {
        orderMapper.dropTable();
        orderItemMapper.dropTable();
    }

    public void insertOrder() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < 5; j++) {
                Order order = new Order();
                order.setUserId(i);
                order.setStatus("INSERT_TEST");
                orderMapper.insert(order);

                Integer orderId = order.getOrderId();
                OrderItem item = new OrderItem();
                item.setOrderId(orderId);
                item.setUserId(i);
                orderItemMapper.insert(item);
//                测试事物
//                int a = 1 / 0;
            }
        }
    }

    public void selectAllOrderItems() {
        List<OrderItem> orderItemList = orderItemMapper.selectAll();
    }

    public List<OrderItem> selectIn() {
        List<OrderItem> orderItemList = orderItemMapper.selectIn();
        for (OrderItem orderItem : orderItemList) {
            System.out.println(orderItem);
        }
        return orderItemList;
    }

    public void selectBetween() {
        List<OrderItem> orderItemList = orderItemMapper.selectBetween();
        for (OrderItem orderItem : orderItemList) {
            System.out.println(orderItem);
        }
    }


}
