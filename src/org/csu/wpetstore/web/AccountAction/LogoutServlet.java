package org.csu.wpetstore.web.AccountAction;

import org.csu.wpetstore.domain.Account;

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
@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer url = request.getRequestURL();
        String head = request.getHeader("Referer");
        System.out.println(url.toString());
        System.out.println(head);
        HttpSession session = request.getSession();
        if(session.getAttribute("account") != null) {
            session.setAttribute("account", null);
            // session.invalidate();
        }
        request.getRequestDispatcher("/WEB-INF/jsp/catalog/Main.jsp").forward(request, response);
    }
}
