<%--
  Created by IntelliJ IDEA.
  User: WZF
  Date: 2018/4/25
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="BackLink">
    <a href="main">Return to Main Menu</a>
</div>

<div id="Catalog">
    <h2>${sessionScope.category.name}</h2>
    <table>
        <tr>
            <th>Product ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="product" items="${sessionScope.productList}">
            <tr>
                <td>
                    <a href="getProduct?productId=${product.productId}">
                     <span>${product.productId}</span>
                   </a>
                </td>
                <td>${product.name}</td>
            </tr>
        </c:forEach>
    </table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>
