<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.12.3.min.js" />"></script>
</head>
<body>

	<table width="100%" border="1">
		<colgroup>
			<col width="50%" />
			<col width="*" />
		</colgroup>
		<thead>
			<tr>
				<th>로고</th>
				<th>팀명</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td colspan="2" align="center" height="35"><a href="javascript:;"
					class="button">야구팀 리스트</a></td>
			</tr>
		</tfoot>
		<tbody id="teamList">
			<tr>
				<td colspan="2" align="center" disabled>데이터를 가져와 보세요.</td>
			</tr>
		</tbody>
	</table>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".button").click(function() {
				$.ajax({
					url:"<c:url value="/ajax/xmlMlb" />",
					type:"POST",
					dataType:"xml",
					success:function(data) {
						var teamList = "";
						$(data).find('teamList').each(function() {
							var name = $(this).find('name').text();
							var logo = $(this).find('logo').text();
							teamList += '<tr>';
							teamList += '<td align="center"><img src="'+logo+'" /></td>';
							teamList += '<td align="center">'+name+'</td>';
							teamList += '</tr>';
						});
						$('#teamList').html(teamList);
					},
					erro:function(xhr, status, error) {
						alert(error);
					}
				})
			});
		});
		</script>
</body>
</html>