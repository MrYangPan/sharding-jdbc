package springboot.sharding.mapper;

import springboot.sharding.entity.OrderItem;

import java.util.List;

//@Mapper
public interface OrderItemMapper {

    void createIfNotExistsTable();

    void truncateTable();

    Long insert(OrderItem model);

    void delete(Long orderItemId);

    List<OrderItem> selectAll();

    void dropTable();

    //  模拟跨库查询 in
    List<OrderItem> selectIn();

    //  between and 跨库查询
    List<OrderItem> selectBetween();
}
