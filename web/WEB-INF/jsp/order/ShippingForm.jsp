<%--
  Created by IntelliJ IDEA.
  User: WZF
  Date: 2018/4/28
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
    <form action="changeShip">
        <table>
            <tr>
                <th colspan=2>Shipping Address</th>
            </tr>

            <tr>
                <td>First name:</td>
                <td><input type="text" name="shipToFirstName"></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><input type="text" name="shipToLastName"></td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td><input type="text" size="40" name="shipAddress1"></td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td><input type="text" size="40" name="shipAddress2"></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input type="text" name="shipCity"></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><input type="text" size="4" name="shipState"></td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td><input type="text" size="10" name="shipZip"></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" size="15" name="shipCountry" /></td>
            </tr>
        </table>
        <input type="submit" value="Continue">
    </form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>