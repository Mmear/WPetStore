<%--
  Created by IntelliJ IDEA.
  User: WZF
  Date: 2018/4/29
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="Catalog">
    <form action="editAccount" method="get">
        <h3>User Information</h3>
        <table>
            <tr>
                <td>User ID:</td>
                <td>${sessionScope.account.username}</td>
            </tr>
            <tr>
                <td>New password:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>Repeat password:</td>
                <td><input type="password" name="repeatedPassword"></td>
            </tr>
        </table>
        <%@ include file="IncludeAccountFields.jsp"%>
        <input type="submit" name="editAccount" value="Save Account Information">
    </form>
    <h3><a href="toOrderList">My Orders</a></h3>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>

