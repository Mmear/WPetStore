package org.csu.wpetstore.web.OrderAction;

import org.csu.wpetstore.domain.Account;
import org.csu.wpetstore.domain.Cart;
import org.csu.wpetstore.domain.Order;
import org.csu.wpetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WZF on 2018/4/30.
 */
@WebServlet(name = "ViewNewOrderFormServlet")
public class ViewNewOrderFormServlet extends HttpServlet {
    private static final String ORDER = "/WEB-INF/jsp/order/NewOrderForm.jsp";
    private static final String LOGIN = "/WEB-INF/jsp/account/SignonForm.jsp";
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String target = MAIN;
        HttpSession session = request.getSession();
        List<String> cardList = new ArrayList<String>();
        cardList.add("Visa");
        cardList.add("MasterCard");
        cardList.add("American Express");
        session.setAttribute("cardList", cardList);
        Account account = (Account) session.getAttribute("account");
        if(account == null) {
            request.setAttribute("ErrorMessage", "You must sign on before attempting to check out.  Please sign on and try checking out again.");
            target = LOGIN;
        }else {
            Cart cart = (Cart) session.getAttribute("cart");
            if(cart != null) {
                OrderService orderService = new OrderService();
                Order order = new Order();
                order.initOrder(account, cart);
                orderService.insertOrder(order);
                session.setAttribute("order", order);
                target = ORDER;
            }else {
                request.setAttribute("ErrorMessage", "An order could not be created because a cart could not be found.");
                //target = ERROR;
            }
        }
        request.getRequestDispatcher(target).forward(request, response);
    }
}
