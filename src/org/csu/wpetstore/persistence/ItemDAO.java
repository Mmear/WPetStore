package org.csu.wpetstore.persistence;
import org.csu.wpetstore.domain.Item;
import java.util.List;
import java.util.Map;

/**
 * Created by WZF on 2018/4/26.
 */
public interface ItemDAO {
    //更新库存数量
    void updateInventoryQuantity(Map<String, Object> param);
    //获取库存数量
    int getInventoryQuantity(String itemId);
    //根据产品号获取产品详细项目列表
    List<Item> getItemListByProduct(String productId);
    //根据详细项目ID获取
    Item getItem(String itemId);
}
