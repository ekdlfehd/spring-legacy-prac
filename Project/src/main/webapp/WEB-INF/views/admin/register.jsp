<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">


<script>
	$(document).ready(function() {
		/* 카테고리 */
		let cateList = JSON.parse('${cateList}');
		let cate1Array = new Array();
		let cate2Array = new Array();
		let cate3Array = new Array();
		let cate1Obj = new Object();
		let cate2Obj = new Object();
		let cate3Obj = new Object();

		let cateSelect1 = $(".cate1");
		let cateSelect2 = $(".cate2");
		let cateSelect3 = $(".cate3");

		/* 카테고리 배열 초기화 메서드 */
		function makeCateArray(obj, array, cateList, tier) {
			for (let i = 0; i < cateList.length; i++) {
				if (cateList[i].tier === tier) {
					obj = new Object();

					obj.cateName = cateList[i].cateName;
					obj.cateCode = cateList[i].cateCode;
					obj.cateParent = cateList[i].cateParent;

					array.push(obj);
				}
			}
		}
		/* 배열 초기화 */
		makeCateArray(cate1Obj, cate1Array, cateList, 1);
		makeCateArray(cate2Obj, cate2Array, cateList, 2);
		makeCateArray(cate3Obj, cate3Array, cateList, 3);

		for (let i = 0; i < cate1Array.length; i++) {
			cateSelect1.append("<option value='" + cate1Array[i].cateCode + "'>" + cate1Array[i].cateName + "</option>");
		}
		
		/* 중분류 <option> 태그 */
		cateSelect1.on("change", function() {
			let selectVal1 = $(this).find("option:selected").val();

			cateSelect2.children().remove();
			cateSelect3.children().remove();
			
			cateSelect2.append("<option value='none'>선택</option>")
			cateSelect3.append("<option value='none'>선택</option>");
			

			for (let i = 0; i < cate2Array.length; i++) {
				if (selectVal1 === cate2Array[i].cateParent) {
					cateSelect2.append("<option value='" + cate2Array[i].cateCode + "'>" + cate2Array[i].cateName + "</option>");
				}
			} // for
		});
		/* 소분류 <option> 태그 */
	    cateSelect2.on("change", function() {
	        let selectVal2 = $(this).find("option:selected").val();

	        cateSelect3.children().remove();

	        cateSelect3.append("<option value='none'>선택</option>");

	        for (let i = 0; i < cate3Array.length; i++) {
	            if (selectVal2 === cate3Array[i].cateParent) {
	                cateSelect3.append("<option value='" + cate3Array[i].cateCode + "'>" + cate3Array[i].cateName + "</option>");
	            }
	        }
	    });	
	});

	function clothes_insert(f) {
		
		/* 체크 변수 */
		var clothesNameCK = false;
		var cateCodeCK = false;
		var clothesPriceCK = false;
		var clothesStockCK = false;
		var clothesDiscountCK = false;
		var clothesIntroCK = false;


		/* 체크 대상 변수 */
		var clothesName = $("input[name='clothesName']").val();
		var cateCode = $("select[name='cateCode']").val();
		var clothesPrice = $("input[name='clothesPrice']").val();
		var clothesStock = $("input[name='clothesStock']").val();
		let clothesDiscount = $("#discount_interface").val();
		var clothesIntro = $("input[name='clothesIntro']").val();
		
		/* 공란 체크*/
		/*이름*/
		if(clothesName){
			$(".clothesName_warn").css('display','none');
			clothesNameCK = true;
		} else {
			$(".clothesName_warn").css('display','block');
			clothesNameCK = false;
		}
		/*카테고리 코드*/
		if(cateCode != 'none'){
			$(".cateCode_warn").css('display','none');
			cateCodeCK = true;
		} else {
			$(".cateCode_warn").css('display','block');
			cateCodeCK = false;
		}	
		/*상품 가격*/
		if(clothesPrice != 0){
			$(".clothesPrice_warn").css('display','none');
			clothesPriceCK = true;
		} else {
			$(".clothesPrice_warn").css('display','block');
			clothesPriceCK = false;
		}	
		/*상품 재고*/
		if(clothesStock != 0){
			$(".clothesStock_warn").css('display','none');
			clothesStockCK = true;
		} else {
			$(".clothesStock_warn").css('display','block');
			clothesStockCK = false;
		}		
		/*상품 할인율*/
	    if(!isNaN(clothesDiscount)){
			$(".clothesDiscount_warn").css('display','none');
			clothesDiscountCK = true;
		} else {
			$(".clothesDiscount_warn").css('display','block');
			clothesDiscountCK = false;
		}	
		/*상품내용*/
		if(clothesIntro){
			$(".clothesIntro_warn").css('display','none');
			clothesIntroCK = true;
		} else {
			$(".clothesIntro_warn").css('display','block');
			clothesIntroCK = false;
		}
		
		/* 최종 유효성 검사 */
		if(clothesNameCK && cateCodeCK && clothesPriceCK && clothesStockCK && clothesDiscountCK && clothesIntroCK){
			
			f.method = "POST";
			f.action = "clothes_insert.do";
			f.submit();
		} else {
			return false;
		}
	}
