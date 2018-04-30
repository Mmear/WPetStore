package org.csu.wpetstore.persistence;
import  org.csu.wpetstore.domain.Category;
import java.util.List;

/**
 * Created by WZF on 2018/4/25.
 */
public interface CategoryDAO {
    //获取所有类的列表
    List<Category> getCategoryList();
    //根据类id获取单个类
    Category getCategory(String categoryId);
    //TODO 通过productId获取category
    Category getCategoryByProductId(String productId);
}
