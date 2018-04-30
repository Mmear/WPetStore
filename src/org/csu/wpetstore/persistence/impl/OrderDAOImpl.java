package org.csu.wpetstore.persistence.impl;

import org.csu.wpetstore.domain.LineItem;
import org.csu.wpetstore.domain.Order;
import org.csu.wpetstore.persistence.DBUtil;
import org.csu.wpetstore.persistence.OrderDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WZF on 2018/4/30.
 */
public class OrderDAOImpl implements OrderDAO{
    private String sql_getOrder = "select " +
            "BILLADDR1 AS billAddress1," +
            "BILLADDR2 AS billAddress2," +
            "BILLCITY," +
            "BILLCOUNTRY," +
            "BILLSTATE," +
            "BILLTOFIRSTNAME," +
            "BILLTOLASTNAME," +
            "BILLZIP," +
            "SHIPADDR1 AS shipAddress1," +
            "SHIPADDR2 AS shipAddress2," +
            "SHIPCITY," +
            "SHIPCOUNTRY," +
            "SHIPSTATE," +
            "SHIPTOFIRSTNAME," +
            "SHIPTOLASTNAME," +
            "SHIPZIP," +
            "CARDTYPE," +
            "COURIER," +
            "CREDITCARD," +
            "EXPRDATE AS expiryDate," +
            "LOCALE," +
            "ORDERDATE," +
            "ORDERS.ORDERID," +
            "TOTALPRICE," +
            "USERID AS username," +
            "STATUS " +
            "FROM ORDERS, ORDERSTATUS " +
            "WHERE ORDERS.ORDERID = ? " +
            "AND ORDERS.ORDERID = ORDERSTATUS.ORDERID";
    private String sql_getOrdersByUsername = "SELECT " +
            "BILLADDR1 AS billAddress1," +
            "BILLADDR2 AS billAddress2," +
            "BILLCITY," +
            "BILLCOUNTRY," +
            "BILLSTATE," +
            "BILLTOFIRSTNAME," +
            "BILLTOLASTNAME," +
            "BILLZIP," +
            "SHIPADDR1 AS shipAddress1," +
            "SHIPADDR2 AS shipAddress2," +
            "SHIPCITY," +
            "SHIPCOUNTRY," +
            "SHIPSTATE," +
            "SHIPTOFIRSTNAME," +
            "SHIPTOLASTNAME," +
            "SHIPZIP," +
            "CARDTYPE," +
            "COURIER," +
            "CREDITCARD," +
            "EXPRDATE AS expiryDate," +
            "LOCALE," +
            "ORDERDATE," +
            "ORDERS.ORDERID," +
            "TOTALPRICE," +
            "USERID AS username," +
            "STATUS " +
            "FROM ORDERS, ORDERSTATUS " +
            "WHERE ORDERS.USERID = ? " +
            "AND ORDERS.ORDERID = ORDERSTATUS.ORDERID " +
            "ORDER BY ORDERDATE";
    private String sql_insOrder = "INSERT INTO ORDERS (ORDERID, USERID, ORDERDATE, SHIPADDR1, SHIPADDR2, SHIPCITY, SHIPSTATE," +
            "SHIPZIP, SHIPCOUNTRY, BILLADDR1, BILLADDR2, BILLCITY, BILLSTATE, BILLZIP, BILLCOUNTRY," +
            "COURIER, TOTALPRICE, BILLTOFIRSTNAME, BILLTOLASTNAME, SHIPTOFIRSTNAME, SHIPTOLASTNAME," +
            "CREDITCARD, EXPRDATE, CARDTYPE, LOCALE) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?)";
    private String sql_insStatus = "INSERT INTO ORDERSTATUS (ORDERID, LINENUM, TIMESTAMP, STATUS) " +
            "VALUES (?, ?, ?, ?)";
    @Override
    public List<Order> getOrdersByUsername(String username) {
        List<Order> orderList = new ArrayList<>();
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_getOrdersByUsername);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Order order = new Order();
                order.setBillAddress1(rs.getString(1));
                order.setBillAddress2(rs.getString(2));
                order.setBillCity(rs.getString(3));
                order.setBillCountry(rs.getString(4));
                order.setBillState(rs.getString(5));
                order.setBillToFirstName(rs.getString(6));
                order.setBillToLastName(rs.getString(7));
                order.setBillZip(rs.getString(8));
                order.setShipAddress1(rs.getString(9));
                order.setShipAddress2(rs.getString(10));
                order.setShipCity(rs.getString(11));
                order.setShipCountry(rs.getString(12));
                order.setShipState(rs.getString(13));
                order.setShipToFirstName(rs.getString(14));
                order.setShipToLastName(rs.getString(15));
                order.setShipZip(rs.getString(16));
                order.setCardType(rs.getString(17));
                order.setCourier(rs.getString(18));
                order.setCreditCard(rs.getString(19));
                order.setExpiryDate(rs.getString(20));
                order.setLocale(rs.getString(21));
                order.setOrderDate(rs.getDate(22));
                order.setOrderId(rs.getInt(23));
                order.setTotalPrice(rs.getBigDecimal(24));
                order.setUsername(rs.getString(25));
                order.setStatus(rs.getString(26));
                orderList.add(order);
            }
            DBUtil.closeAll(null, stmt, rs, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public Order getOrder(int orderId) {
        Order order = null;
        LineItemDAOImpl lineItemDAO = new LineItemDAOImpl();
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_getOrder);
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                order = new Order();
                order.setOrderId(orderId);
                order.setBillAddress1(rs.getString(1));
                order.setBillAddress2(rs.getString(2));
                order.setBillCity(rs.getString(3));
                order.setBillCountry(rs.getString(4));
                order.setBillState(rs.getString(5));
                order.setBillToFirstName(rs.getString(6));
                order.setBillToLastName(rs.getString(7));
                order.setBillZip(rs.getString(8));
                order.setShipAddress1(rs.getString(9));
                order.setShipAddress2(rs.getString(10));
                order.setShipCity(rs.getString(11));
                order.setShipCountry(rs.getString(12));
                order.setShipState(rs.getString(13));
                order.setShipToFirstName(rs.getString(14));
                order.setShipToLastName(rs.getString(15));
                order.setShipZip(rs.getString(16));
                order.setCardType(rs.getString(17));
                order.setCourier(rs.getString(18));
                order.setCreditCard(rs.getString(19));
                order.setExpiryDate(rs.getString(20));
                order.setLocale(rs.getString(21));
                order.setOrderDate(rs.getDate(22));
                order.setOrderId(rs.getInt(23));
                order.setTotalPrice(rs.getBigDecimal(24));
                order.setUsername(rs.getString(25));
                order.setStatus(rs.getString(26));

                //…Ë÷√lineItem
                List<LineItem> lineItemList = lineItemDAO.getLineItemsByOrderId(orderId);
                order.setLineItems(lineItemList);
            }
            DBUtil.closeAll(null, stmt, rs, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void insertOrder(Order order) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_insOrder);
            stmt.setInt(1,order.getOrderId());
            stmt.setString(2, order.getUsername());
            stmt.setDate(3, new java.sql.Date(order.getOrderDate().getTime()));
            stmt.setString(4, order.getShipAddress1());
            stmt.setString(5, order.getShipAddress2());
            stmt.setString(6, order.getShipCity());
            stmt.setString(7, order.getShipState());
            stmt.setString(8, order.getShipZip());
            stmt.setString(9, order.getShipCountry());
            stmt.setString(10, order.getBillAddress1());
            stmt.setString(11, order.getBillAddress2());
            stmt.setString(12, order.getBillCity());
            stmt.setString(13, order.getBillState());
            stmt.setString(14, order.getBillZip());
            stmt.setString(15, order.getBillCountry());
            stmt.setString(16, order.getCourier());
            stmt.setBigDecimal(17, order.getTotalPrice());
            stmt.setString(18, order.getBillToFirstName());
            stmt.setString(19, order.getBillToLastName());
            stmt.setString(20, order.getShipToFirstName());
            stmt.setString(21, order.getShipToLastName());
            stmt.setString(22, order.getCreditCard());
            stmt.setString(23, order.getExpiryDate());
            stmt.setString(24, order.getCardType());
            stmt.setString(25, order.getLocale());
            stmt.executeUpdate();
            DBUtil.closeAll(null, stmt, null, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertOrderStatus(Order order) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_insStatus);
            stmt.setInt(1, order.getOrderId());
            stmt.setInt(2, order.getOrderId());
            stmt.setDate(3, new java.sql.Date(order.getOrderDate().getTime()));
            stmt.setString(4, order.getStatus());
            stmt.executeUpdate();
            DBUtil.closeAll(null, stmt, null, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
