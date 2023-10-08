package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.exception.DbException;
import model.exception.DbIntegrityException;
import model.services.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DB.getConnection();
			ps = conn.prepareStatement("" + "delete from department " + "where " + "(Id = ?)");

			ps.setInt(1, 2);

			int rownsAffected = ps.executeUpdate();

			System.out.println("Date! Rowns Affected: " + rownsAffected);

		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
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
