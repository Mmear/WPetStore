package org.csu.wpetstore.web.OrderAction;

import org.csu.wpetstore.domain.Account;
import org.csu.wpetstore.domain.Order;
import org.csu.wpetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by WZF on 2018/4/30.
 */
@WebServlet(name = "ViewOrderListServlet")
public class ViewOrderListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrderService orderService = new OrderService();
        Account account = (Account)session.getAttribute("account");
        List<Order> orderList = orderService.getOrderByUsername(account.getUsername());
        session.setAttribute("orderList", orderList);
        request.getRequestDispatcher("WEB-INF/jsp/order/ListOrders.jsp").forward(request, response);
    }
}
