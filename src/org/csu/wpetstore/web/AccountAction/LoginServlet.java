package org.csu.wpetstore.web.AccountAction;

import org.csu.wpetstore.domain.Account;
import org.csu.wpetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WZF on 2018/4/29.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService accountService = new AccountService();
        String target = MAIN;
        Account account = accountService.getAccount(request.getParameter("username"), request.getParameter("password"));
        if(account == null) {
            String errorMessage = "Invalid username or password";
            request.setAttribute("errorMessage", errorMessage);
            //target = ERROR;
        } else {
            account.setPassword(null);
            request.getSession().setAttribute("account", account);
        }
        request.getRequestDispatcher(target).forward(request, response);
    }
}
