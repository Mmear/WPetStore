package org.csu.wpetstore.web.CatalogAction;

import org.csu.wpetstore.domain.Cart;
import org.csu.wpetstore.domain.Category;
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
@WebServlet(name = "AddItemToCartServlet")
public class AddItemToCartServlet extends HttpServlet {
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
            if(cart == null){
                cart = new Cart();
            }
            CategoryService catalogService = new CategoryService();
            if(cart.containsItemId(itemId)) {
                System.out.println("At here!");
                cart.incrementQuantityByItemId(itemId);
            }else {
                // isInStock is a "real-time" property that must be updated
                // every time an item is added to the cart, even if other
                // item details are cached.
                boolean isInStock = catalogService.isItemInStock(itemId);
                Item item = catalogService.getItem(itemId);
                cart.addItem(item, isInStock);
            }
            session.setAttribute("cart", cart);
            target = CART;
        }
        request.getRequestDispatcher(target).forward(request, response);
    }
}
