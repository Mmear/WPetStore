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
 * Created by WZF on 2018/4/30.
 */
@WebServlet(name = "EditAccountServlet")
public class EditAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService accountService = new AccountService();
        Account account = (Account) request.getSession().getAttribute("account");
        account.setPassword(request.getParameter("password"));
        account.setFirstName(request.getParameter("firstName"));
        account.setLastName(request.getParameter("lastName"));
        account.setAddress1(request.getParameter("address1"));
        account.setAddress2(request.getParameter("address2"));
        account.setEmail(request.getParameter("email"));
        account.setPhone(request.getParameter("phone"));
        account.setCountry(request.getParameter("country"));
        account.setZip(request.getParameter("zip"));
        account.setState(request.getParameter("state"));
        account.setStatus(request.getParameter("status"));
        account.setLanguagePreference(request.getParameter("languagePreference"));
        account.setFavouriteCategoryId(request.getParameter("favouriteCategory"));
        if(request.getParameter("bannerOption") != null) {
            account.setBannerOption(true);
        }
        accountService.updateAccount(account);
        request.getSession().setAttribute("account", account);
        request.getRequestDispatcher("/WEB-INF/jsp/catalog/Main.jsp").forward(request, response);
    }
}
