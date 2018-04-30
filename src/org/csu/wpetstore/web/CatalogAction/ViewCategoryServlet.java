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

/**
 * Created by WZF on 2018/4/26.
 */
@WebServlet(name = "ViewCategoryServlet")
public class ViewCategoryServlet extends HttpServlet {
    private String categoryId = "";
    private static final String CATEGORY = "/WEB-INF/jsp/catalog/Category.jsp";
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoryId = request.getParameter("categoryId");
        String target = MAIN;
        if(!categoryId.equals("")) {
            System.out.println(categoryId);
            target = CATEGORY;
            CategoryService categoryService = new CategoryService();
            Category category = categoryService.getCategory(categoryId);
            if(category != null) {
                HttpSession session = request.getSession();
                //设置种类名
                session.setAttribute("category", category);
                List<Product> productList = categoryService.getProductListByCategory(categoryId);
                if(productList != null) {
                    //设置产品列表
                    session.setAttribute("productList", productList);
                }
            }
        }
        request.getRequestDispatcher(target).forward(request, response);
    }
}
