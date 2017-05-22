<%@ page import="com.wutengcoding.mvcapp.domain.Customer" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"/>
    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var flag = confirm("确定要删除xx的信息吗");
                return flag;
            })
        })
    </script>
</head>
<body>
<h2>Hello World!</h2>

<form action="query.do" method="post">
    <table>
        <tr>
            <td>CustomerName:</td>
            <td><input type="text" name="name"/></td>
        </tr>

        <tr>
            <td>Address:</td>
            <td><input type="text" name="address"/></td>
        </tr>

        <tr>
            <td>CustomerName:</td>
            <td><input type="text" name="phone"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="Query"></td>
            <td><a href="">Add New Customer</a> </td>
        </tr>
    </table>

    <br><br>

    <%

        List<Customer> customerList = (List<Customer>) request.getAttribute("customers");

        if (customerList != null && customerList.size() > 0) {
    %>
    <hr>
    <br><br>
    <table cellpadding="10" cellspacing="1">
        <tr>
            <th>ID</th>
            <th>CustomerName</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Update\Delete</th>
        </tr>

        <%
            for (Customer c : customerList) {
        %>
            <tr>
                <td><%=c.getId()%></td>
                <td><%=c.getName()%></td>
                <td><%=c.getAddress()%></td>
                <td><%=c.getPhone()%></td>
                <td><a href="update">update</a>  <a href="delete">delete</a> </td>
            </tr>
        <%
            }
        %>
    </table>

    <%

        }

    %>

</form>

</body>
</html>
