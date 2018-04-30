package org.csu.wpetstore.web.AccountAction;

import org.csu.wpetstore.domain.Account;
import org.csu.wpetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * Created by WZF on 2018/4/29.
 */
@WebServlet(name = "NewAccountServlet")
public class NewAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService accountService = new AccountService();
        Account account = new Account();
        account.setUsername(request.getParameter("username"));
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
        account.setBannerName(request.getParameter("favouriteCategory"));
        if(account.getFavouriteCategoryId()!= null && request.getParameter("bannerOption") != null) {
            account.setBannerOption(true);
        }
        accountService.insertAccount(account);
        request.getRequestDispatcher("/WEB-INF/jsp/account/SignonForm.jsp").forward(request, response);
//        Map<String, String[]> paraMap = request.getParameterMap();
//        Map<String, String> returnMap = new HashMap<>();
//        Set entrySet = paraMap.entrySet();
//        for(Iterator<Map.Entry<String, String[]>> itr = entrySet.iterator(); itr.hasNext();) {
//            Map.Entry<String, String[]> me = (Map.Entry) itr.next();
//            String okey = me.getKey().toString();
//            String[] oval = me.getValue();
//            String val;
//            if(null == oval) {
//                val = "";
//            }else {
//                val = oval[0];
//            }
//            String ch = (okey.substring(0,1)).toUpperCase();//将首字母变成大写
//            ch = ch.concat(okey.substring(1));
//            returnMap.put(ch, val);
//        }
//        Set anotherSet = returnMap.entrySet();
//        for(Iterator itr = anotherSet.iterator(); itr.hasNext();){
//            Map.Entry me = (Map.Entry)itr.next();
//            System.out.println("get" + me.getKey() + ": " + me.getValue());
//        }
    }
}
