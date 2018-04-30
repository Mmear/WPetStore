package org.csu.wpetstore.persistence.impl;

import org.csu.wpetstore.domain.Product;
import org.csu.wpetstore.persistence.DBUtil;
import org.csu.wpetstore.persistence.ProductDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WZF on 2018/4/26.
 */
public class ProductDAOImpl implements ProductDAO{
    private String sql_getProList = "SELECT productid, name, descn as description, category as categoryid FROM PRODUCT WHERE category= ?";
    private String sql_getProByKey = "SELECT productid, name, descn as description, category as categoryid FROM PRODUCT WHERE lower(name) LIKE ?";
    private String sql_getPro = "SELECT productid, name, descn as description, category as categoryid FROM PRODUCT WHERE productid=?";

    public List<Product> getProductListByCategory(String categoryId) {
        List<Product> pList = new ArrayList<>();
        try{
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_getProList);
            stmt.setObject(1, categoryId);
            //System.out.println("hello" + stmt.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pList.add(new Product(rs.getString(1), rs.getString(4), rs.getString(2),rs.getString(3)));
            }
            DBUtil.closeAll(stmt, null, rs, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pList;
    }
    public Product getProduct(String productId) {
        Product pro = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_getPro);
            stmt.setObject(1, productId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                pro = new Product(rs.getString(1), rs.getString(4), rs.getString(2), rs.getString(3));
            }
            DBUtil.closeAll(null, stmt, rs, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pro;
    }

    public List<Product> searchProductList(String keyword) {
        List<Product> pList = new ArrayList<>();
        try {
            Connection conn = DBUtil.getConnection();
            if(conn != null) {
                PreparedStatement stmt = conn.prepareStatement(sql_getProByKey);
                stmt.setObject(1, keyword);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                    pList.add(new Product(rs.getString(1), rs.getString(4), rs.getString(2),rs.getString(3)));
                }
                DBUtil.closeAll(null, stmt, rs, conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pList;
    }
}
