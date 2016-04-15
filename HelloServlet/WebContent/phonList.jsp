<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="xmlhttp.js"></script>
<script type="text/javascript">
var _phone = "";
function LoadPhoneList(kind) {
	_phone = kind;
	httpObj = createXMLHttp(phoneComplete);
	if(httpObj) {
		httpObj.open("GET", "phone.xml", true);
		httpObj.send(null);
	}
}
function phoneComplete() {
	if((httpObj.readyState == 4) && (httpObj.status == 200)) {
		
		var xmlData =  httpObj.responseXML;
		var phone = xmlData.getElementsByTagName('phone');
		console.log(_phone);
		for(var i = 0; i < phone.length; i++) {
			var pname = phone[i].getElementsByTagName("name")[0].childNodes[0].nodeValue;
			var img = phone[i].getElementsByTagName("img")[0].childNodes[0].nodeValue;
			if(_phone == pname) {
				document.getElementById('result').innerHTML = "<h2>"+pname+" 입니다.<h2>";
				document.getElementById('result').innerHTML += '<img src="'+img+'" width="400" alt="'+pname+'" />';
				break;
			}
		}
	}
	else {
		document.getElementById('result').innerHTML = "<b>대기중...</b>";
	}
}

</script>
</head>
<body>
	<form name="ajaxForm">
		<input type="button" value="폰리스트" onclick="LoadPhoneList('아이폰')" />
		<input type="button" value="갤럭시" onclick="LoadPhoneList('갤럭시')" />
		<input type="button" value="옵티머스" onclick="LoadPhoneList('옵티머스')" />
		<input type="button" value="베가" onclick="LoadPhoneList('베가')" />	
	</form>
	<div id="result"></div>
</body>
</html>