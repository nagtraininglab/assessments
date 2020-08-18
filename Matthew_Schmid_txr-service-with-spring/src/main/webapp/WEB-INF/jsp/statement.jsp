<!DOCTYPE html>
<%@page import="com.example.demo.model.Txn"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>txr service</title>
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body class="container">

	<hr />
	<h1>Money Transfer System</h1>
	<hr />

	<ul class="nav nav-pills">
		<li class="nav-item">
			<a class="nav-link" href="txr-form.html">Transfer</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="">Statement</a>
		</li>
	</ul>
	<hr />
	
	<hr />
	
	<a class="btn btn-primary" href="txns?filter=all">All</a>
	
	<ul class="nav nav-pills">
		<li class="nav-item">
			<a class="btn btn-primary" href="statement_day.html">Filter by day</a>
		</li>
	</ul>

	
	
	<table class="table table-bordered">
	<thead>
	<tr>
		<td>Txn ID </td>
		<td>To Acc #</td>
		<td>From Acc #</td>
		<td>Amount</td>
		<td>Date & Time</td>
		<td>Remarks</td>
	</tr>
	</thead>
	<tbody>
	<% int id = 1 ; %>
	<%
		List<Txn> txns=(List<Txn>)request.getAttribute("txns");
		for(Txn txn:txns){
	%>
		
	<tr>
		<td><%=id%></td>
		<td><%=txn.getToAccNum() %></td>
		<td><%=txn.getFromAccNum() %></td>
		<td><%=txn.getAmount() %></td>
		<td><%=txn.getLocalDateTimedb() %></td>
		<td><%=txn.getRemarks() %></td>
	</tr>
	<%id++;%>
	<%
		}
	%>
	</tbody>
	</table>

</body>
</html>