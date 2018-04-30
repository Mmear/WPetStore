package org.csu.wpetstore.web.CatalogAction;

import org.csu.wpetstore.domain.Cart;
import org.csu.wpetstore.domain.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by WZF on 2018/4/29.
 */
@WebServlet(name = "UpdateCartQuantitiesServlet")
/*更新购物车列表，将等于0的item移除*/
public class UpdateCartQuantitiesServlet extends HttpServlet {
    private static final String CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String target = MAIN;
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Iterator<CartItem> cartItems = cart.getAllCartItems();
        while (cartItems.hasNext()) {
            CartItem cartItem = (CartItem) cartItems.next();
            String itemId = cartItem.getItem().getItemId();
            try {
                int quantity = Integer.parseInt((String) request.getParameter(itemId));
                cart.setQuantityByItemId(itemId, quantity);
                if (quantity < 1) {
                    cartItems.remove();
                }
            } catch (Exception e) {
                //ignore parse exceptions on purpose
            }
            target = CART;
        }
        request.getRequestDispatcher(CART).forward(request, response);
    }
}
