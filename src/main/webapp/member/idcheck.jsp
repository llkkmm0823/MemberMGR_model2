<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idcheck.jsp</title>
<script type="text/javascript">
function idok(id){
	opener.document.frm.userid.value=id;
	opener.document.frm.reid.value=id;
	
	/* opener.document.frm.userid.value='${userid}';
	opener.document.frm.reid.value='${userid}'; 
	로도 사용 가능하나 위 코드를 많이 사용함 ( 전달받아 사용하는 함수 )*/
	self.close();
	//팝업창을 스스로 닫을 때 사용하는 코드
}
</script>

</head>
<body>
<c:choose>
	<c:when test="${result==1}">
		${userid}는 이미 사용 중인 아이디입니다.
		<script type="text/javascript">
		//팝업창을 오픈한 주체(창) =>  opener 이라 지칭
			opener.document.frm.userid.value="";
			opener.document.frm.reid.value="";

		</script>
	</c:when>
	<c:otherwise>
		${userid}는 사용 가능한 아이디입니다.
		<input type="button" value="사용" onClick="idok('${userid}');"/>
		
	</c:otherwise>
</c:choose>

<br><br>
<!--첫 번째 체크한 아이디 말고 다른 아이디를 체크하기 위한 폼  -->
<form action="member.do" method="get" name="frm">
	<input type="hidden" name="command" value="idcheck">
	아이디 : <input type="text" name="userid" value="${userid}">
	<input type="submit" value="중복체크">
</form>

</body>
</html>