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
	public void insert(Employee obj) {
		
	}

	@Override
	public void update(Employee obj) {
		
	}

	@Override
	public void deleteById(int id) {
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
