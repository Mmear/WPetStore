package org.csu.wpetstore.web.CatalogAction;

import com.sun.org.apache.xerces.internal.util.HTTPInputSource;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by WZF on 2018/4/25.
 */
public class MainServlet extends javax.servlet.http.HttpServlet {
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<String> langList = new ArrayList<String>();
        langList.add("English");
        langList.add("Japanese");
        langList.add("Chinese");
        List<String> catList = new ArrayList<String>();
        catList.add("FISH");
        catList.add("DOGS");
        catList.add("REPTILES");
        catList.add("CATS");
        catList.add("BIRDS");

        HttpSession session = request.getSession();
        session.setAttribute("langList", langList);
        session.setAttribute("catList", catList);
        request.getRequestDispatcher(MAIN).forward(request, response);
    }
}
