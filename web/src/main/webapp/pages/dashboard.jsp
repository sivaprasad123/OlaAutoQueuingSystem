<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style type="text/css">
        h1, .centeralign {
            text-align: center !important;
        }

        button.refresh {
            float: right !important;
        }

    </style>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript"
            src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
</head>
<body class="well">
<h1><span>Dashboard
        <a href="/ola/v1/dashboard.html">
            <button type="button" class="btn btn-primary refresh">Refresh</button>
        </a></span></h1>
<table class="table centeralign">
    <tr>
        <td>Request Id</td>
        <td>Customer Id</td>
        <td>Time Elapsed</td>
        <td>Status</td>
        <td>Driver</td>
    </tr>
    <c:if test="${not empty dashboardList}">
        <c:forEach var="dashboard" items="${dashboardList}">
            <tr>
                <td>${dashboard.requestId}</td>
                <td>${dashboard.customerId}</td>
                <td>${dashboard.timeElapsed}</td>
                <td>${dashboard.status}</td>
                <c:choose>
                    <c:when test="${not empty dashboard.driverId}">
                        <td>${dashboard.driverId}</td>
                    </c:when>
                    <c:otherwise>
                        <td>None</td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>