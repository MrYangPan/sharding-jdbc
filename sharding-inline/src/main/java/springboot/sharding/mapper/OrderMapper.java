package springboot.sharding.mapper;

import springboot.sharding.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {

    void insert(Order order);

    List<Order> findByUserId(Integer id);

    List<Order> findByUserIdBetween(Map<String, Integer> map);

    List<Order> findByOrderId(Integer id);
}
