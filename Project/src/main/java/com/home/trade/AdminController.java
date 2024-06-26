package com.home.trade;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.mapper.AttachMapper;
import com.home.model.AttachImageVO;
import com.home.model.ClothesVO;
import com.home.model.Criteria;
import com.home.model.OrderDTO;
import com.home.model.PageDTO;
import com.home.model.ReplyDTO;
import com.home.service.AdminService;
import com.home.service.ClothesService;
import com.home.service.ReplyService;

import util.Common;


@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private AttachMapper attachMapper;
	@Autowired
	private ClothesService clothesService;
	@Autowired
	private ReplyService replyService;
	
	// 관리자 페이지 이동
	@RequestMapping("admin.do")
	public String admin_page() {
		return Common.ADMIN + "admin_main.jsp";
	}
	
	// 상품조회 페이지로 이동
	@RequestMapping("Detail.do")
	public String Detail_page() {
		
		return Common.ADMIN + "goodsDetail.jsp";
	}
	
	// 상품등록 페이지로 이동
	@RequestMapping("register.do")
	public String register(Model model) throws JsonProcessingException {
		
		ObjectMapper objm = new ObjectMapper();
		
		List list = adminService.cateList();
		
		String cateList = objm.writeValueAsString(list);
		
		model.addAttribute("cateList",cateList);
		
		return Common.ADMIN + "register.jsp";
	}
	
	// 상품 목록 페이지로 이동
	@RequestMapping("register_list.do")
	public String register_list(Criteria cri,Model model)throws Exception {
		
		/* 상품 리스트 데이터 */
		List list = adminService.goodsGetList(cri);
		
		if(!list.isEmpty()) {
			model.addAttribute("list", list);
		} else {
			model.addAttribute("listCheck", "empty");
			return null;
		}
		
		/* 페이지 인터페이스 데이터 */
		int total = adminService.goodsGetTotal(cri);
		PageDTO pageMaker = new PageDTO(cri, total);
		
		model.addAttribute("pageMaker", new PageDTO(cri, adminService.goodsGetTotal(cri)));

		return Common.ADMIN + "register_list.jsp"; 
	}
	
	// 상품조회 페이지로 이동
	@RequestMapping("Detail_insert.do")
	public String goodsGetInfoGET(int clothesId,Criteria cri,Model model)throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		
		/* 카테고리 리스트 데이터 */
		model.addAttribute("cateList", mapper.writeValueAsString(adminService.cateList()));
		
		// 목록페이지 조건 정보
		model.addAttribute("cri",cri);
		
		// 조회페이지 정보
		model.addAttribute("goodsInfo",adminService.goodsGetDetail(clothesId));
		
		return Common.ADMIN + "goodsDetail.jsp";
		
	}
	
	// 상품수정 페이지로 이동
	@RequestMapping("Detail_insert2.do")
	public String goodsGetInfoGET2(int clothesId,Criteria cri,Model model)throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		
		/* 카테고리 리스트 데이터 */
		model.addAttribute("cateList", mapper.writeValueAsString(adminService.cateList()));
		
		// 목록페이지 조건 정보
		model.addAttribute("cri",cri);
		
		// 조회페이지 정보
		model.addAttribute("goodsInfo",adminService.goodsGetDetail(clothesId));
		
		return Common.ADMIN + "goodsModify.jsp";
		
	}
	
	// 검색페이지로이동
	
	
	
	// 상품등록
	@RequestMapping("clothes_insert.do")
	public String goodsEnrollPOST(ClothesVO clothes, RedirectAttributes rttr) {
	    adminService.clothesEnroll(clothes);
	    rttr.addFlashAttribute("enroll_result", clothes.getClothesName());
	    return "redirect:admin.do";
	}
	
	// 상품수정
	@RequestMapping("Modify_insert.do")
	public String goodsModifyPOST(ClothesVO vo,RedirectAttributes rttr) {
		
		int result = adminService.goodsModify(vo);
		
		rttr.addFlashAttribute("modify_result",result);
		
		return "redirect:register_list.do";
	}
	
	// 상품 삭제
	@RequestMapping("register_delete.do")
	public String goodsDeletePOST(int clothesId,RedirectAttributes rttr) {
			List<AttachImageVO> fileList = adminService.getAttachInfo(clothesId);
			
			if(fileList != null) {
				final List<Path> pathList = new ArrayList();
				
				fileList.forEach(new Consumer<AttachImageVO>() {
					@Override
					public void accept(AttachImageVO vo) {
						
					// 원본 이미지
					Path path = Paths.get("C:\\upload", vo.getUploadPath(), vo.getUuid() + "_" + vo.getFileName());
					pathList.add(path);
						
					// 섬네일 이미지
					path = Paths.get("C:\\upload", vo.getUploadPath(), "s_" + vo.getUuid()+"_" + vo.getFileName());
					pathList.add(path);
						
					}
				});
				
				pathList.forEach(new Consumer<Path>() {
					@Override
					public void accept(Path path) {
					path.toFile().delete();
					}
				});
			}
			
			int result = adminService.goodsDelete(clothesId);
			
			rttr.addFlashAttribute("delete_result",result);
			
		return "redirect:register_list.do";
	}
	
	// 상품 이미지 저장, 등록
	@PostMapping(value = "/uploadAjaxAction.do", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttachImageVO>> uploadAjaxActionPOST(@RequestParam("uploadFile") MultipartFile[] uploadFiles) {
		
		/* 이미지 파일 체크 */
		for(MultipartFile multipartFile: uploadFiles) {
			
			File checkfile = new File(multipartFile.getOriginalFilename());
			String type = null;
			
			try {
				type = Files.probeContentType(checkfile.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(!type.startsWith("image")) {
				
				List<AttachImageVO> list = null;
				return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
				
			}
			
		}// for
		
	    String uploadFolder = "C:\\upload";

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String datePath = sdf.format(new Date()).replace("-", File.separator);

	    File uploadPath = new File(uploadFolder, datePath);
	    if (!uploadPath.exists()) {
	        uploadPath.mkdirs();
	    }

		/* 이미저 정보 담는 객체 */
		List<AttachImageVO> list = new ArrayList();
		
	    for (MultipartFile file : uploadFiles) {
	    	
	    	// 이미지 정보 객체
	    	AttachImageVO vo = new AttachImageVO();
	    	
	    	// 파일 이름
	        String originalFileName = file.getOriginalFilename();
	        vo.setFileName(originalFileName);
	        vo.setUploadPath(datePath);

	        // UUID 적용 파일 이름 생성
	        String uuid = UUID.randomUUID().toString();
	        vo.setUuid(uuid);
	        
	        String savedFileName = uuid + "_" + originalFileName;

	        String filePath = uploadPath.getAbsolutePath() + File.separator + savedFileName;

	        try {
	            File saveFile = new File(filePath);
	            byte[] fileData = file.getBytes();
	            FileCopyUtils.copy(fileData, saveFile);
	            
				File thumbnailFile = new File(uploadPath, "s_" + originalFileName);
				
				BufferedImage bo_image = ImageIO.read(saveFile);
				
				/* 비율 */
				double ratio = 3;
				/*넓이 높이*/
				int width = (int) (bo_image.getWidth() / ratio);
				int height = (int) (bo_image.getHeight() / ratio);
				
				BufferedImage bt_image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
								
				Graphics2D graphic = bt_image.createGraphics();
				
				graphic.drawImage(bo_image, 0, 0,width,height, null);
					
				ImageIO.write(bt_image, "jpg", thumbnailFile);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        list.add(vo);
	    }//for
	    ResponseEntity<List<AttachImageVO>> result = new ResponseEntity<List<AttachImageVO>>(list, HttpStatus.OK);
	    return result;
	}

	@PostMapping("deleteFile.do")
	public ResponseEntity<String> deleteFile(String fileName){
		
		File file = null;
		
		try {
			
			// 섬네일 파일 삭제
			file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));
			
			file.delete();
			
			// 원본 파일 삭제
			String OriginFileName = file.getAbsolutePath().replace("s_","");
			
			file = new File(OriginFileName);
			
			file.delete();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return new ResponseEntity<String>("fail", HttpStatus.NOT_IMPLEMENTED);
			
		}
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
	
	/* 이미지 정보 반환 */
	@GetMapping(value="/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AttachImageVO>> getAttachList(int clothesId){
		return new ResponseEntity<List<AttachImageVO>>(attachMapper.getAttachList(clothesId), HttpStatus.OK);
	}
	
	/* 상품검색 */
	@GetMapping("searchBtn.do")
	public String searchGoodsGet(Criteria cri,Model model) {
		
		List<ClothesVO> list = clothesService.getGoodsList(cri);
		if(!list.isEmpty()) {
			model.addAttribute("list",list);
		}else {
			model.addAttribute("listCheck","empty");
			return Common.VIEW_PATH +"search.jsp";
		}
		model.addAttribute("pageMaker", new PageDTO(cri, clothesService.goodsGetTotal(cri)));
		return Common.VIEW_PATH +"search.jsp";
	}
	
	/* 상품 상세 */
	@GetMapping("goodsDetail_list.do{clothesId}")
	public String goodsDetailGET(@PathVariable("clothesId")int clothesId, Model model) {
		
		
		model.addAttribute("goodsInfo", clothesService.getGoodsInfo(clothesId));
		
		return Common.VIEW_PATH +"goodsDetail_list.jsp";
	}
	
	/* 리뷰 쓰기 */
	@GetMapping("replyEnroll.do{memberId}")
	public String replyEnrollWindowGET(@PathVariable("memberId")String memberId, int clothesId, Model model) {
		ClothesVO clothes = clothesService.getClothesIdName(clothesId);
		model.addAttribute("clothesInfo", clothes);
		model.addAttribute("memberId", memberId);
		
		return Common.VIEW_PATH +"replyEnroll.jsp";
	}
	
	/* 댓글 수정 팝업창*/
	@GetMapping("/replyUpdate")
	public String replyUpdateWindowGET(ReplyDTO dto, Model model) {
		ClothesVO clothes = clothesService.getClothesIdName(dto.getClothesId());
		model.addAttribute("clothesInfo", clothes);
		model.addAttribute("replyInfo", replyService.getUpdateReply(dto.getReplyId()));
		model.addAttribute("memberId", dto.getMemberId());
		
		return Common.VIEW_PATH +"replyUpdate.jsp";
	}
	
	/* 주문 현황 페이지 */
	@GetMapping("/admin/orderList")
	public String orderListGET(Criteria cri, Model model) {
		List<OrderDTO> list = adminService.getOrderList(cri);
		
		if(!list.isEmpty()) {
			model.addAttribute("list", list);
			model.addAttribute("pageMaker", new PageDTO(cri, adminService.getOrderTotal(cri)));
		} else {
			model.addAttribute("listCheck", "empty");
		}
		
		return Common.ADMIN +"orderList.jsp";
	}
	
}
