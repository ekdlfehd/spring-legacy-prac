package com.home.model;

import java.util.Arrays;

public class Criteria {
	/* 현재 페이지 번호 */
    private int pageNum;
    
    /* 페이지 표시 개수 */
    private int amount;
    
    /* 검색 타입 */
    private String type;
    
    /* 검색 키워드 */
    private String keyword;
    
    /* 의류 리스트 */
    private String[] clothesArr;
    
    /* 카테고리 코드 */
    private String cateCode;
    
    /* 카테고리 네임*/
    private String cateName;
    
    /* 상품 번호(댓글기능) */
    private int clothesId;
    
    /* Criteria 생성자 */
    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }
    

	/* Criteria 기본 생성자 */
    public Criteria(){
        this(1,10);
    }
    
    /* 검색 타입 데이터 배열 변환 */
    public String[] getTypeArr() {
        return type == null? new String[] {}:type.split("");
    }

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}


		public String[] getClothesArr() {
			return clothesArr;
		}

		public void setClothesArr(String[] clothesArr) {
			this.clothesArr = clothesArr;
		}



		public String getCateName() {
			return cateName;
		}


		public void setCateName(String cateName) {
			this.cateName = cateName;
		}




		public int getClothesId() {
			return clothesId;
		}


		public void setClothesId(int clothesId) {
			this.clothesId = clothesId;
		}


		@Override
		public String toString() {
			return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", type=" + type + ", keyword=" + keyword
					+ ", clothesArr=" + Arrays.toString(clothesArr) + ", cateCode=" + cateCode + ", cateName="
					+ cateName + ", clothesId=" + clothesId + "]";
		}

		
    

}
