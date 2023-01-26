<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
성공
<ul>
<%--  <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>--%>
<%--  프로퍼티가 자동으로 처리해줌 (값을 안넣으면 getAttribute로, 넣으면 setAttribute로 인식)--%>
  <li>id=${member.id}</li>
  <li>username=${member.username}</li>
  <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
