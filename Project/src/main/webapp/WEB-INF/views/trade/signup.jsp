<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>login</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css" />
<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	var idCheck = false;
	var idckCheck = false;
	var nameCheck = false;
	var emailCheck = false;
	var pwCheck = false;
	var pw2Check = false;
	var phoneCheck = false;
	var add1Check = false;
	var add2Check = false;
	var add3Check = false;

	function signup_insert(f) {

		var id = $('.id_input').val();
		var name = $('.name_input').val();
		var email = $('.email_input').val();
		var pw = $('.pw_input').val();
		var pw2 = $('.pw2_input').val();
		var phone = $('.phone_input').val();
		var add1 = $('.form-control1').val();
		var add2 = $('.form-control2').val();
		var add3 = $('.form-control3').val();

		/* 아이디 유효성 검사 */
		if (id == "") {
			$('.final_id_ck').css('display', 'block');
			idCheck = false;
		} else {
			$('.final_id_ck').css('display', 'none');
			idCheck = true;
		}

		/* 이름유효성 검사 */
		if (name == "") {
			$('.final_name_ck').css('display', 'block');
			nameCheck = false;
		} else {
			$('.final_name_ck').css('display', 'none');
			nameCheck = true;
		}
		/* 이메일유효성 검사 */
		if (email == "") {
			$('.final_mail_ck').css('display', 'block');
			emailCheck = false;
		} else {
			$('.final_mail_ck').css('display', 'none');
			emailCheck = true;
		}
		/* 비밀번호 유효성 검사 */
		if (pw == "") {
			$('.final_pw_ck').css('display', 'block');
			pwCheck = false;
		} else {
			$('.final_pw_ck').css('display', 'none');
			pwCheck = true;
		}

		/* 비밀번호 확인 유효성 검사 */
		if (pw2 == "") {
			$('.final_pw2_ck').css('display', 'block');
			pw2Check = false;
		} else {
			$('.final_pw2_ck').css('display', 'none');
			pw2Check = true;
		}

		/* 전화번호 유효성 검사 */
		if (phone == "") {
			$('.final_phone_ck').css('display', 'block');
			phoneCheck = false;
		} else {
			$('.final_phone_ck').css('display', 'none');
			phoneCheck = true;
		}

		/* 주소1 유효성 검사 */
		if (add1 == "") {
			$('.final_add1_ck').css('display', 'block');
			add1Check = false;
		} else {
			$('.final_add1_ck').css('display', 'none');
			add1Check = true;
		}

		/* 주소2 유효성 검사 */
		if (add2 == "") {
			$('.final_add2_ck').css('display', 'block');
			add2Check = false;
		} else {
			$('.final_add2_ck').css('display', 'none');
			add2Check = true;
		}

		/* 주소3 유효성 검사 */
		if (add3 == "") {
			$('.final_add3_ck').css('display', 'block');
			add3Check = false;
		} else {
			$('.final_add3_ck').css('display', 'none');
			add3Check = true;
		}

		/* 최종 유효성 검사 */
		if (idCheck && idckCheck && nameCheck && emailCheck && pwCheck
				&& pw2Check && phoneCheck && add1Check && add2Check
				&& add3Check) {

			f.method = "POST";
			f.action = "signup_insert.do";
			f.submit();
		}
		return false;
	}
</script>
</head>

