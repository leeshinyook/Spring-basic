package com.springbook.biz;

public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker 객체 생성.");
	}
	public void volumeUp() {
		System.out.println("AppleSpeaker --- 소리올린다.");
	}
	public void volumeDown() {
		System.out.println("AppleSpeaker --- 소리내린다.");
	}
}
