package com.cafe24.bookmall.vo;

public class OrderBookVo {

	private long bookNo;
	private long orderNo;
	private long amount;
	private long cost;
	
	public OrderBookVo() {

	}
	
	public OrderBookVo(long bookNo, long orderNo, long amount, long cost) {
		super();
		this.bookNo = bookNo;
		this.orderNo = orderNo;
		this.amount = amount;
		this.cost = cost;
	}

	public long getBookNo() {
		return bookNo;
	}

	public void setBookNo(long bookNo) {
		this.bookNo = bookNo;
	}

	public long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "OrderBookVo [bookNo=" + bookNo + ", orderNo=" + orderNo + ", amount=" + amount + ", cost=" + cost + "]";
	}
	
}
