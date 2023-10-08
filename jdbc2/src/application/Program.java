package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.exception.DbException;
import model.services.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from department");

			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ": " + rs.getString("Name"));
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
