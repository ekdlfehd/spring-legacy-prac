/**
 * 
 */

$(function(){
	// 메인화면
	if($('.main_slide_wrapper').length){
		var swiper = new Swiper('.main_slide_container', {
			slidesPerView: 3,
			spaceBetween: 25,
			pagination: {
				el: ".swiper_pagination",
				clickable: true,
			},

		});
	}
	// 홈 카테고리 슬라이드
	var menuswiper = new Swiper(".category_menus", {
		slidesPerView : 2.5,
		spaceBetween : 27,
		loop : true,
		loopFillGroupWithBlank : true,
	});

	// Aside menu
	if($('.aside_menu_toggle').length){
		var asideToggleBtn = $('.aside_menu_toggle');

		asideToggleBtn.click(function(){
			$('body').toggleClass('aside_active');
		});
	}

}); // document.ready