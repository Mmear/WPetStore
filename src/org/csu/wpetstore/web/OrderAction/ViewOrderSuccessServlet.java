package org.csu.wpetstore.web.OrderAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WZF on 2018/4/30.
 */
@WebServlet(name = "ViewOrderSuccessServlet")
public class ViewOrderSuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ThanksMessage","Thank you for your money!");
        request.getRequestDispatcher("WEB-INF/jsp/order/ViewOrder.jsp").forward(request, response);
    }
}
