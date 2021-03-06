package org.csu.wpetstore.web.AccountAction;

import org.csu.wpetstore.domain.Account;
import org.csu.wpetstore.service.AccountService;

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
@WebServlet(name = "ViewAccountFormServlet")
public class ViewAccountFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/account/NewAccountForm.jsp").forward(request, response);
    }
}
