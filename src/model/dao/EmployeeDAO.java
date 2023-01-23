package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DBException;
import db.DBManager;
import model.entities.Employee;

public class EmployeeDAO implements IDAO<Employee> {

	private Connection conn;

	public EmployeeDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Employee obj) {
		PreparedStatement query = null;
		try {
			query = conn
					.prepareStatement("INSERT INTO franchises (name, startDate, email, department, wage, franchise_id) "
							+ "VALUES (?, ?, ?, ?, ?, ?);");
			query.setString(1, obj.getName());
			query.setDate(2, obj.getStartDate());
			query.setString(3, obj.getEmail());
			query.setString(4, obj.getDepartment());
			query.setDouble(5, obj.getWage());
			query.setInt(6, obj.getFranchise().getId());

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DBManager.closeStatement(query);
		}

	}

	@Override
	public void update(Employee obj) {
		PreparedStatement query = null;

		try {
			query = conn.prepareStatement("UPDATE employees "
					+ "SET name = ?, startDate = ?, email = ?, department = ?, wage = ?, franchise_id = ? " + 
					"WHERE id = ?;",
					Statement.RETURN_GENERATED_KEYS);

			query.setString(1, obj.getName());
			query.setDate(2, obj.getStartDate());
			query.setString(3, obj.getEmail());
			query.setString(4, obj.getDepartment());
			query.setDouble(5, obj.getWage());
			query.setInt(6, obj.getFranchise().getId());
			query.setInt(7, obj.getId());

			query.executeUpdate();
			System.out.println("Update query succesfully executed.");

		} catch (SQLException e) {
			throw new DBException("Unexpected error: " + e.getMessage());
		} finally {
			DBManager.closeStatement(query);
		}

	}

	@Override
	public void deleteById(int id) {
		PreparedStatement query = null;
		try {
			query = conn.prepareStatement("DELETE FROM employees WHERE ID = ?;");
			query.setInt(1, id);
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DBManager.closeStatement(query);
		}

	}

	@Override
	public List<Employee> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
