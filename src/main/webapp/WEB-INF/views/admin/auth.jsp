<%--
  Created by IntelliJ IDEA.
  User: janghyeon
  Date: 2020/03/21
  Time: 2:56 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <category>Janghyeon Jung</category>
</head>
<body>
    <% {
        String url = (String)request.getAttribute("url");
    %>
    <a href = "<%out.print(url);}%>" target = "_blank"> Get TokenKey </a>
    <form name = "getToken" method = "POST" action = "getAuth">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input name = "token" type = "text" placeholder="token" class="form-control">
        <button name = "getAuth" value = "getAuth">OK</button>
    </form>
</body>
</html>
