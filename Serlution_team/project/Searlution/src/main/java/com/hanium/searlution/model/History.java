package com.hanium.searlution.model;

public class History 
{	
	private int history_no;
	private int user_no;
	private String history_key;
	private int history_count;
	private String history_date;
	public int getHistory_no() {
		return history_no;
	}
	public void setHistory_no(int history_no) {
		this.history_no = history_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getHistory_key() {
		return history_key;
	}
	public void setHistory_key(String history_key) {
		this.history_key = history_key;
	}
	public int getHistory_count() {
		return history_count;
	}
	public void setHistory_count(int history_count) {
		this.history_count = history_count;
	}
	public String getHistory_date() {
		return history_date;
	}
	public void setHistory_date(String history_date) {
		this.history_date = history_date;
	}
	
	@Override
	public String toString() {
		return "History [history_no=" + history_no + ", user_no=" + user_no + ", history_key=" + history_key
				+ ", history_count=" + history_count + ", history_date=" + history_date + "]";
	}
	
	
}
