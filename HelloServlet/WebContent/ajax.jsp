<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="xmlhttp.js"></script>
<script type="text/javascript">
function LoadXML() {
	httpObj = createXMLHttp(xmlComplete);
	if(httpObj) {
		httpObj.open("GET", "user.xml", true);
		httpObj.send(null);
	}
}
function LoadFile(phone) {
	httpObj = createXMLHttp(readComplete);
	if(httpObj) {

		httpObj.open("GET", "ajaxResult.jsp?phone="+phone, true);
		httpObj.send(null);
		
	}
	else {
		alert('지원하지 않는 브라우저 입니다.');
	}
}

function xmlComplete() {
	if((httpObj.readyState == 4) && (httpObj.status == 200)) {
		document.getElementById('result').innerHTML  = "";
		var xmlData =  httpObj.responseXML;
		var user = xmlData.getElementsByTagName('user');
		for(var i = 0; i < user.length; i++) {
			document.getElementById('result').innerHTML += user[i].getElementsByTagName("Number")[0].childNodes[0].nodeValue +"."+	user[i].getElementsByTagName("Irum")[0].childNodes[0].nodeValue + "<br />";
		}
		
	}
	else {
		document.getElementById('result').innerHTML = "<b>대기중...</b>";
	}
}


function readComplete() {
	if((httpObj.readyState == 4) && (httpObj.status == 200)) {
		document.getElementById('result').innerHTML = httpObj.responseText;
	}
	else {
		document.getElementById('result').innerHTML = "<b>대기중...</b>";
	}
}
</script>
</head>
<body>
	<form name="ajaxForm">
		<input type="button" value="아이폰" onclick="LoadXML()" />
		<!-- <input type="button" value="갤럭시" onclick="LoadFile('ga')" />
		<input type="button" value="옵티머스" onclick="LoadFile('ot')" />
		<input type="button" value="베가" onclick="LoadFile('vega')" />		 -->
	</form>
	<div id="result"></div>
</body>
</html>