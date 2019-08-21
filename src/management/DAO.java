package management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import source.login;

public class DAO {
	//mysql database connection string
	private String jdbcURL = "jdbc:mysql://localhost:3306/stkdb?serverTimezone=CST";
	private String jdbcUsername = "root";
	private String jdbcPassword = "michelle";
	
	//select script
	private static final String SELECT_USER_BY_ID = "select id, emailaddress, password, number from login where id = ?";
	private static final String SELECT_ALL_USERS = "select id, emailaddress, password, number from login";
	private static final String SELECT_ACT_EXISTS = "select case when emailaddress is null then ' ' else emailaddress end as emailaddress from login where emailaddress = ?";
	private static final String SELECT_LOGIN_VERIFY = "select emailaddress, password from login where emailaddress = ? and password = ?";
	private static final String UPDATE_MEMBER_PASSWORD = "update stkdb.login set password = ? where emailaddress = ?";
	
	//insert script
	private static final String INSERT_MEMBER_SQL = "INSERT INTO login" + "(id, emailaddress, password, number) VALUES" + "(uuid(), ?, ?, ?)";
	
	public DAO() {
		
	}
	
	protected Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return c;
	}
	
	public void insertMember(login login) throws SQLException{
		System.out.println(INSERT_MEMBER_SQL);
		
		try(Connection c = getConnection();
			PreparedStatement preparedStatement = c.prepareStatement(INSERT_MEMBER_SQL)) {
			preparedStatement.setString(1, login.getEmailaddress());
			preparedStatement.setString(2, login.getPassword());
			preparedStatement.setString(3, login.getNumber());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			printSQLException(e);
		}
	}
	
	public login selectmember(String id) {
		login login = null;
		
		try(Connection c = getConnection();
			PreparedStatement preparedStatement = c.prepareStatement(SELECT_USER_BY_ID);){
			preparedStatement.setString(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String emailaddress = rs.getString("emailaddress");
				String password = rs.getString("password");
				String number = rs.getString("number");
				login = new login(id, emailaddress, password, number);
			}
		}
		catch(SQLException e) {
			printSQLException(e);
		}
		return login;
	}
	
	public login selectMemberExist(String emailaddress) {
		login login = null;
		
		try(Connection c = getConnection();
			PreparedStatement preparedStatement = c.prepareStatement(SELECT_ACT_EXISTS);){
			preparedStatement.setString(1, emailaddress);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String exist = rs.getString("emailaddress");
				login = new login(emailaddress, "", "", "");
			}
		}
		catch (SQLException e){
			printSQLException(e);
		}
		return login;
	}
	
	public login MemberLoginVerify(String emailaddress, String password) {
		login verify = null;
		
		try(Connection c = getConnection();
			PreparedStatement preparedStatement = c.prepareStatement(SELECT_LOGIN_VERIFY);){
			preparedStatement.setString(1, emailaddress);
			preparedStatement.setString(2, password);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				String act = "";
				String pwd = "";
				
				act = rs.getString("emailaddress");
				pwd = rs.getString("password");
				verify = new login("", act, pwd, "");
			}
			else {
				verify = new login("", "" ,"" ,"");
			}
		}
		catch(SQLException e) {
			printSQLException(e);
		}
		return verify;
	}
	
	public boolean updateMemberPassword(login login) throws SQLException{
		boolean rowUpdated;
		try (Connection c = getConnection();
			 PreparedStatement statement = c.prepareStatement(UPDATE_MEMBER_PASSWORD);){
			statement.setString(1, login.getPassword());
			statement.setString(2, login.getEmailaddress());
			
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public void printSQLException(SQLException ex) {
		for(Throwable e : ex) {
			if(e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState : " + ((SQLException) e).getSQLState());
				System.err.println("Error code :  : " + ((SQLException) e).getErrorCode());
				System.err.println("Message : " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("cause : " + t);
					t = t.getCause();
				}
			}
		}
	}
}
