<%--
  Created by IntelliJ IDEA.
  User: ajing
  Date: 2018/4/12
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="upload">
        <form action="upload" enctype="multipart/form-data" method="post">
            <input name="file" type="file"/>
            <input  type="submit" value="上传"/>
        </form>
    </div>
</body>
</html>
