<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:eval expression="@applicationProperties['OLA_AUTO_HOST']" var="host"/>

<c:if test="${not empty sucessMsg}">
${sucessMsg}
</c:if>
<form:form method="POST" action="/ola/v1/customerapp/book/ride.html" modelAttribute="customerRideRequest">
    <table >
        <tr>
            <td>Customer ID : </td>
            <td><form:input path="customerId"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="RIDE NOW"/></td>
        </tr>
    </table>
</form:form>