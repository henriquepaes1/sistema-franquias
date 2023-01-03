package services;

import java.sql.Connection;

import model.dao.EmployeeDAO;
import model.dao.FranchiseDAO;
import model.entities.Employee;

public class DAOFactory{

	public static EmployeeDAO createEmployeeDAO(Connection conn) {
		return new EmployeeDAO(conn);
	}
	
	public static FranchiseDAO createFranchiseDAO(Connection conn){
		return new FranchiseDAO(conn);
	}


}
