package com.persons.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.persons.bean.Person;

public class PersonDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/SeveltExampleDB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "roopa";

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
	public Person getPerson(int personID)
	{
		Person p=new Person();
		//
		//p.setPersonID(1);
		//p.setFirstName("Roopa");
		//p.setLastName("Sri");
		//p.setPersonID(personID);
		try
		{
			String sql="select * from PERSONS where PersonID=?";
			Connection conn=getConnection();
			//Statement s=conn.createStatement();
			PreparedStatement s=conn.prepareStatement(sql);

			//ResultSet rs=s.executeQuery(); 			/*ResultSet rs=s.executeQuery("select * from PERSON where PersonID="+personID);*/
            s.setInt(1, personID);
            System.out.println("Executing query: " + sql + " with personID: " + personID);
            try (ResultSet rs = s.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Record found in the database.");
                    p.setPersonID(rs.getInt("PersonID"));
                    p.setFirstName(rs.getString("FirstName"));
                    p.setLastName(rs.getString("LastName"));
                } else {
                    System.out.println("No record found for personID: " + personID);
                }
            }
		}
		catch (SQLException e) {
	        e.printStackTrace();
		}
		catch (Exception e) {
	        e.printStackTrace();
		}
		return p;
	}
	public void savePerson(int personID, String firstName,String lastName) throws ClassNotFoundException, SQLException
	{
		//Person p=new Person();
		String sql="insert into persons values (?,?,?)";
        try (Connection conn = getConnection();
                PreparedStatement s = conn.prepareStatement(sql)) {

               s.setInt(1, personID);
               s.setString(2, firstName);
               s.setString(3, lastName);

               int insert = s.executeUpdate();
               if (insert > 0) {
                   // Set the properties of the Person object if needed
                   //p.setPersonID(personID);
                   //p.setFirstName(firstName);
                   //p.setLastName(lastName);
            	   System.out.print("Successful Insert");
               } else {
                   // Handle the case where the insert operation failed
                   throw new SQLException("Failed to insert person");
               }
        }
		
	}
	
}

