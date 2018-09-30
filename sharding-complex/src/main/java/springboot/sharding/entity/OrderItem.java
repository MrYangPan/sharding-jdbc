package springboot.sharding.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class OrderItem {

    private int orderItemId;

    private int orderId;

    private int userId;

    private String status;

    @Override
    public String toString() {
        return "orderId: " + orderId + "  -------userId: " + userId + "  -------orderItemId: " + orderItemId + "  ------status: " + status;
    }
}
