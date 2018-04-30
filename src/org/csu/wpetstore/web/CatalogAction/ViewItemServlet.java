package org.csu.wpetstore.web.CatalogAction;

import org.csu.wpetstore.domain.Category;
import org.csu.wpetstore.domain.Item;
import org.csu.wpetstore.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WZF on 2018/4/27.
 */
@WebServlet(name = "ViewItemServlet")
public class ViewItemServlet extends HttpServlet {
    private String itemId = "";
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String ITEM = "/WEB-INF/jsp/catalog/Item.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        itemId = request.getParameter("itemId");
        String target = MAIN;
        if(!itemId.equals("")) {
            CategoryService categoryService = new CategoryService();
            //获取单个详细产品
            Item item = new Item();
            item = categoryService.getItem(itemId);
            if(item != null) {
                target = ITEM;
                request.getSession().setAttribute("item", item);
            }
        }
        request.getRequestDispatcher(target).forward(request, response);
    }
}
