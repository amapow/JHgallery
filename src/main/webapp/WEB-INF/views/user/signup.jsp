<%--
  Created by IntelliJ IDEA.
  User: janghyeon
  Date: 2020/03/09
  Time: 8:19 오후
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<html xmlns:th="http://www.thymeleaf.org">
<head>
    <category>Title</category>
</head>
<body>
<h1>회원 가입</h1>
<hr>

<form th:action="@{/user/signup}" method="post">
    <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}"/>
    <input type="text" name="email" placeholder="이메일 입력해주세요">
    <input type="password" name="password" placeholder="비밀번호">
    <button type="submit">가입하기</button>
</form>
</body>
</html>
