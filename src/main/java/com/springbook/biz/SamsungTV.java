package com.springbook.biz;

public class SamsungTV implements TV {
	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) 객체 생성");
	}
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("===> SamsungTV(2) 객체 생성 ");
		this.speaker = speaker;
	}
	public void initMethod() {
		System.out.println("객체 초기화 작업처리...");
	}
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}
	public void powerOn() {
		System.out.println("SamsungTV --- 전원 켠다.");
	}
	public void powerOff() {
		System.out.println("SamsungTV --- 전 끝다.");
	}
	public void volumeUp() {
//		speaker = new SonySpeaker();
		speaker.volumeUp();
//		System.out.println("SamsungTV --- 소리 올린다.");
	}
	public void volumeDown() {
//		speaker = new SonySpeaker();
		speaker.volumeDown();
//		System.out.println("SamsungTV --- 소리 내린다.");
	}

}
