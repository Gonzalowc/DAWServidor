package implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.PaymentsDAO;
import singletonDAO.ConectorMDB;
import singletonDAO.Payment;

public class PaymentsImpl implements PaymentsDAO {
	private Connection con = ConectorMDB.getConnection();

	@Override
	public boolean createPayment(int customerNumber, String checkNumber, String paymentDate, double amount) {
		String sql = "insert into payments(customerNumber, checkNumber, paymentDate,amount) values(?,?,?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, customerNumber);
			stmt.setString(2, checkNumber);
			stmt.setString(3, paymentDate);
			stmt.setDouble(4, amount);
			if (existCustomerNumber(customerNumber)) {
				stmt.execute();
				return true;

			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean existCustomerNumber(int customerNumber) {

		String sql = "SELECT * FROM customers where customerNumber=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, customerNumber);
			ResultSet result = stmt.executeQuery();
			System.out.println("Entra");
			while (result.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public ArrayList<Payment> getPayments() {
		String sql = "Select * from payments";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			ResultSet result = stmt.executeQuery();
			ArrayList<Payment> listaPayments = new ArrayList<Payment>();
			while (result.next()) {
				int cusNumber = result.getInt("customerNumber");
				String checkNumber = result.getString("checkNumber");
				String payDate = result.getString("paymentDate");
				double amount = result.getDouble("amount");
				listaPayments.add(new Payment(cusNumber, checkNumber, payDate, amount));
			}
			return listaPayments;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
