
// 홈으로 버튼 동작
const goToHome = document.querySelector("#goToHome");

goToHome.addEventListener("click",() => {
    location.href = "/";
});


// 삭제 버튼 동작
const deleteBtn = document.querySelector("#deleteBtn");

deleteBtn.addEventListener("click",e => {
    if(confirm("삭제하시겠습니까?")){
        location.href = `/book/delete?bookNo=${e.target.dataset.bookNo}`;
    }
});