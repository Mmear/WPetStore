package org.csu.wpetstore.persistence;
import org.csu.wpetstore.domain.Item;
import java.util.List;
import java.util.Map;

/**
 * Created by WZF on 2018/4/26.
 */
public interface ItemDAO {
    //���¿������
    void updateInventoryQuantity(Map<String, Object> param);
    //��ȡ�������
    int getInventoryQuantity(String itemId);
    //���ݲ�Ʒ�Ż�ȡ��Ʒ��ϸ��Ŀ�б�
    List<Item> getItemListByProduct(String productId);
    //������ϸ��ĿID��ȡ
    Item getItem(String itemId);
}
