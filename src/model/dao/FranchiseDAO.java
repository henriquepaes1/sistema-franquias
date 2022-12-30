package model.dao;

import java.sql.Connection;
import java.util.List;

public class FranchiseDAO<Franchise> implements IDAO<Franchise> {
	private Connection conn;
	
	

	@Override
	public int insert(Franchise obj) {
		
		return 0;
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
