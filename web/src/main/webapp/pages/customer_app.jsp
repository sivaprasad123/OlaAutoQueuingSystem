<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${not empty sucessMsg}">
${sucessMsg}
</c:if>
<form:form method="POST" action="http://localhost:8080/ola/v1/customer/book/ride.html" modelAttribute="rideRequest">
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