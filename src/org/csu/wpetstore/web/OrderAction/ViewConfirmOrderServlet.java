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
@WebServlet(name = "ViewConfirmOrderServlet")
public class ViewConfirmOrderServlet extends HttpServlet {
    private static final String CONFIRM = "/WEB-INF/jsp/order/ConfirmOrder.jsp";
    private static final String SHIP = "/WEB-INF/jsp/order/ShippingForm.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String target = CONFIRM;
        Order nowOrder = (Order)session.getAttribute("order");
        nowOrder.setCardType(request.getParameter("cardType"));
        nowOrder.setCreditCard(request.getParameter("creditCard"));
        nowOrder.setExpiryDate(request.getParameter("expiryDate"));
        nowOrder.setBillToFirstName(request.getParameter("billToFirstName"));
        nowOrder.setBillToLastName(request.getParameter("billToLastName"));
        nowOrder.setBillAddress1(request.getParameter("billAddress1"));
        nowOrder.setBillAddress2(request.getParameter("billAddress2"));
        nowOrder.setBillCity(request.getParameter("billCity"));
        nowOrder.setBillState(request.getParameter("billState"));
        nowOrder.setBillZip(request.getParameter("billZip"));
        nowOrder.setBillCountry(request.getParameter("billCountry"));
        if(request.getParameter("shippingAddressRequired") != null) {
            target = SHIP;
        }
        request.getRequestDispatcher(target).forward(request, response);
    }
}
