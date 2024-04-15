package com.home.model;

public class CartDTO {
	private int cartId;
    
    private String memberId;
    
    private int clothesId;
    
    private int clothesCount;
    
    //clothes
    
    private String clothesName;
    
    private int clothesPrice;
    
    private double clothesDiscount;
    
    // 추가
    private int salePrice;
    
    private int totalPrice;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getClothesId() {
		return clothesId;
	}

	public void setClothesId(int clothesId) {
		this.clothesId = clothesId;
	}

	public int getClothesCount() {
		return clothesCount;
	}

	public void setClothesCount(int clothesCount) {
		this.clothesCount = clothesCount;
	}

	public String getClothesName() {
		return clothesName;
	}

	public void setClothesName(String clothesName) {
		this.clothesName = clothesName;
	}

	public int getClothesPrice() {
		return clothesPrice;
	}

	public void setClothesPrice(int clothesPrice) {
		this.clothesPrice = clothesPrice;
	}

	public double getClothesDiscount() {
		return clothesDiscount;
	}

	public void setClothesDiscount(double clothesDiscount) {
		this.clothesDiscount = clothesDiscount;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void initSaleTotal() {
		this.salePrice = (int) (this.clothesPrice * (1-this.clothesDiscount));
		this.totalPrice = this.salePrice*this.clothesCount;
	}
	
	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", memberId=" + memberId + ", clothesId=" + clothesId + ", clothesCount="
				+ clothesCount + ", clothesName=" + clothesName + ", clothesPrice=" + clothesPrice
				+ ", clothesDiscount=" + clothesDiscount + ", salePrice=" + salePrice + ", totalPrice=" + totalPrice
				+ "]";
	}
    
    
}
