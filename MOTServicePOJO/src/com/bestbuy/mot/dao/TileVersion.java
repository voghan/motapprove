package com.bestbuy.mot.dao;


public class TileVersion {
	private String id;
	private String[] key;
	private Version value;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getKey() {
		return key;
	}
	public void setKey(String[] key) {
		this.key = key;
	}
	public Version  getValue() {
		return value;
	}
	public void setValue(Version  value) {
		this.value = value;
	}
		
}
