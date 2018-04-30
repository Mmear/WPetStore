package org.csu.wpetstore.service;

import org.csu.wpetstore.domain.LineItem;
import org.csu.wpetstore.domain.Order;
import org.csu.wpetstore.domain.Sequence;
import org.csu.wpetstore.persistence.LineItemDAO;
import org.csu.wpetstore.persistence.impl.ItemDAOImpl;
import org.csu.wpetstore.persistence.impl.LineItemDAOImpl;
import org.csu.wpetstore.persistence.impl.OrderDAOImpl;
import org.csu.wpetstore.persistence.impl.SequenceDAOImpl;

import javax.sound.sampled.Line;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WZF on 2018/4/26.
 */
public class OrderService {
    private ItemDAOImpl itemMapper;
    private OrderDAOImpl orderMapper;
    private SequenceDAOImpl sequenceMapper;
    private LineItemDAOImpl lineItemMapper;

    public OrderService() {
        itemMapper = new ItemDAOImpl();
        orderMapper = new OrderDAOImpl();
        sequenceMapper = new SequenceDAOImpl();
        lineItemMapper = new LineItemDAOImpl();
    }
    public void insertOrder(Order order) {
        order.setOrderId(getNextId("ordernum"));
        for(int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = (LineItem) order.getLineItems().get(i);
            String itemId = lineItem.getItemId();
            Integer increment = new Integer(lineItem.getQuantity());
            Map<String, Object> param = new HashMap<>();
            param.put(itemId, increment);
            itemMapper.updateInventoryQuantity(param);
        }
        orderMapper.insertOrder(order);
        orderMapper.insertOrderStatus(order);
        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = (LineItem) order.getLineItems().get(i);
            lineItem.setOrderId(order.getOrderId());
            lineItemMapper.insertLineItem(lineItem);
        }
    }
    public List<Order> getOrderByUsername(String username) {
        return orderMapper.getOrdersByUsername(username);
    }
    public int getNextId(String name) {
        Sequence sequence = new Sequence(name, -1);
        sequence = sequenceMapper.getSequence(sequence);
        if(sequence == null) {
            throw new RuntimeException("Error: A null sequence was returned from the" +
                    "database (could not get next " + name + " sequence).");
        }
        Sequence paramterObject = new Sequence(name, sequence.getNextId() + 1);
        sequenceMapper.updateSequence(paramterObject);
        return sequence.getNextId();
    }
    public Order getOrder(int orderId) {
        return orderMapper.getOrder(orderId);
    }
}
