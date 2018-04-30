package org.csu.wpetstore.persistence.impl;

import org.csu.wpetstore.domain.Category;
import org.csu.wpetstore.persistence.CategoryDAO;
import org.csu.wpetstore.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WZF on 2018/4/25.
 */
public class CategoryDAOImpl implements CategoryDAO{
    private String sql_getCateList = "SELECT CATID AS categoryId, NAME, DESCN AS description FROM CATEGORY";
    private String sql_getCate = "SELECT CATID AS categoryId, NAME, DESCN AS description FROM CATEGORY WHERE CATID=?";
    private String sql_getCateByProId = "SELECT C.CATID AS categoryId, C.NAME, C.DESCN AS description FROM CATEGORY C, PRODUCT P WHERE C.catid=P.category AND P.productId=?";
    @Override
    public List<Category> getCategoryList() {
        List<Category> clist = new ArrayList<>();
        try{
            Connection conn = DBUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql_getCateList);
            while (rs.next()) {
                clist.add(new Category(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            DBUtil.closeAll(stmt, null, rs, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clist;
    }
    @Override
    public  Category getCategory(String categoryId) {
        Category cate = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_getCate);
            stmt.setObject(1, categoryId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cate = new Category(rs.getString(1), rs.getString(2), rs.getString(3));
            }
            DBUtil.closeAll(stmt, null, rs, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cate;
    }

    public  Category getCategoryByProductId(String productId) {
        Category cate = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_getCateByProId);
            stmt.setObject(1, productId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                cate = new Category(rs.getString(1), rs.getString(2), rs.getString(3));
            }
            DBUtil.closeAll(stmt, null, rs, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cate;
    }
}
