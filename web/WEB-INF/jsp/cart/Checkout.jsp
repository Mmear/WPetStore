<%--
  Created by IntelliJ IDEA.
  User: WZF
  Date: 2018/4/28
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.CartActionBean">
    Return to Shopping Cart</stripes:link></div>
<div id="Catalog">
    <table>
        <tr>
            <td>
                <h2>Checkout Summary</h2>
                <table>
                    <tr>
                        <td><b>Item ID</b></td>
                        <td><b>Product ID</b></td>
                        <td><b>Description</b></td>
                        <td><b>In Stock?</b></td>
                        <td><b>Quantity</b></td>
                        <td><b>List Price</b></td>
                        <td><b>Total Cost</b></td>
                    </tr>

                    <c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
                        <tr>
                            <td>
                                <a href="getItem?itemId=${cartItem.item.itemId}"><span>${cartItem.item.itemId}</span></a>
                            </td>
                            <td>${cartItem.item.product.productId}</td>
                            <td>
                                    ${cartItem.item.attribute1} ${cartItem.item.attribute2}
                                    ${cartItem.item.attribute3} ${cartItem.item.attribute4}
                                    ${cartItem.item.attribute5} ${cartItem.item.product.name}
                            </td>
                            <td>${cartItem.inStock}</td>
                            <td>${cartItem.quantity}</td>
                            <td><fmt:formatNumber value="${cartItem.item.listPrice}" pattern="$#,##0.00" /></td>
                            <td><fmt:formatNumber value="${cartItem.total}" pattern="$#,##0.00" /></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="7">
                            Sub Total: <fmt:formatNumber value="${actionBean.cart.subTotal}" pattern="$#,##0.00" />
                        </td>
                    </tr>
                </table>
            <td>&nbsp;</td>
        </tr>
    </table>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>