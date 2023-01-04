package model.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Franchise implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String address;
	private double size;
	private int employeeQuantity;
	private Date foundation;

	public Franchise() {
		
	}

	public Franchise(int id, String address, double size, int employeeQuantity, Date foundation) {
		this.id = id;
		this.address = address;
		this.size = size;
		this.employeeQuantity = employeeQuantity;
		this.foundation = foundation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public int getEmployeeQuantity() {
		return employeeQuantity;
	}

	public void setEmployeeQuantity(int employeeQuantity) {
		this.employeeQuantity = employeeQuantity;
	}

	public Date getFoundation() {
		return foundation;
	}

	public void setFoundation(Date foundation) {
		this.foundation = foundation;
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
		Franchise other = (Franchise) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Franchise [id=" + id + ", address=" + address + ", size=" + size + ", employeeQuantity="
				+ employeeQuantity + ", foundation=" + foundation + "]";
	}

}
