package org.csu.wpetstore.persistence;

import org.csu.wpetstore.domain.Order;

import java.util.List;

/**
 * Created by WZF on 2018/4/30.
 */
public interface OrderDAO {
    List<Order> getOrdersByUsername(String username);

    Order getOrder(int orderId);

    void insertOrder(Order order);

    void insertOrderStatus(Order order);

}
