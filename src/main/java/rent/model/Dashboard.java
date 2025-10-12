package rent.model;

import java.io.Serializable;

/**
 * Author: FES
 */
public class Dashboard implements Serializable{
	private static final long serialVersionUID = 1L;
	int noOfAdmins,noOfCars,noOfBookings,noOfUsers;
	public Dashboard() {
	}
	public int getNoOfAdmins() {
		return noOfAdmins;
	}
	public void setNoOfAdmins(int noOfAdmins) {
		this.noOfAdmins = noOfAdmins;
	}
	public int getNoOfCars() {
		return noOfCars;
	}
	public void setNoOfCars(int noOfCars) {
		this.noOfCars = noOfCars;
	}
	public int getNoOfBookings() {
		return noOfBookings;
	}
	public void setNoOfBookings(int noOfBookings) {
		this.noOfBookings = noOfBookings;
	}
	public int getNoOfUsers() {
		return noOfUsers;
	}
	public void setNoOfUsers(int noOfUsers) {
		this.noOfUsers = noOfUsers;
	}

	
	
}