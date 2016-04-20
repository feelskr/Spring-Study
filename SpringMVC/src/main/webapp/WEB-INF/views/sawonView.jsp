<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

li {
	list-style: none;
	margin: 0;
	padding: 0;
}
</style>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.12.3.min.js" />"></script>
</head>
<body>
	<div style="height:150px;">
		<ul
			style="float: left; border: 1px solid #dedede; margin-right: 15px; padding: 10px;">
			<li	style="border-bottom: 1px solid #dedede; padding-bottom: 5px; margin-bottom: 3px;"><span
				class="btncd" data-cd="영업부">영업부</span></li>
			<li	style="border-bottom: 1px solid #dedede; padding-bottom: 5px; margin-bottom: 3px;"><span
				class="btncd" data-cd="개발부">개발부</span></li>
			<li	style="border-bottom: 1px solid #dedede; padding-bottom: 5px; margin-bottom: 3px;"><span
				class="btncd" data-cd="인사부">인사부</span></li>
			<li style="border-bottom: 1px solid #dedede; padding-bottom: 5px; margin-bottom: 3px;"><span
				class="btn-submit" >사원등록</span></li>				
		</ul>
		<ul style="float: left; width: 45%; border: 1px solid #a3a3d3; padding: 10px;"
			id="result">
			<li style="padding: 10px; text-align: center;">사원정보가 없습니다.</li>
		</ul>
	</div>
	<div id="alertMsg" style="clear:both;width:98%;border:1px solid #dedede;display:none;margin-top:10px;padding:10px;">1</div>
	<script>
		$(document)	.ready(function() {
			$('.btn-submit').click(function() {
				$.ajax({
					type:"POST",
					url : "<c:url value="/ajax/jsonIn" />",
					data:'{"cd":"개발부","name":"욱씨3"}',
					contentType:"application/json;charset=UTF-8",
					dataType:'html',
					success:function(data) {
						$('#alertMsg').html(data);
						$('#alertMsg').show();
					},
					error:function(xhr, status,error) {
						alert(error);
					}
				});		
			});
		
			$('.btncd').click(	function() {
				var cd = $(this).data('cd');
				var params = {
					cd : cd
				};
				$.ajax({
					url : "<c:url value="/ajax/jsonOut" />",
					data : params,
					type : "POST",
					dataType : "json",
					success : function(	data) {
						var html = "";
						$(data).each(	function(	idx, obj) {
							html += "<li style='border-bottom:1px solid #dedede;padding-bottom:5px;margin-bottom:5px;color:#a3b3d3;font-weight:bold;font-size:14px;'>"+ obj.name	+ "</li>";
						});
						$('#result').html(html);
					},
					error : function(xhr, status,error) {
						alert(error);
					}
				});
			});
		})
	</script>
</body>
</html>