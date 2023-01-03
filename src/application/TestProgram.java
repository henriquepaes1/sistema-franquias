package application;

import java.sql.Date;
import java.time.LocalDate;

import db.DBManager;
import model.dao.FranchiseDAO;
import model.entities.Franchise;

public class TestProgram {

	public static void main(String[] args) {
		FranchiseDAO franchiseDAO = new FranchiseDAO(DBManager.getConnection());
		Date test01 = new Date(LocalDate.parse("2021-08-13").toEpochDay());
		
		Franchise franchise = new Franchise(0, "Rua Giovanni Carnovali, 92", 108.43, 2, test01);
		// Test 1 - Inserting into franchise database
		System.out.println(franchiseDAO.insert(franchise));

	}

}
