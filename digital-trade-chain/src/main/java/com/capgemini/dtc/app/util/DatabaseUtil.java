package com.capgemini.dtc.app.util;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.capgemini.dtc.app.model.User;
import com.google.common.io.BaseEncoding;

public class DatabaseUtil {

	public static Connection getDBConnection(String ip, String port)
			throws SQLException {

		String connURL = "jdbc:h2:tcp://" + ip + ":" + port + "/node";
		String userName = "sa";
		String password = "";
		Connection conn = DriverManager.getConnection(connURL, userName,
				password);

		return conn;
	}

	public static boolean isDBUserTableExists(Connection conn) {
		boolean status = true;
		ResultSet rs = null;
		try {
			DatabaseMetaData dbmd = conn.getMetaData();
			String[] types = { "TABLE" };
			rs = dbmd.getTables(null, null, "%", types);
			while (rs.next()) {				
				if (rs.getString("TABLE_NAME").equalsIgnoreCase("USER")){
					status = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
		}
		return status;

	}

	public static int createDBUserTable(Connection conn) {

		int result = 0;
		Statement statement = null;
		try {
			String createTableSQL = "CREATE TABLE USER(DTC_ID varchar(255) primary key," + 
									"FIRST_NAME varchar(255), LAST_NAME varchar(255), USER_ID varchar(255)," + 
									"PASSWORD varchar(255), CONTACT_NUMBER varchar(255), EMAIL varchar(255), DOB varchar(255))";
			statement = conn.createStatement();
			result = statement.executeUpdate(createTableSQL);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e) {}
		}

		return result;

	}
	
	public static boolean validateLogin(Connection conn, String userName, String password) {

		boolean status = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			ps = conn.prepareStatement("SELECT * FROM USER WHERE USER_ID=? AND PASSWORD=?");
			ps.setString(1, userName);
			ps.setString(2, password);

			rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
			}
		}
		return status;

	}
	
	public static int createUser(Connection conn, User user){		
		PreparedStatement ps = null;		
		int result = 0;
		try {
			String insertTableSQL = "INSERT INTO USER"
					+ "(DTC_ID, FIRST_NAME, LAST_NAME, USER_ID, PASSWORD, CONTACT_NUMBER, EMAIL, DOB) VALUES"
					+ "(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(insertTableSQL);
			ps.setString(1, "DTC" + new Date().getTime());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getUserId());
			ps.setString(5, getSHA256Hash(user.getPassword()));
			ps.setString(6, user.getContactNumber());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getDateOfBirth().toString());

			result = ps.executeUpdate();			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();				
			} catch (Exception e) {}
		}
		return result;
		
	}
	
	public static void displayUser(Connection conn, String userId) {

		try {
			// Create a Statement class to execute the SQL statement
			Statement stmt = conn.createStatement();

			// Execute the SQL statement and get the results in a Resultset
			ResultSet rs1 = stmt
					.executeQuery("SELECT * FROM USER WHERE USER_ID='" + userId
							+ "'");
			while (rs1.next())
				System.out.println("DTC_ID= " + rs1.getString("DTC_ID")
						+ ", USER_ID= " + rs1.getString("USER_ID")
						+ ", PASSWORD= " + rs1.getString("PASSWORD")
						+ ", DOB= " + rs1.getString("DOB"));

			rs1.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void displayAllUsers(Connection conn) {

		try {
			// Create a Statement class to execute the SQL statement
			Statement stmt = conn.createStatement();

			// Execute the SQL statement and get the results in a Resultset
			ResultSet rs1 = stmt
					.executeQuery("SELECT * FROM USER");
			while (rs1.next())
				System.out.println("DTC_ID= " + rs1.getString("DTC_ID")
						+ ", USER_ID= " + rs1.getString("USER_ID")
						+ ", PASSWORD= " + rs1.getString("PASSWORD")
						+ ", DOB= " + rs1.getString("DOB"));

			rs1.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * Returns a hexadecimal encoded SHA-256 hash for the input String.
	 * 
	 * @param data
	 * 
	 * @return
	 */

	public static String getSHA256Hash(String password) {	

		String hex = "";
		try {

			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] bytes = digest.digest(password.getBytes("UTF-8"));
			
			hex = BaseEncoding.base16().lowerCase().encode(bytes);

			return hex; // make it printable

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return hex;

	}

	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn = getDBConnection("localhost", "55618");
		
		if (isDBUserTableExists(conn)) {
			int result = createDBUserTable(conn);
			System.out.println("User DB table created = " + result);
		}
		
		User user1 = new User();
		//user1.setDtcId("DTC" + new Date().getTime());
		user1.setUserId("biksen");
		user1.setPassword("password");
		user1.setFirstName("Bikash");
		user1.setLastName("Sen");
		user1.setDateOfBirth(new Date());
		user1.setEmail("sen.bikash@gmail.com");
		user1.setContactNumber("7083042244");

		int result = createUser(conn, user1);
		System.out.println("Insert user result = " + result);
		
		boolean r = validateLogin(conn, "biksen", getSHA256Hash("password"));
		
		System.out.println("validate user login status = "+r);
		
		displayUser(conn, "biksen");
		displayAllUsers(conn);

		/*Connection conn1 = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost:59552/node", "sa", "");

		System.out.println("Connection successfully created...." + conn1);

		DatabaseMetaData dbmd = conn1.getMetaData();
		String[] types = { "TABLE" };
		ResultSet rs = dbmd.getTables(null, null, "%", types);
		while (rs.next()) {
			System.out.println(rs.getString("TABLE_NAME"));
		}

		// Create a Statement class to execute the SQL statement
		Statement stmt = conn.createStatement();

		// Execute the SQL statement and get the results in a Resultset
		ResultSet rs1 = stmt.executeQuery("SELECT * FROM NODE_TRANSACTIONS");

		ResultSetMetaData rsmd = rs1.getMetaData();
		int columnCount = rsmd.getColumnCount();

		// The column count starts from 1
		for (int i = 1; i <= columnCount; i++) {
			String name = rsmd.getColumnName(i);
			System.out.println("Column[" + i + "]" + "=" + name);
		}

		while (rs1.next())
			System.out.println("KEY_HASH= " + rs1.getString(1) + ", SEQ_NO= "
					+ rs1.getString(2) + ", TX_ID= " + rs1.getString(3)
					+ ", TRANSACTION= " + rs1.getString(4));*/
		

	}

}
