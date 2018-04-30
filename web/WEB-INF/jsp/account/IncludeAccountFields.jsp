<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WZF
  Date: 2018/4/29
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<h3>Account Information</h3>

<table>
    <tr>
        <td>First name:</td>
        <td><input type="text" name="firstName" value=${sessionScope.account.firstName}></td>
    </tr>
    <tr>
        <td>Last name:</td>
        <td><input type="text" name="lastName" value=${sessionScope.account.lastName}></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><input type="text" size="40" name="email" value=${sessionScope.account.email}></td>
    </tr>
    <tr>
        <td>Phone:</td>
        <td><input type="text" name="phone" value=${sessionScope.account.phone}></td>
    </tr>
    <tr>
        <td>Address 1:</td>
        <td><input type="text" size="40" name="address1" value=${sessionScope.account.address1}></td>
    </tr>
    <tr>
        <td>Address 2:</td>
        <td><input type="text" size="40" name="address2" value=${sessionScope.account.address2}></td>
    </tr>
    <tr>
        <td>City:</td>
        <td><input type="text" name="city" value=${sessionScope.account.city}></td>
    </tr>
    <tr>
        <td>State:</td>
        <td><input type="text" size="4" name="state" value=${sessionScope.account.state}></td>
    </tr>
    <tr>
        <td>Zip:</td>
        <td><input type="text" size="10" name="zip" value=${sessionScope.account.zip}></td>
    </tr>
    <tr>
        <td>Country:</td>
        <td><input type="text" size="15" name="country" value=${sessionScope.account.country}></td>
    </tr>
</table>

<h3>Profile Information</h3>
<table>
    <tr>
        <td>Language Preference:${sessionScope.account.languagePreference}</td>
        <td>
            <select name="languagePreference" id="selectLanPrefer">
                <c:forEach var="item" items="${sessionScope.langList}">
                    <option value=${item}>${item}</option>
                </c:forEach>
            </select>
        </td>
    </tr>

    <tr>
        <td>Favourite Category:${sessionScope.account.favouriteCategoryId}</td>
        <td>
            <select name="favouriteCategory" id="selectFavourCate">
                <c:forEach var="item" items="${sessionScope.catList}">
                    <option value=${item}>${item}</option>
                </c:forEach>
            </select>
        </td>
    </tr>

    <tr>
        <td>Enable MyBanner</td>
        <td>
            <input type="checkbox" name="bannerOption" value="activeBanner">
        </td>
    </tr>
</table>
