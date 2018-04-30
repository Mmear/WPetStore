<%--
  Created by IntelliJ IDEA.
  User: WZF
  Date: 2018/4/29
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="Catalog">
    <form action="createNewAccount" method="get">
        <h3>User Information</h3>
        <table>
            <tr>
                <td>User ID:</td>
                <td><input type="text" name="username" value="Mirr"></td>
            </tr>
            <tr>
                <td>New password:</td>
                <td><input type="password" name="password" value="123456"></td>
            </tr>
            <tr>
                <td>Repeat password:</td>
                <td><input type="password" name="repeatedPassword" value="123456"></td>
            </tr>
        </table>
        <%@ include file="IncludeAccountFields.jsp"%>
        <input type="submit" name="newAccount" value="Save Account Information">
    </form>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>
