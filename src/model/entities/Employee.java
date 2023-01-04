package model.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private Date startDate;
	private String email;
	private String department;
	private double wage;
	private Franchise franchise;

	public Employee() {
		
	}

	public Employee(int id, String name, Date startDate, String email, String department, double wage,
			Franchise franchise) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.email = email;
		this.department = department;
		this.wage = wage;
		this.franchise = franchise;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public Franchise getFranchise() {
		return franchise;
	}

	public void setFranchise(Franchise franchise) {
		this.franchise = franchise;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", startDate=" + startDate + ", email=" + email
				+ ", department=" + department + ", wage=" + wage + "]";
	}

	
	

}
