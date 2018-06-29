package com.zytec.javaee.utils;

import java.util.Map;

public class DataListReturn {
	
	private String message;
	
	private Boolean status;
	
	private Map<String, Object> dataList;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Map<String, Object> getDataList() {
		return dataList;
	}

	public void setDataList(Map<String, Object> dataList) {
		this.dataList = dataList;
	}
	

}
