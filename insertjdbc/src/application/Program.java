package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.exception.DbException;
import model.services.DB;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DB.getConnection();
			ps = conn.prepareStatement("insert into seller" + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
					+ "values " + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, "Joao Victor");
			ps.setString(2, "joao@gmail.com");
			ps.setDate(3, new Date(sdf.parse("16/03/2000").getTime()));
			ps.setDouble(4, 3000.0);
			ps.setInt(5, 4);

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id = " + id);
				}
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} catch (ParseException e) {
			throw new DbException(e.getMessage());
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				DB.closeConnection();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}

	}

}
