<%--
  Created by IntelliJ IDEA.
  User: WZF
  Date: 2018/4/26
  Time: 23:57
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="BackLink">
    <a href="getProduct?productId=${sessionScope.product.productId}">Return to ${sessionScope.product.name}</a>
</div>

<div id="Catalog">
    <table>
        <tr>
            <td><img src="image/${sessionScope.product.description}" alt="item_img"></td>
        </tr>
        <tr>
            <td><b> ${sessionScope.item.itemId} </b></td>
        </tr>
        <tr>
            <td>
                <b>
                    ${sessionScope.item.attribute1}${sessionScope.item.attribute2}${sessionScope.item.attribute3}${sessionScope.item.attribute4} ${sessionScope.item.attribute5}
                      ${sessionScope.product.name}
                </b>
            </td>
        </tr>
        <tr>
            <td>${sessionScope.product.name}</td>
        </tr>
        <tr>
            <td><c:if test="${sessionScope.item.quantity <= 0}">
                Back ordered.
            </c:if> <c:if test="${sessionScope.item.quantity > 0}">
                ${sessionScope.item.quantity} in stock.
            </c:if></td>
        </tr>
        <tr>
            <td><fmt:formatNumber value="${sessionScope.item.listPrice}"
                                  pattern="$#,##0.00" /></td>
        </tr>
        <tr>
            <td>
                <%--<stripes:link class="Button"--%>
                              <%--beanclass="org.mybatis.jpetstore.web.actions.CartActionBean"--%>
                              <%--event="addItemToCart">--%>
                <%--<stripes:param name="workingItemId" value="${sessionScope.item.itemId}" />--%>
                <%--Add to Cart--%>
            <%--</stripes:link>--%>
                    <a href="addItemToCart?itemId=${sessionScope.item.itemId}"><span >Add to cart</span></a>
            </td>
        </tr>
    </table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>
