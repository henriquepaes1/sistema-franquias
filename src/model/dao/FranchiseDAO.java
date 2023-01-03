package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import db.DBException;
import model.entities.Franchise;

public class FranchiseDAO implements IDAO<Franchise> {
	private Connection conn;
	
	public FranchiseDAO(Connection conn) {
		this.conn = conn; 
	}
	

	@Override
	public int insert(Franchise franchise) {
		PreparedStatement query = null;
		int affectedRows = 0;
		try {
			query = conn.prepareStatement("INSERT INTO franchises (address, size, employeeQuantity, foundation)" + 
										"VALUES (?, ?, ?, ?) ");
			affectedRows = query.executeUpdate();
			
			query.setString(1, franchise.getAddress());
			query.setDouble(2, franchise.getSize());
			query.setInt(3, franchise.getEmployeeQuantity());
			query.setDate(4, franchise.getFoundation());
			
		} catch (SQLException e) {
			throw new DBException("Erro inexperado" + e.getMessage());
		}
		
		
		return affectedRows;
	}

	@Override
	public int update(Franchise obj) {
		
		return 0;
	}

	@Override
	public int deleteById(int id) {
		
		return 0;
	}

	@Override
	public List<Franchise> findById(int id) {
		
		return null;
	}

	@Override
	public List<Franchise> findAll() {
		
		return null;
	}

	

}
