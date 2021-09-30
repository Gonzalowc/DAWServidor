package inyector;

import implementations.PaymentsImpl;
import singletonDAO.ConectorMDB;

public class Principal {
	public static void main(String[] args) {
		PaymentsImpl payment1 = new PaymentsImpl();
		//System.out.println(payment1.createPayment(103, "prueba", "2021-09-30", 600));
		System.out.println(payment1.existCustomerNumber(103));
		System.out.println(payment1.getPayments());
		ConectorMDB.close();
	}
}
