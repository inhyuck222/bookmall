package com.cafe24.bookmall.vo;

public class OrderVo {

	private long no;
	private String name;
	private long payment;
	private String destination;
	private long memberNo;

	public OrderVo() {

	}

	public OrderVo(long no, String name, long payment, String destination, long memberNo) {
		super();
		this.no = no;
		this.name = name;
		this.payment = payment;
		this.destination = destination;
		this.memberNo = memberNo;
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

	public long getPayment() {
		return payment;
	}

	public void setPayment(long payment) {
		this.payment = payment;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(long memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", name=" + name + ", payment=" + payment + ", destination=" + destination
				+ ", memberNo=" + memberNo + "]";
	}

}
