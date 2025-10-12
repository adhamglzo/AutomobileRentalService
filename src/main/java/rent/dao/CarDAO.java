package rent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rent.connection.ConnectionManager;
import rent.model.Car;


public class CarDAO {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private int car_id, no_of_seats,rr_id;
	private double price_per_day;
	private String car_type, car_brand, car_model, car_color, availability, car_plate;
	private String sql;
		
	
	//insert car
		public static void addCar(Car car) throws SQLException{
			
			//complete the code here
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement
				String sql = "INSERT INTO cars(car_type,car_brand,car_model,car_color,no_of_seats,availability,price_per_day,user_id,car_plate)VALUES(?,?,?,?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				//get values from Shawl object and set parameter values
				ps.setString(1, car.getCar_type());
				ps.setString(2, car.getCar_brand());
				ps.setString(3, car.getCar_model());
				ps.setString(4, car.getCar_color());
				ps.setInt(5, car.getNo_of_seats());
				ps.setString(6, car.getAvailability());
				ps.setDouble(7, car.getPrice_per_day());
				ps.setInt(8, car.getRr_id());
				ps.setString(9, car.getCar_plate());
				
				//4. execute query
				ps.executeUpdate();
				
				//5. close connection
				con.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		//update car
		public static void updateCar(Car car) throws SQLException{
			//complete the code here
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement and get the values from Shawl object
				String sql = "UPDATE cars SET car_type=?,car_brand=?,car_model=?,car_color=?,no_of_seats=?,availability=?,price_per_day=?,car_plate=? WHERE car_id=?";
				ps = con.prepareStatement(sql);
				//get values from Shawl object and set parameter values
				ps.setString(1, car.getCar_type());
				ps.setString(2, car.getCar_brand());
				ps.setString(3, car.getCar_model());
				ps.setString(4, car.getCar_color());
				ps.setInt(5, car.getNo_of_seats());
				ps.setString(6, car.getAvailability());
				ps.setDouble(7,car.getPrice_per_day());
				ps.setString(8, car.getCar_plate());
				ps.setInt(9,car.getCar_id());
				
				
				//4. execute query
				ps.executeUpdate();
				
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//delete car
		public static void deleteCar(int car_id) throws SQLException{
			//complete the code here
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement
				String sql = "DELETE FROM cars WHERE car_id=?";
				ps = con.prepareStatement(sql);
				//set parameter values
				ps.setInt(1, car_id);
				
				//4. execute query
				ps.executeUpdate();
				
				//5. close connection
				con.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		//get car by id
		public static Car getCar(int car_id) {
			
			Car car= new Car();
			
			//complete the code here
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement
				String sql = "SELECT * FROM cars WHERE car_id=?";
				ps = con.prepareStatement(sql);
				//set parameter values
				ps.setInt(1, car_id);
				
				//4. execute query
				rs = ps.executeQuery();
				//process ResultSet and set the values to the Shawl object
				if(rs.next()) {
					car.setCar_id(rs.getInt("car_id"));
					car.setCar_type(rs.getString("car_type"));
					car.setCar_brand(rs.getString("car_brand"));
					car.setCar_model(rs.getString("car_model"));
					car.setCar_color(rs.getString("car_color"));
					car.setNo_of_seats(rs.getInt("no_of_seats"));
					car.setAvailability(rs.getString("availability"));
					car.setPrice_per_day(rs.getDouble("price_per_day"));
					car.setRr_id(rs.getInt("user_id"));
					car.setCar_plate(rs.getString("car_plate"));
					
				}
				
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return car;
		}
		
	//get all cars
	public static List<Car> getAllCars(){
		List<Car> cars = new ArrayList<Car>();

		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
				
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM cars";
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getInt("car_id"));
				car.setCar_type(rs.getString("car_type"));
				car.setCar_brand(rs.getString("car_brand"));
				car.setCar_model(rs.getString("car_model"));
				car.setCar_color(rs.getString("car_color"));
				car.setNo_of_seats(rs.getInt("no_of_seats"));
				car.setAvailability(rs.getString("availability"));
				car.setPrice_per_day(rs.getDouble("price_per_day"));
				car.setRr_id(rs.getInt("user_id"));
				car.setCar_plate(rs.getString("car_plate"));
				cars.add(car);
			}
				
			//5. close connection
			con.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return cars;
	}
	
	//get all bezza 
	public static List<Car> getAllBezza(){
		List<Car> cars = new ArrayList<Car>();

		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM cars WHERE car_model = 'Bezza'";
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getInt("car_id"));
				car.setCar_type(rs.getString("car_type"));
				car.setCar_brand(rs.getString("car_brand"));
				car.setCar_model(rs.getString("car_model"));
				car.setCar_color(rs.getString("car_color"));
				car.setNo_of_seats(rs.getInt("no_of_seats"));
				car.setAvailability(rs.getString("availability"));
				car.setPrice_per_day(rs.getDouble("price_per_day"));
				cars.add(car);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cars;
	}
	
