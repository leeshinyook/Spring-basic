package com.spring.ioc.injection;

import java.util.List;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.spring.ioc.injection.CollectionBean;

public class CollectionBeanClient {	

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
	
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
//		bean.setAddressList(addressList);
//		for(String address : addressList) {
//			System.out.println(address.toString());
//		}
		
		factory.close();
	}

}
