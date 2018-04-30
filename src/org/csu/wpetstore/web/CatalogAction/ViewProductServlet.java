package org.csu.wpetstore.web.CatalogAction;

import com.sun.xml.internal.ws.resources.HttpserverMessages;
import org.csu.wpetstore.domain.Category;
import org.csu.wpetstore.domain.Item;
import org.csu.wpetstore.domain.Product;
import org.csu.wpetstore.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by WZF on 2018/4/27.
 */
@WebServlet(name = "ViewProductServlet")
public class ViewProductServlet extends HttpServlet {
    private String productId = "";
    private static final String PRODUCT = "/WEB-INF/jsp/catalog/Product.jsp";
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productId = request.getParameter("productId");
        String target = MAIN;
        if(!productId.equals("")) {
            CategoryService categoryService = new CategoryService();
            //��ȡ��Ʒ
            Product pro = categoryService.getProduct(productId);
            //��ȡ��ϸ��Ʒ�б�
            List<Item> itemList = categoryService.getItemListByProduct(productId);
            if(itemList != null) {
                HttpSession session = request.getSession();
                //��鲢����session��category
                Category cat = (Category) session.getAttribute("category");
                if(cat == null || cat.getCategoryId() != pro.getCategoryId()){
                    //����ʱproduct��category��session�еĲ�һ�£�����
                    Category new_cat = categoryService.getCategoryByProductId(productId);
                    session.setAttribute("category", new_cat);
                }
                session.setAttribute("product", pro);
                session.setAttribute("itemList", itemList);
                itemList.toString();
                target = PRODUCT;
            }
        }
        request.getRequestDispatcher(target).forward(request, response);
    }
}
