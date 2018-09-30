package springboot.sharding.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order implements Serializable {
    private Long id;
    private Integer userId;
    private Integer orderId;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderId=" + orderId +
                '}';
    }
}
