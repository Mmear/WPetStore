<%--
  Created by IntelliJ IDEA.
  User: WZF
  Date: 2018/4/25
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="Welcome">
    <div id="WelcomeContent">
        Welcome to WPetStore!
    </div>
</div>
<div id="Main">
    <div id="Sidebar">
        <div id="SidebarContent">
            <a href="getCategory?categoryId=FISH"><img src="image/fish_icon.gif" /></a>
            <br/> Saltwater, Freshwater <br/>
            <a href="getCategory?categoryId=DOGS"><img src="image/dogs_icon.gif" /></a>
            <br /> Various Breeds <br />
            <a href="getCategory?categoryId=CATS"><img src="image/cats_icon.gif" /></a>
            <br /> Various Breeds, Exotic Varieties <br />
            <a href="getCategory?categoryId=REPTILES"><img src="image/reptiles_icon.gif" /></a>
            <br /> Lizards, Turtles, Snakes <br />
            <a href="getCategory?categoryId=BIRDS"><img src="image/birds_icon.gif" /></a>
            <br /> Exotic Varieties
        </div>
    </div>

    <div id="MainImage">
        <div id="MainImageContent">
            <map name="estoremap">
                <area alt="Birds" coords="72,2,280,250" href="getCategory?categoryId=BIRDS" shape="rect" />
                <area alt="Fish" coords="2,180,72,250" href="getCategory?categoryId=FISH" shape="rect" />
                <area alt="Dogs" coords="60,250,130,320" href="getCategory?categoryId=DOGS" shape="rect" />
                <area alt="Reptiles" coords="140,270,210,340" href="getCategory?categoryId=REPTILES" shape="rect" />
                <area alt="Cats" coords="225,240,295,310" href="getCategory?categoryId=CATS" shape="rect" />
                <area alt="Birds" coords="280,180,350,250" href="getCategory?categoryId=BIRDS" shape="rect" />
            </map>
            <img height="355" src="image/splash.gif" align="middle" usemap="#estoremap" width="350" />
        </div>
    </div>
    <div id="Separator">&nbsp;</div>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>		
