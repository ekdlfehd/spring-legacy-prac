package com.home.model;

public class AttachImageVO {

	// 경로
	private String uploadPath;
	// uuid
	private String uuid;
	// 파일 이름
	private String fileName;
	// 상품 id
	private int clothesId;
	
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getClothesId() {
		return clothesId;
	}
	public void setClothesId(int clothesId) {
		this.clothesId = clothesId;
	}
	@Override
	public String toString() {
		return "AttachImageVO [uploadPath=" + uploadPath + ", uuid=" + uuid + ", fileName=" + fileName + ", clothesId="
				+ clothesId + "]";
	}
	
	
}
