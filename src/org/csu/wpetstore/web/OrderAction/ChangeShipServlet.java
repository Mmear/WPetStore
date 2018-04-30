package org.csu.wpetstore.web.OrderAction;

import org.csu.wpetstore.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by WZF on 2018/4/30.
 */
@WebServlet(name = "ChangeShipServlet")
public class ChangeShipServlet extends HttpServlet {
    private static final String CONFIRM = "/WEB-INF/jsp/order/ConfirmOrder.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Order nowOrder = (Order) session.getAttribute("order");
        nowOrder.setShipToFirstName(request.getParameter("shipToFirstName"));
        nowOrder.setShipToLastName(request.getParameter("shipToLastName"));
        nowOrder.setShipAddress1(request.getParameter("shipAddress1"));
        nowOrder.setShipAddress2(request.getParameter("shipAddress2"));
        nowOrder.setShipCity(request.getParameter("shipCity"));
        nowOrder.setShipState(request.getParameter("shipState"));
        nowOrder.setShipZip(request.getParameter("shipZip"));
        nowOrder.setShipCountry(request.getParameter("shipCountry"));
        request.getRequestDispatcher(CONFIRM).forward(request, response);
    }
}
