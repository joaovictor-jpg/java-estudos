package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import model.exception.DbException;
import model.services.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;

		try {

			conn = DB.getConnection();
			st = conn.createStatement();

			conn.setAutoCommit(false);

			int rows1 = st.executeUpdate("update seller set baseSalary = 2090.0 where DepartmentId = 1");

			int x = 3;
			if (x < 2) {
				throw new SQLException("Fake error");
			}

			int rows2 = st.executeUpdate("update seller set baseSalary = 3090.0 where DepartmentId = 2");

			conn.commit();

			System.out.println("rows1 = " + rows1);
			System.out.println("rows1 = " + rows2);

		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				DB.closeConnection();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}

	}

}
