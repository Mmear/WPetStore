package org.csu.wpetstore.persistence;
import  org.csu.wpetstore.domain.Category;
import java.util.List;

/**
 * Created by WZF on 2018/4/25.
 */
public interface CategoryDAO {
    //��ȡ��������б�
    List<Category> getCategoryList();
    //������id��ȡ������
    Category getCategory(String categoryId);
    //TODO ͨ��productId��ȡcategory
    Category getCategoryByProductId(String productId);
}
