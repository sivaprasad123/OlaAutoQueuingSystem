<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style type="text/css">
        /* Style the tab */
        div.tab {
            overflow: hidden;
            border: 0px solid #ccc;
            background-color: #f1f1f1;
        }

        /* Style the buttons inside the tab */
        div.tab button {
            background-color: inherit;
            float: left;
            border: none;
            outline: none;
            cursor: pointer;
            /*padding: 14px 16px;*/
            padding: 24px 102px;
            transition: 0.3s;
        }

        /* Change background color of buttons on hover */
        div.tab button:hover {
            background-color: #ddd;
        }

        /* Create an active/current tablink class */
        div.tab button.active {
            background-color: #ccc;
        }

        /* Style the tab content */
        .tabcontent {
            display: none;
            padding: 6px 12px;
            border: 1px solid #ccc;
            border-top: none;
        }
    </style>
    <style type="text/css">
        h1, .tab, .tabcontent, .centeralign {
            text-align: center !important;
        }

        button.refresh {
            float: right !important;
        }

        .table > tbody > tr > td {
            border-top: none !important;
        }
    </style>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
</head>
<body class="well">
<h1><span>Driver App - driver id :${driverId}
        <a href="/ola/v1/driverapp.html?id=${driverId}">
            <button type="button" class="btn btn-primary refresh">Refresh</button>
        </a></span></h1>

<div class="tab">
    <h3>
        <button class="tablinks" onclick="openTab(event, 'waiting')" id="defaultOpen">Waiting
        </button>
        <button class="tablinks" onclick="openTab(event, 'ongoing')">Ongoing</button>
        <button class="tablinks" onclick="openTab(event, 'completed')">Completed</button>
    </h3>
</div>

<div id="waiting" class="tabcontent">
    <c:forEach var="waitingRides" items="${driverAppInfo.waiting}">
        <table class="table centeralign">
            <tr>
                <td>Request Id:${waitingRides.requestId}</td>
            </tr>
            <tr>
                <td>Customer Id:${waitingRides.customerId}</td>
            </tr>
            <tr>
                <td>${waitingRides.requestedAt}</td>
            </tr>
            <tr>
                <td>
                    <a href="/ola/v1/driverapp/select/ride/${driverId}/${waitingRides.requestId}.html"><button type="button" class="btn btn-primary">
                        Select
                    </button></a>

                </td>
            </tr>
        </table>
    </c:forEach>
</div>

<div id="ongoing" class="tabcontent">
    <c:forEach var="onGoing" items="${driverAppInfo.onGoing}">
        <table class="table centeralign">
            <tr>
                <td>Request Id:${onGoing.requestId}</td>
            </tr>
            <tr>
                <td>Customer Id:${onGoing.customerId}</td>
            </tr>
            <tr>
                <td>Picked up:${onGoing.pickedUpAt}</td>
            </tr>
        </table>
    </c:forEach>
</div>

<div id="completed" class="tabcontent">
    <c:forEach var="completed" items="${driverAppInfo.completed}">
        <table class="table centeralign">
            <tr>
                <td>Request Id:${completed.requestId}</td>
            </tr>
            <tr>
                <td>Customer Id:${completed.customerId}</td>
            </tr>
            <tr>
                <td>Picked up:${completed.pickedUpAt}</td>
            </tr>
            <tr>
                <td>Completed:${completed.completedAt}</td>
            </tr>
        </table>
    </c:forEach>
</div>

<script type="text/javascript">
    function openTab(evt, tabName) {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(tabName).style.display = "block";
        evt.currentTarget.className += " active";
    }
    document.getElementById("defaultOpen").click();
</script>
</body>
</html>