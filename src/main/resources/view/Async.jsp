<%--
  Created by IntelliJ IDEA.
  User: ajing
  Date: 2018/4/12
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="../js/jquery-1.4.4.min.js"></script>
<script>
    function deferred() {
        $.get("defer",function (data) {
            console.log(data);
            deferred();
        })
    }

    deferred();
</script>

</body>
</html>
