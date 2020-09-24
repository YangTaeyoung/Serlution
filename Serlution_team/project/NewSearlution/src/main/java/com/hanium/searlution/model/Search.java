package com.hanium.searlution.model;

public class Search {
	private int ser_no;
	private String ser_title;
	private String ser_content;
	private String ser_link;
	private String ser_date;
	
	public int getSer_no() {
		return ser_no;
	}
	public void setSer_no(int ser_no) {
		this.ser_no = ser_no;
	}
	public String getSer_title() {
		return ser_title;
	}
	public void setSer_title(String ser_title) {
		this.ser_title = ser_title;
	}
	public String getSer_content() {
		return ser_content;
	}
	public void setSer_content(String ser_content) {
		this.ser_content = ser_content;
	}
	public String getSer_link() {
		return ser_link;
	}
	public void setSer_link(String ser_link) {
		this.ser_link = ser_link;
	}
	public String getSer_date() {
		return ser_date;
	}
	public void setSer_date(String ser_date) {
		this.ser_date = ser_date;
	}
	
	@Override
	public String toString() {
		return "Search [ser_no=" + ser_no + ", ser_title=" + ser_title + ", ser_content=" + ser_content + ", ser_link="
				+ ser_link + ", ser_date=" + ser_date + "]";
	}
	
	
}
