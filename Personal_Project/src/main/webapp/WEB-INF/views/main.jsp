<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BookList</title>
</head>
<body>
    <h1>도서 리뷰 게시판</h1>
    <hr>
    <form action="/book/add" method="POST">

    <h2>도서 리뷰 작성</h2>
        <div>
        도서 이름 : <input type="text" name = "bookTitle" size = "50">
        </div>
        <div>
        도서 작가 : <input type="text" name = "writer" size = "width:80px;">
        </div>
        <div>
        작성자 : <input type="text" name = "reviewWriter" style="width:80px;">
        </div>
        <div>
        평점 : <input type="number" name = "rate" style="width:35px" min="1" max="10"><br>
        (1~10)
        </div>
        <div>
        <textarea name="reviewContent" cols="50" rows = "5" placeholder="리뷰 내용 작성란"></textarea>
        </div> 
        <button>제출하기</button>


    </form>
    <hr>
    <h2>리뷰 목록</h2>
    <table border="1" style ="border-collapse : collapse;">
    <thead>
        <th>번호</th>
        <th>도서 이름</th>
        <th>도서 작가</th>
        <th>리뷰 작성자</th>
        <th>평점</th>
        <th>등록일</th>
    </thead>
    <tbody>
    <c:forEach items="${bookList}" var="book">

        <tr>
            <td>${book.bookNo}</td>
            <td><a href="/book/detail?bookNo=${book.bookNo}">${book.bookTitle}</a></td>
            <td>${book.writer}</td>
            <td>${book.reviewWriter}</td>
            <td>${book.rate}</td>
            <td>${book.regDate}</td>
        </tr>

     </c:forEach>
    </tbody>
    
    <c:if test="${not empty message}" >
    <script>
      alert("${message}");
    </script>

    <c:remove var = "message" />
    </c:if>

    </table>
</body>
</html>