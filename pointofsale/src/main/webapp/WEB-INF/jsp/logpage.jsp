<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log Page of Service Requests</title>
</head>
<body>
 
<h1>
 
 
<!-- 
l	String lo_message_start_time;
	String lo_message_end_time; 
	String lo_message_channel;
	String lo_message_service;
	String lo_message_timestamp;
	
 -->
Log</h1><table>
<tr>
<td width="50">lo_message_start_time</td>
<td width="150">lo_message_end_time</td>
<td width="150">lo_message_channel</td>
<td width="50">lo_message_service</td>
<td width="50">lo_message_timestamp</td>

</tr>
<c:forEach items="${logentries}" var="logentry">
<tr>
<td><c:out value="${logentry.lo_message_start_time}" /></td>
<td><c:out value="${logentry.lo_message_end_time}" /></td>
<td><c:out value="${logentry.lo_message_channel}" /></td>
<td><c:out value="${logentry.lo_message_service}" /></td>
<td><c:out value="${logentry.lo_message_timestamp}" /></td>
</tr>
</c:forEach>
</table></body>
</html>