package com.home.service;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.mapper.AttachMapper;
import com.home.mapper.ClothesMapper;
import com.home.model.AttachImageVO;
import com.home.model.ClothesVO;
import com.home.model.Criteria;

@Service
public class ClothesServiceImpl implements ClothesService {
	
	@Autowired
	private ClothesMapper clothesMapper;
	@Autowired
	private AttachMapper attachMapper;
	
	/* 상품 검색 */
	@Override
	public List<ClothesVO> getGoodsList(Criteria cri){
		String type = cri.getType();
		String[] typeArr = type.split("");
		
		/* 의류이름으로만 검색했을 시 */
		for(String t : typeArr) {
			if(t.equals("T")) {
				String[] clothesName = clothesMapper.getClothesNameList(cri.getKeyword());
				cri.setClothesArr(clothesName);
			}
		}
		
		
		
		List<ClothesVO> list = clothesMapper.getGoodsList(cri);
		
		list.forEach(new Consumer<ClothesVO>() {
			@Override
			public void accept(ClothesVO clothes) {
				
				int clothesId = clothes.getClothesId();
				
				List<AttachImageVO> imageList = attachMapper.getAttachList(clothesId);
				
				clothes.setImageList(imageList);
				
			}
		});
		return list;
	}
	
	/* 상품 총갯수 */
	@Override
	public int goodsGetTotal(Criteria cri) {
		
		return clothesMapper.goodsGetTotal(cri);
	}
}
