
// 홈으로 버튼 동작
const goToHome = document.querySelector("#goToHome");

if(goToHome != null){
    goToHome.addEventListener("click",() => {
        location.href = "/";
    });
}


// 홈으로 버튼 동작
const goToHome2 = document.querySelector("#goToHome2");

if(goToHome2 != null){
    goToHome2.addEventListener("click",() => {
        location.href = "/";
    });
}



// 삭제 버튼 동작
const deleteBtn = document.querySelector("#deleteBtn");

if(deleteBtn != null) {
    deleteBtn.addEventListener("click",e => {
        if(confirm("삭제하시겠습니까?")){
            location.href = `/book/delete?bookNo=${e.target.dataset.bookNo}`;
        }
    });
}


// 수정 버튼 동작
const updateBtn = document.querySelector("#updateBtn");


if(updateBtn != null){
    updateBtn.addEventListener("click",e =>{
        const bookNo = e.target.dataset.bookNo;
        location.href = `/book/update?bookNo=${bookNo}`;

    })
}





const updateForm = document.querySelector("#updateForm")
if(updateForm != null){
    updateForm.addEventListener("submit",e => {
        if(document.querySelector("#rate").value.trim().length == 0) {

            alert("평점을 입력하지 않았습니다.");
           
            e.preventDefault();
        }
        if(document.querySelector("#reviewContent").value.trim().length < 10) {

            alert("수정할 내용을 10자 이상 입력하지 않았습니다.");
           
            e.preventDefault();
        }
        
    })
}




// 제출 버튼 시

const addForm = document.querySelector("#addForm");

if(addForm != null){
    addForm.addEventListener("submit",e => {

        // 빈칸 검사

        // 빈칸일 때
        if(document.querySelector("#bookTitle").value.trim().length == 0) {

            alert("도서 제목이 입력되지 않았습니다.");
            
            e.preventDefault();
        }
        if(document.querySelector("#writer").value.trim().length == 0) {

            alert("도서 작가가 입력되지 않았습니다.");
           
            e.preventDefault();
        }
        if(document.querySelector("#reviewWriter").value.trim().length == 0) {

            alert("리뷰 작성자가 입력되지 않았습니다.");
           
            e.preventDefault();
        }
        if(document.querySelector("#rate").value.trim().length == 0) {

            alert("평점을 입력하지 않았습니다.");
           
            e.preventDefault();
        }
        if(document.querySelector("#reviewContent").value.trim().length < 10) {

            alert("리뷰 내용을 10자 이상 입력해주세요.");
           
            e.preventDefault();
        }

    })
}

   