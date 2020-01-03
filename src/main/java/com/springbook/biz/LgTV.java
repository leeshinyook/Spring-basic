package com.springbook.biz;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")

public class LgTV implements TV {

	@Resource(name="apple")
	private Speaker speaker;
	public void powerOn() {
		System.out.println("LgTV --- 전원켠다.");
	}
	public void powerOff() {
		System.out.println("LgTV --- 전원끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	
}
