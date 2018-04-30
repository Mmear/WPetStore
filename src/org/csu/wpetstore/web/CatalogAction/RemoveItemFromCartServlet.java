package org.csu.wpetstore.web.CatalogAction;

import org.csu.wpetstore.domain.Cart;
import org.csu.wpetstore.domain.Item;
import org.csu.wpetstore.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by WZF on 2018/4/29.
 */
@WebServlet(name = "RemoveItemFromCartServlet")
public class RemoveItemFromCartServlet extends HttpServlet {
    String itemId = "";
    private static final String CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        itemId = request.getParameter("itemId");
        System.out.println(itemId);
        String target = MAIN;
        if(!itemId.equals("")) {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            Item item = cart.removeItemById(itemId);
            if(item == null) {
                //��ֹ����ɾ���ɹ����ֻ���ҳ����ɾһ��
                //��������ҳ��
                //target = ERROR;
            } else {
                target = CART;
            }
        }
        request.getRequestDispatcher(target).forward(request, response);
    }
}
