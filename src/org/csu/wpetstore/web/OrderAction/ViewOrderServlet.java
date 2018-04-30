package org.csu.wpetstore.web.OrderAction;

import org.csu.wpetstore.domain.LineItem;
import org.csu.wpetstore.domain.Order;
import org.csu.wpetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by WZF on 2018/4/30.
 * ¥”MyOrder“≥√Ê∑√Œ 
 */
@WebServlet(name = "ViewOrderServlet")
public class ViewOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer orderId = Integer.parseInt(request.getParameter("orderId"));
        OrderService orderService = new OrderService();

        Order selectedOrder = orderService.getOrder(orderId);
        if(selectedOrder != null) {
            request.getSession().setAttribute("order", selectedOrder);
            request.getRequestDispatcher("WEB-INF/jsp/order/ViewOrder.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("WEB-INF/jsp/catalog/Main.jsp").forward(request, response);
        }
    }
}
