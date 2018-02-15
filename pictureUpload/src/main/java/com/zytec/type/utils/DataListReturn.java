package com.zytec.type.utils;

import java.util.Map;

public class DataListReturn {
	//返回信息 success  fail
	String message;
	//返回状态  true false
	boolean status;
	//返回数据集合
	Map<String,Object> dataList;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Map<String, Object> getDataList() {
		return dataList;
	}
	public void setDataList(Map<String, Object> dataList) {
		this.dataList = dataList;
	}
	
}
