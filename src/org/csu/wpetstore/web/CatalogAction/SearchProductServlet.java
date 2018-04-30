package org.csu.wpetstore.web.CatalogAction;

import org.csu.wpetstore.domain.Category;
import org.csu.wpetstore.domain.Product;
import org.csu.wpetstore.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by WZF on 2018/4/28.
 */
@WebServlet(name = "SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
    String keyWord = "";
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String RESULT = "/WEB-INF/jsp/catalog/SearchProduct.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        keyWord = request.getParameter("keyword");
        String target = MAIN;
        if(!keyWord.equals("")) {
            CategoryService categoryService = new CategoryService();
            List<Product> resultList = categoryService.searchProductList(keyWord);
            if (resultList != null) {
                HttpSession session = request.getSession();
                session.setAttribute("resultList", resultList);
                target = RESULT;
            }
        }
        request.getRequestDispatcher(target).forward(request, response);
    }
}
