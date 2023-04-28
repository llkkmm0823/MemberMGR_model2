<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm.jsp</title>
<script type="text/javascript">
function loginCheck(){ // 로그인 시 빈칸이 있는지 검사하는 함수
	if(document.frm.userid.value==""){
		alert("아이디를 입력하세요");
		document.frm.userid.focus(); //focus : 그 자리로 가서 입력커서가 깜빡이는 효과
		return false;
	}
	if(document.frm.pwd.value.length==0){
		alert("비밀번호를 입력하세요");
		document.frm.pwd.focus(); 
		return false;
	}
	return true; //모든 if문을 정상통과해야만 true를 리턴
}

</script>
</head>
<body>

<form action="member.do" method="post" name="frm">
	<input type="hidden" name="command" value="login"/>
	<table>
		<tr><td>아이디</td><td><input type="text" name="userid"></td></tr>
		<tr><td>암 호</td><td><input type="password" name="pwd"></td></tr>
		<tr><td colspan="2" align="center">
		
		<input type="submit" value="로그인" onClick="return loginCheck();">
	<!--loginCheck()함수를 통해 true/false값을 리턴받아 form태그에 결과를 다시한번 리턴
		form태그의 동작이 action에 지정한 곳으로 이동을 진행할지(true값 리턴) 멈춰야할지(false값 리턴) 결정-->
		<input type="reset" value="취소">
		<input type="button" value="회원가입" onClick="location.href='member.do?command=joinForm'"></td></tr>
		
		<tr><td colspan="2">${message}</td></tr>
	</table>

</form>

</body>
</html>