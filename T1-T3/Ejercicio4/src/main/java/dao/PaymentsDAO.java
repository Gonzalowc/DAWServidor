package dao;

import java.util.ArrayList;

import singletonDAO.Payment;

public interface PaymentsDAO {
	boolean createPayment(int customerNumber, String checkNumber, String paymentDate, double amount);
	boolean existCustomerNumber(int customerNumber);
	ArrayList<Payment> getPayments();
}
