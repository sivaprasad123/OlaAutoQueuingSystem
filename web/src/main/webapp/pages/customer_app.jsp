<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript"
            src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
    <style type="text/css">
        h1, .centeralign {
            text-align: center !important;
        }

        .table > tbody > tr > td {
            border-top: none !important;
        }
    </style>
</head>

<c:if test="${not empty sucessMsg}">
    <span class="centeralign">${sucessMsg}</span>
</c:if>
<body class="well">
<h1>Customer App</h1>
<form:form method="POST" action="/ola/v1/customerapp/book/ride.html"
           modelAttribute="customerRideRequest">
    <table class="table centeralign">
        <tr>
            <td>Customer ID : <form:input path="customerId"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" class="btn btn-primary" value="RIDE NOW"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>