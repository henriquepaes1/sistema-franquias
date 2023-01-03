package model.dao;

import java.sql.Connection;
import java.util.List;

import model.entities.Employee;

public class EmployeeDAO implements IDAO<Employee> {
	
	private Connection conn;

	public EmployeeDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int insert(Employee obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Employee obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
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
