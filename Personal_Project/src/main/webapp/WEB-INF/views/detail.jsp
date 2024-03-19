<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${book.bookNo}번 도서 상세 조회</title>
    <style>
    table{
      border-collapse : collapse;

    }
  
    .book-content{
   
      white-space : pre-wrap;
    }
    </style>
</head>
<body>
    <h2>${book.bookTitle} 조회 및 리뷰</h2>
    <hr>
    <table border = "1">
    <tr>
        <th>번호</th>
        <td>${book.bookNo}</td>
    </tr>

    <tr>
        <th>등록 날짜</th>
        <td>${book.regDate}</td>
    </tr>

    <tr>
        <th>도서 제목</th>
        <td>${book.bookTitle}</td>
    </tr>

    <tr>
        <th>작가명</th>
        <td>${book.writer}</td>
    </tr>

    <tr>
        <th>작성자</th>
        <td>${book.reviewWriter}</td>
    </tr>

    <tr>
        <th>평점</th>
        <td>${book.rate}</td>
    </tr>

    <tr>
        <th>리뷰 내용</th>
        <td class="book-content">${book.reviewContent}</td>
    </tr>
    
    </table>

    <button id = "goToHome">홈으로</button>
    <button id = "updateBtn" data-book-no="${book.bookNo}">수정하기</button>
    <button id = "deleteBtn" data-book-no="${book.bookNo}">삭제하기</button>

    <script src="/resources/js/detail.js"></script>

    <c:if test="${not empty message}" >
        <script>
             alert("${message}");
        </script>

        <c:remove var="message" />
    </c:if>

</body>
</html>