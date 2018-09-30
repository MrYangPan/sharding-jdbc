package springboot.sharding.mapper;

import springboot.sharding.entity.Order;

//@Mapper
public interface OrderMapper {

    void createIfNotExistsTable();

    void truncateTable();

    Long insert(Order model);

    void delete(Long orderId);

    void dropTable();
}