</script>



</head>

<body>
	<form id="clothesForm">
		<div class="register_content_main">
			<div class="register_content">

				<!-- 나머지 폼 요소들 -->

				<div class="form_section">
					<div class="form_section_title">
						<label>의류 이름</label>
					</div>
					<div class="form_section_content">
						<input name="clothesName">
						<span class = "ck_warn clothesName_warn">의류 이름을 입력해주세요.</span>
					</div>
				</div>

				<div class="form_section">
					<div class="form_section_title">
						<label>의류 카테고리</label>
					</div>
					<div class="form_section_content">
						<div class="cate_wrap">
							<span>대분류</span>
							<select class="cate1">
								<option selected value="none">선택</option>
							</select>
						</div>
						<div class="cate_wrap">
							<span>중분류</span>
							<select class="cate2">
								<option selected value="none">선택</option>
							</select>
						</div>
						<div class="cate_wrap">
   							<span>소분류</span>
    						<select class="cate3" name="cateCode">
      						    <option selected value="none">선택</option>
    						</select>
						</div> 
						<span class = "ck_warn cateCode_warn">카테고리를 입력해주세요.</span>
					</div>
				</div>

				<div class="form_section">
					<div class="form_section_title">
						<label>상품 가격</label>
					</div>
					<div class="form_section_content">
						<input name="clothesPrice" value ="0">
						<span class = "ck_warn clothesPrice_warn">상품가격을 입력해주세요.</span>
						
					</div>
				</div>

				<div class="form_section">
					<div class="form_section_title">
						<label>상품 재고</label>
					</div>
					<div class="form_section_content">
						<input name="clothesStock" value ="0">
						<span class = "ck_warn clothesStock_warn">상품재고를 입력해주세요.</span>
					</div>
				</div>

				<div class="form_section">
					<div class="form_section_title">
						<label>의류 할인율</label>
					</div>
					<div class="form_section_content">
						<input id="discount_interface" maxlength="2" value="0">
						<input name="clothesDiscount" type="hidden" value="0">
						<span class="step_val">할인 가격 : <span class="span_discount"></span></span>
						<span class = "ck_warn clothesDiscount_warn">할인률을 1~99 숫자로 입력해주세요.</span>
					</div>
				</div>

				<div class="form_section">
						<div class="form_section_title">
							<label>의류 소개</label>
						</div>
						<div class="form_section_content">
							<input name="clothesIntro">
							<span class = "ck_warn clothesIntro_warn">의류소개를 작성해주세요.</span>
						</div>
				</div>
				
				<div class="form_section">
                    <div class="form_section_title">
                    	<label>상품 이미지</label>
                    </div>
                    <div class="form_section_content">
						<input type="file" id ="fileItem" name='uploadFile' style="height: 30px;">
						<div id="uploadResult">
						<!--
							<div id="result_card">
								<div class="imgDeleteBtn">x</div>
								<img src="/display?fileName=2023/06/23/test.png">
							</div>
						 -->
						</div>			
                    </div>
                </div>

			</div>
			<div class="register_footer">
				<footer class="main_footer">
					<a href="#" class="btn big" onclick="clothes_insert(document.getElementById('clothesForm'))">등록</a>
					<a href="admin.do" class="btn big">취소</a>
				</footer>
			</div>
		</div>
	</form>
	
