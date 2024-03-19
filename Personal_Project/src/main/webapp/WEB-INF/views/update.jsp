<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${book.bookNo}번 도서 정보 수정</title>
</head>
<body>
    <h1>${book.bookNo}번 도서 수정</h1>
    <hr>

    <form action="/book/update" method="POST" id="updateForm">
    <input type="hidden" name="bookNo" value = "${book.bookNo}">
    <h2>도서 리뷰 수정</h2>
    <h4>도서 이름, 도서 작가, 작성자를 수정을 하기 위해서는 리뷰를 삭제하고 재작성해주세요.</h4>
        <div>
        평점(1~10) : <input type="number" name = "rate" style="width:35px" min="1" max="10"><br>
        </div>
        <div>
        <textarea name="reviewContent" cols="50" rows = "5" placeholder="리뷰 내용 수정란(10자 이상)"></textarea>
        </div> 
        <button id="update2">수정하기</button>
      


    </form>

   
<c:if test="${not empty message}" >
    <script>
      alert("${message}");
    </script>
    
    <c:remove var="message" />
  </c:if>
   <script src="/resources/js/detail.js"></script>
</body>
</html>