<body>
	<main>
		<header class="signup">
			<a href="main_list2.do" class="sprite close">close</a>
			<h1 class="heading5">Sign Up</h1>
		</header>
		<section class="sub_content">
			<form class="login_form signup_form">
				<fieldset>
					<legend class="hidden">signup form</legend>


					<label for="memberId">ID</label>
					<input type="text" class="id_input" id="memberId" name="memberId" placeholder="아이디">
					<span class="id_input_re_1">사용 가능한 아이디입니다.</span>
					<span class="id_input_re_2">아이디가 이미 존재합니다.</span>
					<span class="final_id_ck">아이디를 입력해주세요.</span>

					<label for="memberName">Name</label>
					<input type="text" class="name_input" id="memberName" name="memberName" placeholder="이름">
					<span class="final_name_ck">이름을 입력해주세요.</span>

					<label for="memberMail">Email</label>
					<input type="text" class="email_input" id="memberMail" name="memberMail" placeholder="이메일 주소">
					<span class="final_mail_ck">이메일을 입력해주세요.</span>

					<label for="memberPw">Password</label>
					<input type="password" class="pw_input" id="memberPw" name="memberPw" placeholder="비밀번호">
					<span class="final_pw_ck">비밀번호를 입력해주세요.</span>

					<label for="memberPw2">Password Check</label>
					<input type="password" class="pw2_input" id="memberPw2" name="memberPw2" placeholder="비밀번호 확인">
					<span class="final_pw2_ck">비밀번호를 다시 입력해주세요.</span>
					<span class="pw2_input_re_1">비밀번호가 일치합니다.</span>
					<span class="pw2_input_re_2">비밀번호가 일치하지 않습니다.</span>

					<label for="memberNumber">Phone Number (xxx-xxxx-xxxx)</label>
					<input type="text" class="phone_input" id="memberNumber" name="memberNumber" placeholder="휴대폰 번호 (xxx-xxxx-xxxx)" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}">
					<span class="final_phone_ck">전화번호를 입력해주세요.</span>


					<div class="signup-purpose">
						<label class="purpose" for="adminCk">회원가입 유형 선택</label>
						<select
							name="adminCk" id="adminCk">
							<option value="0">일반 회원</option>
							<option value="1">기업 회원</option>
						</select>
					</div>

					<label for="useraddr">Address</label>
					<div class="form-group">
						<input class="form-control1" style="width: 40%; display: inline;"
							placeholder="우편번호" name="memberAddr1" id="memberAddr1"
							type="text" readonly="readonly">
						<button type="button" class="btn1 btn-default"
							onclick="execPostCode();">
							<i class="fa fa-search"></i> 우편번호 찾기
						</button>
						<span class="final_add1_ck">우편번호를 입력해주세요.</span>
					</div>
					<div class="form-group">
						<input class="form-control2" style="top: 5px;" placeholder="도로명 주소"
							name="memberAddr2" id="memberAddr2" type="text"
							readonly="readonly" /> <span class="final_add2_ck">도로명주소를
							입력해주세요.</span>
					</div>
					<div class="form-group">
						<input class="form-control3" placeholder="상세주소" name="memberAddr3"
							id="memberAddr3" type="text" /> <span class="final_add3_ck">상세주소를
							입력해주세요.</span>
					</div>





				</fieldset>
				<input type="button" value="Sign Up" class="btn big"
					onclick="signup_insert(this.form)">
			</form>
		</section>
	</main>

	<Script>
		function execPostCode() {
			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
					var extraRoadAddr = ''; // 도로명 조합형 주소 변수

					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraRoadAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraRoadAddr += (extraRoadAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraRoadAddr !== '') {
						extraRoadAddr = ' (' + extraRoadAddr + ')';
					}
					// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
					if (fullRoadAddr !== '') {
						fullRoadAddr += extraRoadAddr;
					}

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					console.log(data.zonecode);
					console.log(fullRoadAddr);

					$("[name=memberAddr1]").val(data.zonecode);
					$("[name=memberAddr2]").val(fullRoadAddr);

					/* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
					document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
					document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
				}
			}).open();
		}
	</Script>
	<script>
		$(document).ready(
				function() {
					// 아이디 중복검사
					$('.id_input').on(
							"propertychange change keyup paste input",
							function() {
								var memberId = $('.id_input').val();
								var data = {
									memberId : memberId
								};

								$.ajax({
									type : "post",
									url : "/memberIdChk",
									data : data,

									success : function(result) {
										if (result != 'fail') {
											$('.id_input_re_1').css("display",
													"inline-block");
											$('.id_input_re_2').css("display",
													"none");
											idckCheck = true;
										} else {
											$('.id_input_re_2').css("display",
													"inline-block");
											$('.id_input_re_1').css("display",
													"none");
											idckCheck = false;
										}
									} // success 종료
								});
							}); // 아이디 중복검사 종료
				});
	</script>

	<script>
		/* 비밀번호 확인 일치 유효성 검사 */

		$('.pw2_input').on("propertychange change keyup paste input",
				function() {
					var pw = $('.pw_input').val();
					var pw2 = $('.pw2_input').val();
					$('.final_pw2_ck').css('display', 'none');

					if (pw == pw2) {
						$('.pw2_input_re_1').css('display', 'block');
						$('.pw2_input_re_2').css('display', 'none');
						pw2Check = true;
					} else {
						$('.pw2_input_re_1').css('display', 'none');
						$('.pw2_input_re_2').css('display', 'block');
						pw2Check = false;
					}

				});
	</script>
</body>
</html>
