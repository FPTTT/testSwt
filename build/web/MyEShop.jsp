<%-- 
    Document   : MyEShop
    Created on : Oct 31, 2023, 12:07:26 AM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #bag{
                text-align: right;
                margin-right: 30px;
                margin-top: 30px;
            }

            table {
                border-collapse: collapse;
            }

        </style>
    </head>
    <body>
        <c:set value="${sessionScope.size}" var="size"/>
        Hello ${sessionScope.account.name}
        <p id="bag"><img src="images/cart.png" width="50px" height="50px"/>
            <a href="MyEcart.jsp">Mybag (${not empty size?size:0}) items</a></p>

        <h1>The list of products</h1>
        <form name="f" action="" method="post">
            Enter the number of items to by:
            <input type="number" name="num" value="1"/>
            <hr/>

            <table border="1px" width="40%">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
                <jsp:useBean id="db" class="dal.ProductDAO" />
                <c:forEach items="${db.all}" var="p">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td>${p.quantity}</td>
                        <td><input type="submit" onclick="buy('${p.id}')" value="By item"></td>
                    </tr>                   
                </c:forEach>
            </table>


        </form>

        <script type="text/javascript">
            function buy(id) {
                document.f.action = "buy?id=" + id;
                document.f.submit();
            }

        </script>
    </body>


</html>
