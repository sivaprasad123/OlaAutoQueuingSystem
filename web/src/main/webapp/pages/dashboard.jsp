<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>dashboard</h2>
<a style="float:right" href="<c:url value="http://localhost:8080/ola/v1/dashboard.html" />" >Refresh</a>
<table>
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