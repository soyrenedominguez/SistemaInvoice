package sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataInvoice {
	Connection cx = null;

	public Connection conectar() {
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost/grupo603", "root", "");
			System.out.println("like");
		} catch (SQLException e) {
		}
		return cx;
	}

	public static void main(String[] cecyto) {
		DataInvoice di = new DataInvoice();
		di.conectar();
	}

	public boolean cargarInvoice(Invoice i) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conectar().prepareStatement("SELECT * FROM invoice WHERE invoice_id=?");
			ps.setInt(1, i.getInvoiceId());
			rs = ps.executeQuery();
			if (rs.next()) {
				i.setInvoiceId(rs.getInt(1));
				i.setNumber(rs.getString(2));
				i.setCustomerName(rs.getString(3));
				i.setIssueDate(rs.getString(4));
				i.setTotalAmount(rs.getString(5));
				i.setPaid(rs.getString(6));
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

}
