package com.home.model;

public class OrderItemDTO {
	/* 주문받은 상품에 대한 데이터 */
	/* 주문 번호 */
	private String orderId;
	
	/* 상품 번호 */
    private int clothesId;
    
	/* 주문 수량 */
    private int clothesCount;
    
	/* clothes_orderItem 기본키 */
    private int orderItemId;
    
	/* 상품 한 개 가격 */
    private int clothesPrice;
    
	/* 상품 할인 율 */
    private double clothesDiscount;
    
	/* 상품 한개 구매 시 획득 포인트 */
    private int savePoint;
    
	/* DB테이블 존재 하지 않는 데이터 */
    
	/* 할인 적용된 가격 */
    private int salePrice;
    
	/* 총 가격(할인 적용된 가격 * 주문 수량) */
    private int totalPrice;
    
	/* 총 획득 포인트(상품 한개 구매 시 획득 포인트 * 수량) */
    private int totalSavePoint;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
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

	public int getSavePoint() {
		return savePoint;
	}

	public void setSavePoint(int savePoint) {
		this.savePoint = savePoint;
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

	public int getTotalSavePoint() {
		return totalSavePoint;
	}

	public void setTotalSavePoint(int totalSavePoint) {
		this.totalSavePoint = totalSavePoint;
	}

	@Override
	public String toString() {
		return "OrderItemDTO [orderId=" + orderId + ", clothesId=" + clothesId + ", clothesCount=" + clothesCount
				+ ", orderItemId=" + orderItemId + ", clothesPrice=" + clothesPrice + ", clothesDiscount="
				+ clothesDiscount + ", savePoint=" + savePoint + ", salePrice=" + salePrice + ", totalPrice="
				+ totalPrice + ", totalSavePoint=" + totalSavePoint + "]";
	}
	public void initSaleTotal() {
		this.salePrice = (int) (this.clothesPrice * (1-this.clothesDiscount));
		this.totalPrice = this.salePrice*this.clothesCount;
		this.savePoint = (int)(Math.floor(this.salePrice*0.05));
		this.totalSavePoint =this.savePoint * this.clothesCount;
	}
}

