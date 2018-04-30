package org.csu.wpetstore.service;
import org.csu.wpetstore.domain.Category;
import org.csu.wpetstore.domain.Product;
import org.csu.wpetstore.domain.Item;
import org.csu.wpetstore.persistence.CategoryDAO;
import org.csu.wpetstore.persistence.ProductDAO;
import org.csu.wpetstore.persistence.ItemDAO;
import org.csu.wpetstore.persistence.impl.CategoryDAOImpl;
import org.csu.wpetstore.persistence.impl.ItemDAOImpl;
import org.csu.wpetstore.persistence.impl.ProductDAOImpl;

import java.util.List;
/**
 * Created by WZF on 2018/4/26.
 */
public class CategoryService {
    private CategoryDAOImpl categoryDAO;
    private ProductDAOImpl productDAO;
    private ItemDAOImpl itemDAO;
    public CategoryService() {
        categoryDAO = new CategoryDAOImpl();
        productDAO = new ProductDAOImpl();
        itemDAO = new ItemDAOImpl();
    }
    public List<Category> getCategoryList() {
        return categoryDAO.getCategoryList();
    }

    public Category getCategory(String categoryId) {
        return categoryDAO.getCategory(categoryId);

    }
    public  Category getCategoryByProductId(String productId) {
        return categoryDAO.getCategoryByProductId(productId);
    }
    public Product getProduct(String productId) {
        return productDAO.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productDAO.getProductListByCategory(categoryId);
    }

    // TODO enable using more than one keyword
    public List<Product> searchProductList(String keyword) {
        return productDAO.searchProductList("%" + keyword.toLowerCase() + "%");
    }

    public List<Item> getItemListByProduct(String productId) {
        return itemDAO.getItemListByProduct(productId);
    }

    public Item getItem(String itemId) {
        return itemDAO.getItem(itemId);
    }

    public boolean isItemInStock(String itemId) {
        return itemDAO.getInventoryQuantity(itemId) > 0;
    }
}
