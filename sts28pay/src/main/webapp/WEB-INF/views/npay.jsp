<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<input type="button" id="naverPayBtn" value="네이버페이">
<script src="https://nsp.pay.naver.com/sdk/js/naverpay.min.js"></script>
<script>

    var oPay = Naver.Pay.create({ //SDK Parameters를 참고 바랍니다.
          "mode" : "{development}",
          "clientId": "dQPaTGkl7UD9gyUVttF3", // clientId
          "openType": "popup"
   
    });

    //직접 만드신 네이버페이 결제버튼에 click Event를 할당하세요
    var elNaverPayBtn = document.getElementById("naverPayBtn");

    elNaverPayBtn.addEventListener("click", function() {
        oPay.open({ // Pay Reserve Parameters를 참고 바랍니다.
          "merchantUserKey": "{100}",
          "merchantPayKey": "{12}",
          "productName": "{expensivethings}",
          "totalPayAmount": 1000,
          "taxScopeAmount": 10,
          "taxExScopeAmount": 5,
          "returnUrl": "{http://localhost:8080/sts28/test}"
        });
    });

</script>

