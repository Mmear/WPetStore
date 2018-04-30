package org.csu.wpetstore.persistence;
import org.csu.wpetstore.domain.Product;
import java.util.List;
/**
 * Created by WZF on 2018/4/26.
 */
public interface ProductDAO {
    List<Product> getProductListByCategory(String categoryId);

    Product getProduct(String productId);

    List<Product> searchProductList(String keywords);
}
