package com.home.model;

import java.sql.Date;

public class ClothesVO {
	private int clothesId;
	private String clothesName;
	private String cateCode;
	private int clothesPrice;
	private int	clothesStock;
	private double clothesDiscount;
	private String clothesIntro;
	private Date regDate;
	private Date updateDate;
	public int getClothesId() {
		return clothesId;
	}
	public void setClothesId(int clothesId) {
		this.clothesId = clothesId;
	}
	public String getClothesName() {
		return clothesName;
	}
	public void setClothesName(String clothesName) {
		this.clothesName = clothesName;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public int getClothesPrice() {
		return clothesPrice;
	}
	public void setClothesPrice(int clothesPrice) {
		this.clothesPrice = clothesPrice;
	}
	public int getClothesStock() {
		return clothesStock;
	}
	public void setClothesStock(int clothesStock) {
		this.clothesStock = clothesStock;
	}
	public double getClothesDiscount() {
		return clothesDiscount;
	}
	public void setClothesDiscount(double clothesDiscount) {
		this.clothesDiscount = clothesDiscount;
	}
	public String getClothesIntro() {
		return clothesIntro;
	}
	public void setClothesIntro(String clothesIntro) {
		this.clothesIntro = clothesIntro;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "ClothesVO [clothesId=" + clothesId + ", clothesName=" + clothesName + ", cateCode=" + cateCode
				+ ", clothesPrice=" + clothesPrice + ", clothesStock=" + clothesStock + ", clothesDiscount="
				+ clothesDiscount + ", clothesIntro=" + clothesIntro + ", regDate=" + regDate + ", updateDate="
				+ updateDate + "]";
	}
	
	
}
