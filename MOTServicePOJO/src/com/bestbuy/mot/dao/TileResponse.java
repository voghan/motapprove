package com.bestbuy.mot.dao;

import java.util.List;

public class TileResponse {

	private int total_rows;
	private int offset;
	private List<TileVersion> rows;
	
	public int getTotal_rows() {
		return total_rows;
	}

	public void setTotal_rows(int total_rows) {
		this.total_rows = total_rows;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public List<TileVersion> getRows() {
		return rows;
	}

	public void setRows(List<TileVersion> rows) {
		this.rows = rows;
	}
	
}
