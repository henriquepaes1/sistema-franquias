package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBException;
import db.DBManager;
import model.entities.Franchise;

public class FranchiseDAO implements IDAO<Franchise> {
	private Connection conn;
	
	public FranchiseDAO(Connection conn) {
		this.conn = conn; 
	}

	@Override
	public void insert(Franchise franchise) {
		
		PreparedStatement query = null;
		try {
			query = conn.prepareStatement("INSERT INTO franchises (address, size, employeeQuantity, foundation) " + 
										"VALUES (?, ?, ?, ?);");
			
			query.setString(1, franchise.getAddress());
			query.setDouble(2, franchise.getSize());
			query.setInt(3, franchise.getEmployeeQuantity());
			query.setDate(4, franchise.getFoundation());
			
			query.executeUpdate();
			System.out.println("Insert query succesfully executed.");
			
		} catch (SQLException e) {
			throw new DBException("Unexpected error: " + e.getMessage());
		}
		finally {
			DBManager.closeStatement(query);
		}
	}

	@Override
	public void update(Franchise franchise) {
		
		PreparedStatement query = null;		
		
		try {
			query = conn.prepareStatement("UPDATE franchises " + 
										  "SET address = ?, size = ?, employeeQuantity = ?, foundation = ? " + 
										  "WHERE id = ?;",
										  Statement.RETURN_GENERATED_KEYS);
			
			query.setString(1, franchise.getAddress());
			query.setDouble(2, franchise.getSize());
			query.setInt(3, franchise.getEmployeeQuantity());
			query.setDate(4, franchise.getFoundation());
			query.setInt(5, franchise.getId());
			
			query.executeUpdate();
			System.out.println("Update query succesfully executed.");
			
		} catch (SQLException e) {
			throw new DBException("Unexpected error: " + e.getMessage());
		}
		finally {
			DBManager.closeStatement(query);
		}

	}

	@Override
	public void deleteById(int id) {
		PreparedStatement query = null;
		
		try {
			query = conn.prepareStatement("DELETE FROM franchises WHERE id = ?");
			query.setInt(1, id);
			System.out.println("Delete query succesfully executed.");
		} catch (SQLException e) {
			throw new DBException("Unexpected error: " + e.getMessage());
		}
		finally {
			DBManager.closeStatement(query);
		}
		
	}

	@Override
	public List<Franchise> findById(int id) {
		ResultSet queryResult = null;
		PreparedStatement query = null;
		List<Franchise> list = new ArrayList<>();
		
		try {
			query = conn.prepareStatement("SELECT * FROM franchises WHERE id = ?");
			query.setInt(1, id);
			queryResult = query.executeQuery();
			
			while(queryResult.next()) {
				Franchise queryResultRow = new Franchise();
				queryResultRow.setId(queryResult.getInt("id"));
				queryResultRow.setAddress(queryResult.getString("address"));
				queryResultRow.setEmployeeQuantity(queryResult.getInt("employeeQuantity"));
				queryResultRow.setSize(queryResult.getDouble("size"));
				queryResultRow.setFoundation(queryResult.getDate("foundation"));
				list.add(queryResultRow);
			}
			
			return list;
			
		} catch (SQLException e) {
			throw new DBException("Unexpected error: " + e.getMessage());
		}
		finally {
			DBManager.closeResultSet(queryResult);
			DBManager.closeStatement(query);
		}
		
	}

	@Override
	public List<Franchise> findAll() {
		ResultSet queryResult = null;
		PreparedStatement query = null;
		List<Franchise> list = new ArrayList<>();
		
		try {
			query = conn.prepareStatement("SELECT * FROM franchises;");
			queryResult = query.executeQuery();
			
			while(queryResult.next()) {
				Franchise queryResultRow = new Franchise();
				queryResultRow.setId(queryResult.getInt("id"));
				queryResultRow.setAddress(queryResult.getString("address"));
				queryResultRow.setEmployeeQuantity(queryResult.getInt("employeeQuantity"));
				queryResultRow.setSize(queryResult.getDouble("size"));
				queryResultRow.setFoundation(queryResult.getDate("foundation"));
				list.add(queryResultRow);
			}
			
			return list;
			
		} catch (SQLException e) {
			throw new DBException("Unexpected error: " + e.getMessage());
		}
		finally {
			DBManager.closeResultSet(queryResult);
			DBManager.closeStatement(query);
		}
	}
}
