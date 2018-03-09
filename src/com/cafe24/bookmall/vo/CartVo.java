package com.cafe24.bookmall.vo;

public class CartVo {

	private long amount;
	private long memberNo;
	private long bookNo;

	public CartVo() {

	}
	
	public CartVo(long amount, long memberNo, long bookNo) {
		super();
		this.amount = amount;
		this.memberNo = memberNo;
		this.bookNo = bookNo;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(long memberNo) {
		this.memberNo = memberNo;
	}

	public long getBookNo() {
		return bookNo;
	}

	public void setBookNo(long bookNo) {
		this.bookNo = bookNo;
	}

	@Override
	public String toString() {
		return "CartVo [amount=" + amount + ", memberNo=" + memberNo + ", bookNo=" + bookNo + "]";
	}

}
