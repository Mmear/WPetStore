<%--
  Created by IntelliJ IDEA.
  User: WZF
  Date: 2018/4/28
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="BackLink">
    <a href="main"><span>Return to Menu</span></a>
</div>

<div id="Catalog">
    <div id="Cart">
        <h2>Shopping Cart</h2>
        <form method="post" action="updateCartQuantities">
            <table>
                <tr>
                    <th><b>Item ID</b></th>
                    <th><b>Product ID</b></th>
                    <th><b>Description</b></th>
                    <th><b>In Stock?</b></th>
                    <th><b>Quantity</b></th>
                    <th><b>List Price</b></th>
                    <th><b>Total Cost</b></th>
                    <th>&nbsp;</th>
                </tr>

                <c:if test="${sessionScope.cart.numberOfItems == 0}">
                    <tr>
                        <td colspan="8"><b>Your cart is empty.</b></td>
                    </tr>
                </c:if>

                <c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
                    <tr>
                        <td>
                                <!-- 到checkout页面 -->
                                <a href="getItem?itemId=${cartItem.item.itemId}"><span>${cartItem.item.itemId}</span></a>
                        </td>
                        <td>
                                ${cartItem.item.product.productId}
                        </td>
                        <td>
                                ${cartItem.item.attribute1} ${cartItem.item.attribute2}
                                ${cartItem.item.attribute3} ${cartItem.item.attribute4}
                                ${cartItem.item.attribute5} ${cartItem.item.product.name}
                        </td>
                        <td>${cartItem.inStock}</td>
                        <td>
                            <input type="text" name="${cartItem.item.itemId}" value="${cartItem.quantity}">
                        </td>
                        <td>
                            <fmt:formatNumber value="${cartItem.item.listPrice}" pattern="$#,##0.00" />
                        </td>
                        <td>
                            <fmt:formatNumber value="${cartItem.total}" pattern="$#,##0.00" />
                        </td>
                        <td>
                                <a class="button" href="removeItemFromCart?itemId=${cartItem.item.itemId}"><b style="color: red">Remove</b></a>
                        </td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="7">
                        <span>Sub Total:</span>
                        <fmt:formatNumber value="${sessionScope.cart.subTotal}" pattern="$#,##0.00" />
                        <input class="button" type="submit" name="updateButton" value="UpdateCart">
                    </td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </form>
        <c:if test="${sessionScope.cart.numberOfItems > 0}">
            <a href="toNewOrderForm"><span>Proceed to Checkout</span></a>
        </c:if>
    </div>
    <div id="Separator">&nbsp;</div>
</div>
<script>
    //更新sessionScope.cartItem数量
</script>
<%@ include file="../common/IncludeBottom.jsp"%>