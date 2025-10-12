package rent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rent.connection.ConnectionManager;
import rent.model.Bridge;
import rent.model.Car;

public class BridgeDAO {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private String sql;
		
	//get booking by id
public static Bridge   getCarsBookingDetailsById(int booking_id) {
	
	Bridge bridge = new Bridge ();
	
	//complete the code here
	try {
		//call getConnection() method
		con = ConnectionManager.getConnection();
		
		//3. create statement
		String sql = "SELECT b.booking_id,b.booking_date,b.pickup_location,b.drop_location,b.rr_id ,b.car_id,c.car_type,c.car_brand,c.car_model,c.car_color,c.no_of_seats,c.availability,c.price_per_day,c.rr_id ,c.car_plate FROM booking b JOIN cars c ON b.car_id = c.car_id WHERE booking_id=?;";
		ps = con.prepareStatement(sql);
		//set parameter values
		ps.setInt(1, booking_id);
		
		//4. execute query
		rs = ps.executeQuery();
		//process ResultSet and set the values to the Shawl object
		 if (rs.next()) {
                bridge = new Bridge ();
                // Populate DTO with ResultSet data
               // car_id,user_id
                bridge.setBooking_id(rs.getInt("booking_id"));
                bridge.setBooking_date(rs.getString("booking_date"));
                bridge.setPickup_location(rs.getString("pickup_location"));
                bridge.setDrop_location(rs.getString("drop_location"));
                bridge.setRr_id(rs.getInt("rr_id"));
                bridge.setCar_id(rs.getInt("car_id"));
                bridge.setCar_type(rs.getString("car_type"));
                bridge.setCar_brand(rs.getString("car_brand"));
                bridge.setCar_model(rs.getString("car_model"));
                bridge.setCar_color(rs.getString("car_color"));
                bridge.setNo_of_seats(rs.getInt("no_of_seats"));
                bridge.setAvailability(rs.getString("availability"));
                bridge.setPrice_per_day(rs.getDouble("price_per_day"));
                bridge.setCar_plate(rs.getString("car_plate"));
            }
		
		//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return bridge;
	}


public static List<Bridge> AllAdminUserBridge(){
	List<Bridge> bridges= new ArrayList<Bridge>();

	try {
		//call getConnection() method
		con = ConnectionManager.getConnection();
			
		//3. create statement
		stmt = con.createStatement();
		String sql = "SELECT a.admin_id, a.admin_address, a.admin_pNum, a.admin_title, a.admin_department, a.user_id, u.user_name, u.user_email, u.user_role FROM admin a INNER JOIN user u ON a.user_id = u.user_id;";
		
		//4. execute query
		rs = stmt.executeQuery(sql);
		//process ResultSet and set the values to the Car object
		while(rs.next()) {
			Bridge bridge = new Bridge ();
            // Populate DTO with ResultSet data
           // car_id,user_id
            bridge.setAdmin_id(rs.getInt("admin_id"));
            bridge.setAdmin_address(rs.getString("admin_address"));
            bridge.setAdmin_pNum(rs.getString("admin_pNum"));
            bridge.setAdmin_title(rs.getString("admin_title"));
            bridge.setAdmin_department("admin_department");
            bridge.setUser_id(rs.getInt("user_id"));
            bridge.setUser_name(rs.getString("user_name"));
            bridge.setUser_email(rs.getString("user_email"));
            bridge.setUser_role(rs.getString("user_role"));
			bridges.add(bridge);
		}
			
		//5. close connection
		con.close();
			
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	return bridges;
}

public static Bridge   AdminUserBridge(int admin_id) {
	
	Bridge bridge = new Bridge ();
	
	//complete the code here
	try {
		//call getConnection() method
		con = ConnectionManager.getConnection();
		
		//3. create statement
		String sql = "SELECT a.admin_id, a.admin_address, a.admin_pNum, a.admin_title, a.admin_department, a.user_id, u.user_name, u.user_email, u.user_role FROM admin a INNER JOIN user u ON a.user_id = u.user_id WHERE admin_id=?;";
		ps = con.prepareStatement(sql);
		//set parameter values
		ps.setInt(1, admin_id);
		
		//4. execute query
		rs = ps.executeQuery();
		//process ResultSet and set the values to the Shawl object
		 if (rs.next()) {
			  bridge = new Bridge ();
	            // Populate DTO with ResultSet data
	           // car_id,user_id
	            bridge.setAdmin_id(rs.getInt("admin_id"));
	            bridge.setAdmin_address(rs.getString("admin_address"));
	            bridge.setAdmin_pNum(rs.getString("admin_pNum"));
	            bridge.setAdmin_title(rs.getString("admin_title"));
	            bridge.setAdmin_department("admin_department");
	            bridge.setUser_id(rs.getInt("user_id"));
	            bridge.setUser_name(rs.getString("user_name"));
	            bridge.setUser_email(rs.getString("user_email"));
	            bridge.setUser_role(rs.getString("user_role"));
            }
		
		//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return bridge;
	}

public static Bridge getRRCarDetailsById(int car_id) {
	
	Bridge bridge = new Bridge ();
	
	//complete the code here
	try {
		//call getConnection() method
		con = ConnectionManager.getConnection();
		
		//3. create statement
		String sql = "SELECT r.rr_id,r.rr_address,r.rr_pNum, r.rr_license,r.rr_experience,c.car_id,c.car_type,c.car_brand,c.car_model,c.car_color,c.no_of_seats,c.availability,c.price_per_day,c.rr_id ,c.car_plate FROM renter_renting r JOIN cars c ON r.rr_id = c.rr_id WHERE car_id =?;";
		ps = con.prepareStatement(sql);
		//set parameter values
		ps.setInt(1, car_id);
		
		//4. execute query
		rs = ps.executeQuery();
		//process ResultSet and set the values to the Shawl object
		 if (rs.next()) {
                bridge = new Bridge ();
                // Populate DTO with ResultSet data
                // car_id,user_id
                bridge.setRr_id(rs.getInt("rr_id"));
                bridge.setRr_address(rs.getString("rr_address"));
                bridge.setRr_pNum(rs.getString("rr_pNUm"));
                bridge.setRr_license(rs.getString("rr_license"));
                bridge.setRr_experience(rs.getString("rr_experience"));
                bridge.setCar_id(rs.getInt("car_id"));
                bridge.setCar_type(rs.getString("car_type"));
                bridge.setCar_brand(rs.getString("car_brand"));
                bridge.setCar_model(rs.getString("car_model"));
                bridge.setCar_color(rs.getString("car_color"));
                bridge.setNo_of_seats(rs.getInt("no_of_seats"));
                bridge.setAvailability(rs.getString("availability"));
                bridge.setPrice_per_day(rs.getDouble("price_per_day"));
                bridge.setCar_plate(rs.getString("car_plate"));
            }
		
		//5. close connection
		con.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return bridge;
}

	
}