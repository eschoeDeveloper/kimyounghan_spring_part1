<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <meta charset="UTF-8">
   <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
   <thead>
       <tr>
              <td>ID</td>
              <td>이름</td>
              <td>나이</td>
          </tr>
   </thead>
   <tbody>
      <c:forEach var="item" items="${memberList}">
         <tr>
            <td>${item.id}</td>
            <td>${item.username}</td>
            <td>${item.age}</td>
         </tr>
      </c:forEach>
   </tbody>
</table>
</body>
</html>
