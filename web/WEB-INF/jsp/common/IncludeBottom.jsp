<%--
  Created by IntelliJ IDEA.
  User: WZF
  Date: 2018/4/25
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
</div>

<div id="Footer">

    <div id="PoweredBy">
        &nbsp<a href="http://www.csu.edu.cn">www.csu.edu.cn</a>
    </div>

    <div id="Banner">
        <c:if test="${sessionScope.account != null }">
            <c:if test="${sessionScope.account.bannerOption}">
                <img src="${sessionScope.account.bannerName}" alt="banner_img">
            </c:if>
        </c:if>
    </div>

</div>

</body>
</html>