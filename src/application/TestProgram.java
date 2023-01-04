package application;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.DBManager;
import model.dao.FranchiseDAO;
import model.entities.Franchise;

public class TestProgram {

	public static void main(String[] args) {
		FranchiseDAO franchiseDAO = new FranchiseDAO(DBManager.getConnection());
		Date test01 = Date.valueOf(LocalDate.parse("2021-08-13"));
		Date updateTest = Date.valueOf(LocalDate.parse("2012-10-08"));
		
		Franchise franchise = new Franchise(0, "Rua Giovanni Carnovali, 92", 108.43, 2, test01);
		Franchise updateFranchise = new Franchise(1, "Rua Paulo Prado, 132", 125.00, 4, updateTest);
		
		List<Franchise> allList = new ArrayList<>();
		List<Franchise> filteredList = new ArrayList<>();
		int testID = 1;
		
		// FRANCHISE TEST
		
//		// Test 1 - Inserting into database
//		franchiseDAO.insert(franchise);
//		
//		// Test 2 - Update franchise
//		franchiseDAO.update(updateFranchise);
		
		// Test 3 - List all franchises
		allList = franchiseDAO.findAll();
		
		System.out.println("All databases rows: ");
		for(Franchise item: allList) {
			System.out.println(item.toString());
		}
		System.out.println();
		
		filteredList = franchiseDAO.findById(testID);
		System.out.println("Databases rows with id = " + testID);
		for(Franchise item: filteredList) {
			System.out.println(item.toString());
		}
		System.out.println();

	}

}
