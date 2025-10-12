package rent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rent.connection.ConnectionManager;
import rent.model.Dashboard;

public class DashboardDAO {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	;
		
	//insert booking
		public static Dashboard getDashboard() throws SQLException{
			
			Dashboard dashboard= new Dashboard();
			
		
					try {
			            // Call getConnection() method
			            con = ConnectionManager.getConnection();
			            
			            // Get count of admins
			            String sql = "SELECT COUNT(*) FROM admin";
			            ps = con.prepareStatement(sql);
			            rs = ps.executeQuery();
			            if (rs.next()) {
			                dashboard.setNoOfAdmins(rs.getInt(1)); // Using column index 1
			            }

			            // Get count of users
			            sql = "SELECT COUNT(*) FROM user";
			            ps = con.prepareStatement(sql);
			            rs = ps.executeQuery();
			            if (rs.next()) {
			                dashboard.setNoOfUsers(rs.getInt(1)); // Using column index 1
			            }

			            // Get count of bookings
			            sql = "SELECT COUNT(*) FROM booking";
			            ps = con.prepareStatement(sql);
			            rs = ps.executeQuery();
			            if (rs.next()) {
			                dashboard.setNoOfBookings(rs.getInt(1)); // Using column index 1
			            }
			            
			            // Get count of users
			            sql = "SELECT COUNT(*) FROM cars";
			            ps = con.prepareStatement(sql);
			            rs = ps.executeQuery();
			            if (rs.next()) {
			                dashboard.setNoOfCars(rs.getInt(1)); // Using column index 1
			            }

			            // Close connection
			            con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return dashboard;
		}
}	
	
	
