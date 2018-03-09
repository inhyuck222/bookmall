package com.cafe24.bookmall.vo;

public class BookVo {
	private long no;
	private String name;
	private long cost;
	private long categoryNo;

	public BookVo() {

	}
	
	public BookVo(long no, String name, long cost, long categoryNo) {
		super();
		this.no = no;
		this.name = name;
		this.cost = cost;
		this.categoryNo = categoryNo;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public long getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(long categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", name=" + name + ", cost=" + cost + ", categoryNo=" + categoryNo + "]";
	}

}
