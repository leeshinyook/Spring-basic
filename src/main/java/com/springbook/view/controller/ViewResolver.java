package com.springbook.view.controller;


// 접두사와 접미사를 경합하여 최종으로 실행될 View 경로와 파일명을 완성한다.
public class ViewResolver {
	public String prefix;
	public String suffix;
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
}
