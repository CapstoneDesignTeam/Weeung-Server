<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="mqtt.Subscriber"%>
<%@ page import="android.ConnectDB" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/custom.css">
<title>MQTT 환자관리 웹 사이트</title>
</head>
<body>
	<%
		Subscriber sb = new Subscriber("172.30.1.43", "server", "user/#"); /* 브로커 아이피, 브로커 이름, subscribe할 topic 순으로 입력 */
		ConnectDB connectDB = new ConnectDB();
		//connectDB.joinDB("shseo", "1234", "seunghwan", "930817", "01073739727", "patient");
		
		/*
		*116.126.97.126 현호 브로커 IP
		*113.198.84.52 승환 브로커 IP
		*/
		sb.subscribe();
	%>
	<script>
		location.href = 'main.jsp';
	</script>
</body>
</html>