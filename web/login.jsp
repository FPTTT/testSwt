<%-- 
    Document   : login
    Created on : Nov 1, 2023, 10:01:38 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Username:<input type="text" name="txtUsername" value="" /></br>
            Password:<input type="password" name="txtPassword" value="" /></br>
            <input type="submit" value="Login" name="btAction" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
