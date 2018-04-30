<%--
  Created by IntelliJ IDEA.
  User: WZF
  Date: 2018/4/28
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
    <stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
    Return to Main Menu
</stripes:link>
</div>

<div id="Catalog">

    <table>
        <tr>
            <th>&nbsp;</th>
            <th>Product ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="product" items="${sessionScope.resultList}">
            <tr>
                <td>
                    <%--<stripes:link--%>
                        <%--beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"--%>
                        <%--event="viewProduct">--%>
                    <%--<stripes:param name="productId" value="${product.productId}" />--%>
                    <%--${product.description}--%>
                <%--</stripes:link>--%>
                        <img src="image/${product.description}" alt="img_product">
                </td>
                <td>
                    <%--<b> <stripes:link--%>
                        <%--beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"--%>
                        <%--event="viewProduct">--%>
                    <%--<stripes:param name="productId" value="${product.productId}" />--%>
                    <%--<font color="BLACK"> ${product.productId} </font>--%>
                <%--</stripes:link> </b>--%>
                        <span>${product.productId}</span>
                </td>
                <td>
                    <a href="getProduct?productId=${product.productId}"><span>${product.name}</span></a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
        </tr>

    </table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>
