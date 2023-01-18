package com.csis3475.second.week.queue;

public class Customer {
	private int arrivalTime;
	private int transactionTime;
	private int customerNumber;
	public Customer(int clock, int serviceTime, int number) {
		// TODO Auto-generated constructor stub
		arrivalTime = clock;
		transactionTime = serviceTime;
		customerNumber = number;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(int transactionTime) {
		this.transactionTime = transactionTime;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

}