<script>
    $(document).ready(function() {
        $("#discount_interface").on("propertychange change keyup paste input", function() {
            let userInput = $("#discount_interface");
            let discountInput = $("input[name='clothesDiscount']");
            let discountRate = userInput.val();
            let sendDiscountRate = discountRate / 100;
            
            let goodsPrice = $("input[name='clothesPrice']").val();			// 원가
            let discountPrice = goodsPrice * (1 - sendDiscountRate);		// 할인가격
                    
            
            if(!isNaN(discountRate)){
           	    $(".span_discount").html(discountPrice);
            	discountInput.val(sendDiscountRate);
            }
        });

    $("input[name='clothesPrice']").on("change", function(){
		
		let userInput = $("#discount_interface");
		let discountInput = $("input[name='clothesDiscount']");
		
		let discountRate = userInput.val();					// 사용자가 입력한 할인값
		let sendDiscountRate = discountRate / 100;			// 서버에 전송할 할인값
		let goodsPrice = $("input[name='bookPrice']").val();			// 원가
		let discountPrice = goodsPrice * (1 - sendDiscountRate);		// 할인가격
		
		$(".span_discount").html(discountPrice);
		
	});
    
    // 초기 할인율 값을 0으로 설정
    $("input[name='clothesDiscount']").val(0);
	});
    
    /* 이미지 업로드 */
	$("input[type='file']").on("change", function(e){
		
		/* 이미지 존재시 삭제 */
		if($(".imgDeleteBtn").length > 0){
			deleteFile();
		}
		
		
		let formData = new FormData();
		let fileInput = $('input[name="uploadFile"]');
		let fileList = fileInput[0].files;
		let fileObj = fileList[0];
		
		
		if(!fileCheck(fileObj.name, fileObj.size)){
			return false;
		}
		
		
		formData.append("uploadFile", fileObj);
			$.ajax({
				url: 'uploadAjaxAction.do',
		    	processData : false,
		    	contentType : false,
		    	data : formData,
		    	type : 'POST',
		    	dataType : 'json',
		    	success : function(result){
		    		console.log(result);
		    		showUploadImage(result);
		    		
		    	},
		    	error : function(result){
		    		alert("이미지 파일이 아닙니다.");
		    	}
			});

	});
    
	/* var, method related with attachFile */
	let regex = new RegExp("(.*?)\.(jpg|png)$");
	let maxSize = 1048576; //1MB	
	
	function fileCheck(fileName, fileSize){

		if(fileSize >= maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
			  
		if(!regex.test(fileName)){
			alert("해당 종류의 파일은 업로드할 수 없습니다.");
			return false;
		}
		
		return true;		
		
	}
	/* 이미지 출력 */
	function showUploadImage(uploadResultArr){
		
		/* 전달받은 데이터 검증 */
		if(!uploadResultArr || uploadResultArr.length == 0){return}
		
		let uploadResult = $("#uploadResult");
		
		let obj = uploadResultArr[0];
		
		let str = "";
		
		let fileCallPath = obj.uploadPath.replace(/\\/g, '/') + "/s_"+ obj.fileName;
		console.log(fileCallPath);
		
		str += "<div id='result_card'>";
		str += "<img src='/display?fileName=" + fileCallPath +"'>";
		str += "<div class='imgDeleteBtn' data-file='" + fileCallPath + "'>x</div>";
		str += "<input type='hidden' name='imageList[0].fileName' value='"+ obj.fileName +"'>";
		str += "<input type='hidden' name='imageList[0].uuid' value='"+ obj.uuid +"'>";
		str += "<input type='hidden' name='imageList[0].uploadPath' value='"+ obj.uploadPath +"'>";
		str += "</div>";		
		
   		uploadResult.append(str);     
        
	}
	
	// 이미지 삭제 메서드
	$("#uploadResult").on("click", ".imgDeleteBtn", function(e){
		
		deleteFile();
		
	});
	
	
	// 파일 삭제 메서드
	function deleteFile(){
		
		let targetFile = $(".imgDeleteBtn").data("file");
		
		let targetDiv = $("#result_card");
		
		$.ajax({
			url: 'deleteFile.do',
			data : {fileName : targetFile},
			dataType : 'text',
			type : 'POST',
			success : function(result){
				console.log(result);
				
				targetDiv.remove();
				$("input[type='file']").val("");
			},
			error : function(result){
				console.log(result);
				alert("파일을 삭제하지 못하였습니다.")
			}
       });
		
	}
</script>


</body>
</html>
