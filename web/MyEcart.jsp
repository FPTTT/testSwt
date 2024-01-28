<%-- 
    Document   : MyEcart
    Created on : Oct 31, 2023, 12:48:46 AM
    Author     : Admin
--%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <style>
        a {
            text-decoration: none;

        }

        table {
            border-collapse: collapse;
        }
    </style>
    <body>
        <h1>Shopping cart online</h1>
        <table border="1px" width="40%">           
            <tr>
                <th>No</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Money</th>
                <th>Action</th>
            </tr>
            <c:set value="${sessionScope.cart}" var="o"/>
            <c:set value="0" var="t"/>
            <c:forEach items="${o.items}" var="i">
                <c:set value="${t + 1}" var="t"/>

                <tr>
                    <td>${t}</td>
                    <td>${i.product.name}</td>
                    <td>
                        <button><a href="process?num=-1&id=${i.product.id}">-₫</a></button>
                        <input type="text" readonly value="${i.quantity}">
                        <button><a href="process?num=1&id=${i.product.id}">+</a></button>
                    </td>
                    <td><fmt:formatNumber pattern="##.#" value="${i.price}"/></td>
                    <td><fmt:formatNumber pattern="##.#" value="${i.quantity*i.price}"/></td>
                    <td>
                        <form action="process" method="post"> 
                            <input type="hidden" name="id" value="${i.product.id}"/>
                            <input type="submit" value="Return item"/>
                        </form>

                    </td>
                </tr>

            </c:forEach>

        </table>

        <table>
            <br/>
            <form action="checkout" method="post"> 
                <input type="submit" value="Check out"/>
            </form>
            <hr/>
            <h2 style="color: chocolate"> <a href="MyEShop.jsp">Click to continue shopping  </a></h2>

        </table>
    </body>
</html>
