<%@ page import="org.hello.servlet.domain.Member" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%
   Member saveMember = (Member) request.getAttribute("member");
%>

<html>
<head>
   <meta charset="UTF-8">
   <title>Title</title>
</head>
<body>
성공
<ul>
   <li>id: <%= saveMember.getId() %></li>
   <li>username: <%= saveMember.getUsername() %></li>
   <li>age: <%= saveMember.getAge() %></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
