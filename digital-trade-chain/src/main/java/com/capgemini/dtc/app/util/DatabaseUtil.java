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
import java.util.HashMap;
import java.util.Map;

import com.capgemini.dtc.app.model.User;
import com.google.common.io.BaseEncoding;

public class DatabaseUtil {
	
	private static final String DB_IP = "localhost";	
	private static final String DB_USER_NAME = "sa";
	private static final String DB_PASSWORD = "";
	private static Map<String, String> nodeNameWithPortMap = new HashMap<String, String>();
	
	static{
		nodeNameWithPortMap.put("BankOfPune", "63000");
		nodeNameWithPortMap.put("BankOfHelsinki", "64000");
		nodeNameWithPortMap.put("BankOfAmsterdam", "65000");		
	}
	
	/**
	 H2 database port number is dynamic (generate random number) by default. To make it static, edit the 'node.conf' file
	 under '/build/nodes/BankOfCorda' by appending the following lines for each node::
	 ****************************************************************
	 dataSourceProperties = {
    		dataSourceClassName = org.h2.jdbcx.JdbcDataSource
    		"dataSource.url" = "jdbc:h2:file:"${basedir}"/persistence;DB_CLOSE_ON_EXIT=FALSE;LOCK_TIMEOUT=10000;WRITE_DELAY=0;AUTO_SERVER_PORT="${h2port}
    		"dataSource.user" = sa
    		"dataSource.password" = ""
	 }
	 useHTTPS = false
	 h2port = 63000
	 ***************************************************************
	 */
	private static Connection getDBConnection(String nodeName)
			throws SQLException {

		String connURL = "jdbc:h2:tcp://" + DB_IP + ":" + nodeNameWithPortMap.get(nodeName) + "/node";		
		Connection conn = DriverManager.getConnection(connURL, DB_USER_NAME, DB_PASSWORD);

		return conn;
	}

	public static boolean isDBUserTableExists(String nodeName) {
		boolean status = true;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = getDBConnection(nodeName);
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

	public static int createDBUserTable(String nodeName) {
		Connection conn = null;
		int result = 0;
		Statement statement = null;
		try {
			conn = getDBConnection(nodeName);
			String createTableSQL = "CREATE TABLE USER(DTC_ID varchar(255) primary key," + 
									"FIRST_NAME varchar(255), LAST_NAME varchar(255), USER_ID varchar(255)," + 
									"PASSWORD varchar(255), CONTACT_NUMBER varchar(255), EMAIL varchar(255), DOB varchar(255))";
			statement = conn.createStatement();
			result = statement.executeUpdate(createTableSQL);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null){
					conn.close();
				}
				if(statement != null){
					statement.close();
				}
			} catch (Exception e) {}
		}

		return result;

	}
	
	public static boolean validateLogin(String nodeName, String userName, String password) {

		Connection conn = null;
		boolean status = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getDBConnection(nodeName);
			ps = conn.prepareStatement("SELECT * FROM USER WHERE USER_ID=? AND PASSWORD=?");
			ps.setString(1, userName);
			ps.setString(2, getSHA256Hash(password));

			rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null){
					conn.close();
				}
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
	
	public static int createUser(String nodeName, User user){	
		Connection conn = null;
		PreparedStatement ps = null;		
		int result = 0;
		if (isDBUserTableExists(nodeName)) {
			createDBUserTable(nodeName);
			System.out.println("User DB table created successfully...............");
		}
		try {
			conn = getDBConnection(nodeName);
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
			
			System.out.println("User registration successful...............");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null){
					conn.close();
				}
				if(ps != null){
					ps.close();	
				}
			} catch (Exception e) {}
		}
		return result;
		
	}
	
	public static void displayUser(String nodeName, String userId) {

		Connection conn = null;
		try {
			conn = getDBConnection(nodeName);
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

			conn.close();
			rs1.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static User retriveUser(String nodeName, String userId) {

		Connection conn = null;
		User user = null;
		try {
			conn = getDBConnection(nodeName);
			// Create a Statement class to execute the SQL statement
			Statement stmt = conn.createStatement();

			// Execute the SQL statement and get the results in a Resultset
			ResultSet rs1 = stmt
					.executeQuery("SELECT * FROM USER WHERE USER_ID='" + userId
							+ "'");
			user = new User();
			while (rs1.next()){
				user.setDtcId(rs1.getString("DTC_ID"));
				user.setUserId(rs1.getString("USER_ID"));
				user.setFirstName(rs1.getString("FIRST_NAME"));
				user.setLastName(rs1.getString("LAST_NAME"));
				user.setEmail(rs1.getString("EMAIL"));
				user.setContactNumber(rs1.getString("CONTACT_NUMBER"));
			}				

			conn.close();
			rs1.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}
	
	public static void displayAllUsers(String nodeName) {

		Connection conn = null;
		try {
			conn = getDBConnection(nodeName);
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

			conn.close();
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

	
    //This is for testing purpose only
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		final String nodeName = "BankOfCorda";		
		
		if (isDBUserTableExists(nodeName)) {
			int result = createDBUserTable(nodeName);
			System.out.println("User DB table created = " + result);
		}
		
		/*User user1 = new User();		
		user1.setUserId("biksen");
		user1.setPassword("password");
		user1.setFirstName("Bikash");
		user1.setLastName("Sen");
		user1.setDateOfBirth(new Date());
		user1.setEmail("sen.bikash@gmail.com");
		user1.setContactNumber("7083042244");

		int result = createUser(nodeName,user1);
		System.out.println("Insert user result = " + result);*/
		
		boolean r = validateLogin(nodeName, "jiyasen", getSHA256Hash("password"));
		
		System.out.println("validate user login status = "+r);
		
		displayUser(nodeName, "biksen");
		displayAllUsers(nodeName);

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
