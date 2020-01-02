package com.springbook.biz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class TVUser {

	public static void main(String[] args) {
		
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationcontext.xml"	);
		
		

		TV tv = (TV)factory.getBean("tv");

		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. Spring 컨테이너를 종료한다.
		factory.close();
	}

}