	//get all Myvi
	public static List<Car> getAllMyvi(){
		List<Car> cars = new ArrayList<Car>();

		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM cars WHERE car_model = 'Myvi'";
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getInt("car_id"));
				car.setCar_type(rs.getString("car_type"));
				car.setCar_brand(rs.getString("car_brand"));
				car.setCar_model(rs.getString("car_model"));
				car.setCar_color(rs.getString("car_color"));
				car.setNo_of_seats(rs.getInt("no_of_seats"));
				car.setAvailability(rs.getString("availability"));
				car.setPrice_per_day(rs.getDouble("price_per_day"));
				cars.add(car);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cars;
	} 
	
	// get all Axia
	public static List<Car> getAllAxia(){
		List<Car> cars = new ArrayList<Car>();

		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM cars WHERE car_model = 'Axia'";
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getInt("car_id"));
				car.setCar_type(rs.getString("car_type"));
				car.setCar_brand(rs.getString("car_brand"));
				car.setCar_model(rs.getString("car_model"));
				car.setCar_color(rs.getString("car_color"));
				car.setNo_of_seats(rs.getInt("no_of_seats"));
				car.setAvailability(rs.getString("availability"));
				car.setPrice_per_day(rs.getDouble("price_per_day"));
				cars.add(car);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cars;
	}
	
	// get all kancil
	public static List<Car> getAllKancil(){
		List<Car> cars = new ArrayList<Car>();

		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM cars WHERE car_model = 'Kancil'";
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getInt("car_id"));
				car.setCar_type(rs.getString("car_type"));
				car.setCar_brand(rs.getString("car_brand"));
				car.setCar_model(rs.getString("car_model"));
				car.setCar_color(rs.getString("car_color"));
				car.setNo_of_seats(rs.getInt("no_of_seats"));
				car.setAvailability(rs.getString("availability"));
				car.setPrice_per_day(rs.getDouble("price_per_day"));
				cars.add(car);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cars;
	}
	
	//get all persona
	public static List<Car> getAllPersona(){
		List<Car> cars = new ArrayList<Car>();

		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM cars WHERE car_model = 'Persona'";
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			//process ResultSet and set the values to the car object
			while(rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getInt("car_id"));
				car.setCar_type(rs.getString("car_type"));
				car.setCar_brand(rs.getString("car_brand"));
				car.setCar_model(rs.getString("car_model"));
				car.setCar_color(rs.getString("car_color"));
				car.setNo_of_seats(rs.getInt("no_of_seats"));
				car.setAvailability(rs.getString("availability"));
				car.setPrice_per_day(rs.getDouble("price_per_day"));
				cars.add(car);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cars;
	}
	
	//get all wira
	public static List<Car> getAllWira(){
		List<Car> cars = new ArrayList<Car>();

		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM cars WHERE car_model = 'Wira'";
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getInt("car_id"));
				car.setCar_type(rs.getString("car_type"));
				car.setCar_brand(rs.getString("car_brand"));
				car.setCar_model(rs.getString("car_model"));
				car.setCar_color(rs.getString("car_color"));
				car.setNo_of_seats(rs.getInt("no_of_seats"));
				car.setAvailability(rs.getString("availability"));
				car.setPrice_per_day(rs.getDouble("price_per_day"));
				cars.add(car);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cars;
	}
	
		
}