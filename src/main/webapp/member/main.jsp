<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
<script type="text/javascript">
function withDrawConfirm(){
	var bool = confirm('정말로 회원 탈퇴하시겠습니까??????????????');
	if(bool){
/* 		location.href="withdraw.do?userid=" + "${loginUser.userid}";*/
// 굳이 또 조회하지 않아도 세션에 loginUser에 정보가 저장되어있기 때문에 _ 로그인한 유저의 회원탈퇴 진행하는 것이기 때문
			location.href="member.do?command=deleteForm";  //라고만 작성해도 무방함
	}else{
		return;
	}
}

</script>
</head>
<body>
	<%
	if (session.getAttribute("loginUser") == null)
		response.sendRedirect("login.do"); // 바로 페이지로 갈 경우 경로가 노출됨_항상 서블릿 거치기
	%>
	<%-- <c:if test="${empty loginUser}">
	<%response.sendRedirect("login.do"); %>
</c:if> 
라이브러리 추가한 후 이렇게 작성해도 무방--%>


	<table>
		<tr>
			<td>${loginUser.userid}(${loginUser.name})님이로그인 하셨습니다.</td>
		</tr>
		<tr>
			<td>email : ${loginUser.email}</td>
		</tr>
		<tr>
			<td>전화번호 : ${loginUser.phone}</td>
		</tr>
		<tr>
			<td><input type="button" value="로그아웃"onClick="location.href='member.do?command=logout'" />
				<input type="button" value="회원정보변경"onClick="location.href='member.do?command=updateForm'"/>
				<input type="button" value="회원탈퇴"onClick="withDrawConfirm();"/>
			</td>
		</tr>
		
				
	<!-- 
	어떤 태그이든 onClick속성을 써서 페이지 이동을 하고자 한다면, 
	위와 같이 location.href를 onClick속성에 지정하여 이동  
	onClick속성에는 페이지 이동 기능이 없기 때문에 페이지만 쓴다고 이동하지 않음. 반드시 location.href로 페이지를 지정
	-->
	</table>
	<br>
	<br>
	<c:if test="${loginUser.admin == 1 }">

		<table width="800" bgcolor="black" cellspacing="1">
			<tr bgcolor="white">
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>등급</th>
				<th>등급변경</th>
			</tr>
			<c:forEach items="${mList}" var="member">
				<tr bgcolor="white" align="center">
					<td>${member.userid}</td>
					<td>${member.name}</td>
					<td>${member.phone}</td>
					<td>${member.email}</td>
					<td><c:choose>
							<c:when test="${member.admin==0}">일반</c:when>
							<c:otherwise>관리자</c:otherwise>
						</c:choose></td>
					<td>
					<c:choose>
					<c:when test ="${member.userid==loginUser.userid}}">&nbsp;</c:when>
					<c:otherwise>
				<input type="button" value="변경" 
					onClick="location.href='member.do?command=editadmin&userid=${member.userid}&admin=${member.admin}'"/>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</c:forEach>
</table>	
</c:if>
</body>
</html>