package org.csu.wpetstore.persistence.impl;

import com.sun.org.apache.regexp.internal.RE;
import org.csu.wpetstore.domain.Item;
import org.csu.wpetstore.domain.Product;
import org.csu.wpetstore.persistence.DBUtil;
import org.csu.wpetstore.persistence.ItemDAO;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * Created by WZF on 2018/4/26.
 */
public class ItemDAOImpl implements ItemDAO{
    //需要用到inventory表item表inventory表
    private String sql_getInventory = "SELECT qty AS quantity FROM INVENTORY WHERE itemid=?";
    private String sql_udInventroy = "UPDATE inventory SET qty=qty-? WHERE itemid=?";
    private String sql_getPro = "SELECT productid, name, descn as description, category as categoryid FROM PRODUCT WHERE productid=?";
    private String sql_getItem =
            "SELECT I.itemid, listprice, unitcost, supplier AS supplierid, I.productid AS  productId,"
                    +"name AS productName, descn AS productDescn,"
                    +"category AS productCategory, "
                    +"status, "
                    +"attr1 AS attribute1, attr2 AS attribute2,attr1 AS attribute3, attr4 AS attribute4, attr5 AS attribute5,"
                    +"qty AS quantity "
                    +"FROM ITEM I, INVENTORY V, PRODUCT P"
                    +" WHERE P.productid=I.productid AND I.itemid=V.itemid AND I.itemid=?";
    private String sql_getItemList =
            "SELECT itemid, listprice, unitcost, supplier AS supplierid, I.productid AS  productId,"
                    +"name AS productName, descn AS productDescn, "
                    +"category AS productCategory, "
                    +"status, "
                    +"attr1 AS attribute1, attr2 AS attribute2,attr1 AS attribute3, attr4 AS attribute4, attr5 AS attribute5 FROM ITEM I, PRODUCT P"
                    +" WHERE P.productid=I.productid AND I.productid=?" ;
    //更新库存
    public void updateInventoryQuantity(Map<String, Object> param) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_udInventroy);
            Set<String> set = param.keySet();
            String itemId = set.iterator().next();
            Integer increment = (Integer) param.get(itemId);
            stmt.setInt(1, increment.intValue());
            stmt.setString(2, itemId);
            stmt.executeUpdate();
            DBUtil.closeAll(null, stmt, null, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //从inventory表中获得库存量
    public int getInventoryQuantity(String itemId) {
        int quantity = 0;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_getInventory);
            stmt.setObject(1, itemId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                quantity = rs.getInt(1);
            }
            DBUtil.closeAll(null, stmt, rs, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quantity;
    }

    public List<Item> getItemListByProduct(String productId) {
        List<Item> iList = new ArrayList<>();
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_getItemList);
            PreparedStatement stmt_pro = conn.prepareStatement(sql_getPro);
            stmt.setObject(1, productId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Item item = new Item();
                //设置基本属性
                item.setItemId(rs.getString(1));
                item.setListPrice(rs.getBigDecimal(2));
                item.setUnitCost(rs.getBigDecimal(3));
                item.setSupplierId(rs.getInt(4));
                item.setProductId(rs.getString(5));
                item.setStatus(rs.getString(9));
                item.setAttributes(rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
                //查询item对应的product实例后再设置
                stmt_pro.setObject(1, item.getProductId());
                rs = stmt_pro.executeQuery();
                rs.next();
                item.setProduct(new Product(rs.getString(1), rs.getString(4), rs.getString(2), rs.getString(3)));
                iList.add(item);
            }
            DBUtil.closePrepareStatement(stmt_pro);
            DBUtil.closeAll(null, stmt, rs, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iList;
    }
    public Item getItem(String itemId) {
        Item item  = new Item();
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_getItem);
            PreparedStatement stmt_pro = conn.prepareStatement(sql_getPro);
            PreparedStatement stmt_qty = conn.prepareStatement(sql_getInventory);
            stmt.setObject(1, itemId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            //设置基本属性
            item.setItemId(rs.getString(1));
            item.setListPrice(rs.getBigDecimal(2));
            item.setUnitCost(rs.getBigDecimal(3));
            item.setSupplierId(rs.getInt(4));
            item.setProductId(rs.getString(5));
            item.setStatus(rs.getString(9));
            item.setAttributes(rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
            item.setQuantity(rs.getInt(15));
            //查询item对应的product实例后再设置
            stmt_pro.setObject(1, item.getProductId());
            rs = stmt_pro.executeQuery();
            rs.next();
            item.setProduct(new Product(rs.getString(1), rs.getString(4), rs.getString(2), rs.getString(3)));
            //关闭连接
            DBUtil.closePrepareStatement(stmt_pro);
            DBUtil.closeAll(null, stmt, rs, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}
