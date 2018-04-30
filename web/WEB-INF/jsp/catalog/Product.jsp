<%--
  Created by IntelliJ IDEA.
  User: WZF
  Date: 2018/4/27
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>


<div id="BackLink">
        <a href="getCategory?categoryId=${sessionScope.category.categoryId}">Return to ${sessionScope.category.name}</a>
</div>

<div id="Catalog">

    <h2>${actionBean.category.name}</h2>
    <table>
        <tr>
            <th>Item ID</th>
            <th>Product ID</th>
            <th>Description</th>
            <th>List Price</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach var="item" items="${sessionScope.itemList}">
            <tr>
                <td>
                        <a href="getItem?itemId=${item.itemId}"><span>${item.itemId}</span></a>
                </td>
                <td>${item.productId}</td>
                <td>${item.attribute1} ${item.attribute2} ${item.attribute3}
                        ${item.attribute4} ${item.attribute5} ${sessionScope.product.name}
                </td>
                <td>
                    <fmt:formatNumber value="${item.listPrice}" pattern="$#,##0.00" />
                </td>
                <td>
                        <a href="addItemToCart?itemId=${item.itemId}"><span>Add to Cart</span></a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>
            </td>
        </tr>
    </table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>