package org.csu.wpetstore.persistence.impl;

import org.csu.wpetstore.domain.Item;
import org.csu.wpetstore.domain.LineItem;
import org.csu.wpetstore.persistence.DBUtil;
import org.csu.wpetstore.persistence.LineItemDAO;

import javax.sound.sampled.Line;
import java.awt.image.DataBuffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WZF on 2018/4/30.
 */
public class LineItemDAOImpl implements LineItemDAO{
    private String sql_getLineItemByOrderId = "SELECT "  +
            "ORDERID," +
            "LINENUM AS lineNumber," +
            "ITEMID," +
            "QUANTITY," +
            "UNITPRICE " +
            "FROM LINEITEM " +
            "WHERE ORDERID = ?";
    private String sql_insLineItem = "INSERT INTO LINEITEM (ORDERID, LINENUM, ITEMID, QUANTITY, UNITPRICE) " +
            "VALUES (?, ?, ?, ?, ?)";
    @Override
    public List<LineItem> getLineItemsByOrderId(int orderId) {
        List<LineItem> lineItemList = new ArrayList<>();
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_getLineItemByOrderId);
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                LineItem lineItem = new LineItem();
                lineItem.setOrderId(orderId);
                lineItem.setLineNumber(rs.getInt(2));
                lineItem.setItemId(rs.getString(3));
                lineItem.setQuantity(rs.getInt(4));
                lineItem.setUnitPrice(rs.getBigDecimal(5));

                Item item = new ItemDAOImpl().getItem(lineItem.getItemId());
                lineItem.setItem(item);
                lineItem.calculateTotal();
                lineItemList.add(lineItem);
            }
            DBUtil.closeAll(null, stmt, rs, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lineItemList;
    }

    @Override
    public void insertLineItem(LineItem lineItem) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_insLineItem);
            stmt.setInt(1, lineItem.getOrderId());
            stmt.setInt(2, lineItem.getLineNumber());
            stmt.setString(3, lineItem.getItemId());
            stmt.setInt(4, lineItem.getQuantity());
            stmt.setBigDecimal(5, lineItem.getUnitPrice());
            stmt.executeUpdate();
            DBUtil.closeAll(null, stmt, null, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
