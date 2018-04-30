<%--
  Created by IntelliJ IDEA.
  User: WZF
  Date: 2018/4/25
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="StyleSheet" href="css/jpetstore.css" type="text/css"
          media="screen" />

    <meta name="generator"
          content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
    <title>JPetStore Demo</title>
    <meta content="text/html; charset=windows-1252"
          http-equiv="Content-Type" />
    <meta http-equiv="Cache-Control" content="max-age=0" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="Pragma" content="no-cache" />
</head>

<body>

<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="main"><img src="image/logo-topbar.gif" /></a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <a href="getCart"><img align="middle" name="img_cart" src="image/cart.gif" /></a>
            <img align="middle" src="image/separator.gif" />
            <c:if test="${sessionScope.account == null}">
                <a href="toLogin">Sign In</a>
            </c:if>
            <c:if test="${sessionScope.account != null}">
                 <a href="logout">Sign Out</a>
                <img align="middle" src="image/separator.gif" />
                 <a href="toEditAccount">My Account</a>
            </c:if>
            <img align="middle" src="image/separator.gif" />
            <a href="../help.html">?</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <form action="search" method="post">
                <input type="text" name="keyword" size="14" /> <input type="submit" name="searchProducts" value="Search" />
            </form>
        </div>
    </div>

    <div id="QuickLinks">
        <a href="getCategory?categoryId=FISH">
            <img src="image/sm_fish.gif" />
        </a>
            <img src="image/separator.gif" />
        <a href="getCategory?categoryId=DOGS">
            <img src="image/sm_dogs.gif" />
        </a>
            <img src="image/separator.gif" />
        <a href="getCategory?categoryId=REPTILES">
            <img src="image/sm_reptiles.gif" />
        </a>
        <img src="image/separator.gif" />
        <a href="getCategory?categoryId=CATS">
            <img src="image/sm_cats.gif" /></a>
        <img src="image/separator.gif" />
        <a href="getCategory?categoryId=BIRDS">
            <img src="image/sm_birds.gif" />
        </a>
    </div>

</div>

<div id="Content">