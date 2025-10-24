<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	.detail table {
	    border:1px solid;
	    border-collapse: collapse;
	    width: 500px;
	    text-align: center;
	    table-layout: fixed;
	}
	.detail td, th {
	    border:1px solid;
	    word-break: break-all;
	    white-space: normal;
	}
	.outer a {
	    text-decoration:none;
	    color: black;
	}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	<div class="detail" align="center">
		<h2>게시판 상세 조회</h2>
		<table>
			<tr>
				<th width="80px">글번호</th>
				<td width="420px">${b.boardno}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${b.boardtitle}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${b.boardwriter}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${b.count}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${b.createdate}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${b.boardcontent}</td>
			</tr>
		</table>
		<br>
		<table>
			<c:choose>
					<c:when test="${loginMem != null}">
						<form id="rFrm">
							<tr>
								<th width="80px">댓글작성</th>
								<th width="340px"><textarea rows="3" cols="45" name="content"></textarea></th>
								<th width="80px"><input type="button" value="댓글작성" id="replyInsert"></th>
							</tr>
							<input type="hidden" name="refbno" value= "${b.boardno }">
							<input type="hidden" name="writer" value= "${loginMem.userId}">
						</form>
					</c:when>
					<c:otherwise>
						<tr>
							<th width="80px">댓글작성</th>
							<th width="320px"><textarea rows="3" cols="45" readonly>로그인 후 이용 가능한 서비스입니다.</textarea></th>
							<th width="100px"><input type="button" value="댓글작성" disabled></th>
						</tr>
					</c:otherwise>
				</c:choose>
			</thead>
			<tbody>
				<c:forEach var="r" items="${reply}">
					<tr>
						<td>${r.replywriter }</td>
						<td>${r.replycontent }</td>
						<td>${r.createdate }</td>
					</tr>
				</c:forEach>
			

			</tbody>
		</table>
	</div>
	
	<div id="paging-area" align="center">
		<c:if test="${rpi.nowPage ne 1 }">
			<a href="detail.bo?nowPage=${rpi.nowPage -1 }&bno=${b.boardno}">[이전]</a>
		</c:if>
		<c:forEach var="p" begin="${rpi.startPage }" end="${rpi.endPage }">
			<c:choose>
				<c:when test="${p eq rpi.nowPage }">
					<a style="color: red"  href="detail.bo?nowPage=${p}&bno=${b.boardno}">[${p}]</a>
				</c:when>
				<c:otherwise>
					<a href="detail.bo?nowPage=${p}&bno=${b.boardno}">[${p }]</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="${rpi.nowPage ne rpi.totalPage }">
			<a href="detail.bo?nowPage=${rpi.nowPage +1 }&bno=${b.boardno}">[다음]</a>
		</c:if>
			
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<script>
		$("#replyInsert").click(function(){
			 let rdata=$("#rFrm").serialize();
			/*-> content=내용%refbno=13&writer=임채무
				밑과 위 둘 중 하나의 방법으로 하면 됨 
			*/
			$.ajax({
				url : "rinsert.bo",
				 data : rdata,
				 success : function(result){
					console.log(result);
					$("#content").val("");
					location.reload();
					
				},
				error : function(){
					console.log("댓글 등록 ajax 통신 실패");
				}
			})
		})
	
	
	</script>


</body>
</html>