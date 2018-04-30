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
    <form action="login" method="post">
        <p>Please enter your username and password.</p>
        <p>
            UserName: <input type="text" name="username" value="j2ee">
            <br/>
            Password: <input type="text" name="password" value="j2ee">
        </p>
        <input type="submit" value="Login">
    </form>
    Need a user name and password?
    <a href="toAccountForm"><span>Register Now!</span></a>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>
