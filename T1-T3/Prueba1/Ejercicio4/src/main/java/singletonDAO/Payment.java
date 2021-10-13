package singletonDAO;

import java.util.Objects;

public class Payment {
	private int customerNumber;
	private String checkNumber;
	private String paymentDate;
	private double amount;
	public Payment(int customerNumber, String checkNumber, String paymentDate, double amount) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(amount, checkNumber, customerNumber, paymentDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(checkNumber, other.checkNumber)
				&& customerNumber == other.customerNumber && Objects.equals(paymentDate, other.paymentDate);
	}
	@Override
	public String toString() {
		return "Payment [customerNumber=" + customerNumber + ", checkNumber=" + checkNumber + ", paymentDate="
				+ paymentDate + ", amount=" + amount + "]";
	}


	public int getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}


	public String getCheckNumber() {
		return checkNumber;
	}


	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}


	public String getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}

}
