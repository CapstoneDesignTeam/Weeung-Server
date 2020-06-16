<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="mqtt.Publisher" %>
<%@ page import="mqtt.Subscriber" %>

<%@ page import="hospital.HospitalDAO"%>
<%@ page import="hospital.Hospital"%>
<%@ page import="distance.LocationDistance"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
 	 Publisher pb = new Publisher();
	pb.setBrokerUrl("tcp://172.30.1.43:1883");
	pb.setClientId("JavaSample");
	pb.setTopic("user/patient/shseo");
	pb.setContent("150%39.8%37.56653:126.9779691900000");
	pb.myPublish();  

	/*  	Subscriber sb = new Subscriber();
	sb.setBrokerUrl("localhost");
	sb.setClientId("JavaSample");
	sb.setTopic("user/patient/shseo");
	sb.subscribe();  */

/* 	HospitalDAO hosDAO = new HospitalDAO();
	ArrayList<Hospital> test = hosDAO.getList();
	int i = 0;
	while(i< test.size()){
		System.out.println("hosName : " + test.get(i).getHospitalName());
		System.out.println("hosPhone : " + test.get(i).getHospitalPhone());
		System.out.println("hosLatitude : " + test.get(i).getHospitalLocationInfo().getLatitude());
		System.out.println("hosLongtitude : " + test.get(i).getHospitalLocationInfo().getLongitude());
		i++;
	}; */
	
	
%>

</body>
</html>