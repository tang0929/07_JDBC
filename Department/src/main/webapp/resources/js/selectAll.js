/* selectAll.js */

// 삭제 버튼 클릭 시
// 해당 행의 부서 코드 얻어오기

// .delete-btn 모두 얻어와 배열로 반환 받기
const deleteBtnList = document.querySelectorAll(".delete-btn");

// deleteBtnList.addEventListener()  --> 안됨!!!
// 왜? 이벤트 리스너는 DOM 요소에 추가해야 동작하는데
// deleteBtnList는 DOM요소가 아니라 배열(유사 배열, NodeList)
// -> 이벤트 리스너를 추가할 수 없다!


// 해결 방법 -> 배열 내 각 인덱스 요소 == DOM 요소(버튼)
// -> 배열 내 요소를 하나씩 꺼내서 이벤트 리스너를 추가하면 된다!!


for(let btn of deleteBtnList){ // 향상된 for문

  btn.addEventListener("click", e => {
    
    // 클릭된 삭제 버튼이 존재하는 행의 부서코드를 얻어오기
    //const deptId = e.target.parentElement.parentElement.children[1].innerText;
    const deptId = e.target.closest("tr").children[1].innerText;

    /* 요소.closest("CSS선택자");
    - 지정된 요소의 상위 요소(부모 방향, 루트 최상위 까지) 중에서
    CSS 선택자가 일치하는 요소를 찾을 때 까지 검색해 일치하는 요소가 있으면 해당요소 반환 */
    console.log(deptId);

    if(confirm(`${deptId} 부서를 정말 삭제하시겠습니까?`)){
        // 확인 클릭 시 

        // 삭제 요청 보내기 1) location.href 이용
        // GET 방식 요청
        // -> 브라우저 주소창에 입력하는 방ㅂ버도 GET 방식 요청
        // 임의의 사용자가 삭제 요청을 마음대로 보내는 문제가 발생
        // location.href = "/department/delete/deptId" + deptId;


        // 삭제 요청 보내기 2) form태그를 만들어서 POST 방식 요청 보내기

         const form = document.createElement("form");
         form.action = "/department/delete";
         form.method = "POST";
   
        //input type= "hidden" 생성
        const input = document.createElement("input");
        input.type = "hidden";
        input.value = deptId;
        input.name = "deptId";

        // form 자식으로 input추가
         form.append(input);

        // body 태그 제일 밑에 form 추가)
        document.querySelector("body").append(form);

        // 화면에 추가된 form 제출하기
        form.submit();

   

    } else{
        alert("삭제 취소");
    }

  });

}




//.update-btn 요소 모두 얻어오기
const updateBtnList = document.querySelectorAll(".update-btn");

// updateBtnList 배열의 모든 요소의 순차 접근하며 이벤트리스너 추가
updateBtnList.forEach((btn,index) => {
    btn.addEventListener('click',e => {
        // 부모 요소중 가장 가까운 tr태그 찾기
        const tr = e.target.closest("tr");

        // 부서 코드 얻어오기
        const deptId = tr.children[1].innerText;

        // JS에서 이용해서 요청하기(GET)
        location.href="/department/update?deptId=" + deptId;
    });
})
