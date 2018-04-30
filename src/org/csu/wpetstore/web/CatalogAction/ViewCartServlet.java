package org.csu.wpetstore.web.CatalogAction;

import org.csu.wpetstore.domain.Cart;

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
@WebServlet(name = "ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
    private static final String CART = "/WEB-INF/jsp/cart/Cart.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart == null) {
            cart = new Cart();
        }
        session.setAttribute("cart", cart);
        request.getRequestDispatcher(CART).forward(request, response);
    }
}
