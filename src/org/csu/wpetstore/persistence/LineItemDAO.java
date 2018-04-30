package org.csu.wpetstore.persistence;

import org.csu.wpetstore.domain.LineItem;

import java.util.List;

/**
 * Created by WZF on 2018/4/30.
 */
public interface LineItemDAO {
    List<LineItem> getLineItemsByOrderId(int orderId);

    void insertLineItem(LineItem lineItem);
}
