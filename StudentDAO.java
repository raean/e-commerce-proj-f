/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author franciso
 *
 */
public class StudentDAO {
	
	private List<StudentBean> students;
	
	private static final String DB_URL = "jdbc:derby://localhost:64413/EECS;user=student;password=secret";
//	public static final String DB_URL = "jdbc:derby://red.eecs.yorku.ca:64413/EECS;user=student;password=secret";
	
	public StudentDAO(String prefix, String minGPA, String sortBy) throws Exception {
		
		students = new ArrayList<StudentBean>();
		
		//--------------------------------------------------------//
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			Connection con = DriverManager.getConnection(DB_URL);	
			Statement s = con.createStatement();
			s.executeUpdate("set schema roumani");
		
						//SQL query to obtain the NAME and PRICE of an
						//item whose number is itemNo in a table ITEM
			String query; 
			
			if(minGPA.isEmpty()) {
				minGPA = "0.0";
			}
			Double.parseDouble(minGPA);
			System.out.println(sortBy);
			if(!sortBy.equals("NONE")) {
				System.out.println("Extra");
				query = "SELECT * FROM SIS"
						+ " WHERE UPPER(GIVENNAME) LIKE " + "'"+prefix.toUpperCase()+ "%'"       
						+ " AND"
						+ " GPA >= " + minGPA 
						+ " ORDER BY " + sortBy;
			}else {
				query = "SELECT * FROM SIS"
						+ " WHERE UPPER(GIVENNAME) LIKE " + "'"+prefix.toUpperCase()+ "%'"
						+ " AND"
						+ " GPA >= " + minGPA;
			}
			
			
			ResultSet r = s.executeQuery(query);
			
			while(r.next()) {// loop through

				
				String fn = r.getString("GIVENNAME"),
						ln = r.getString("SURNAME"),
						mjr = r.getString("MAJOR");
				int crs = Integer.parseInt(r.getString("COURSES"));
				double gpa = Double.parseDouble(r.getString("GPA"));
				
				students.add(new StudentBean(fn, ln, mjr, crs, gpa));
				
			}
			r.close(); s.close(); con.close();
			
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			throw new Exception("Could not initialize derby. Please try again later");
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
			throw new Exception("SQL was unable to extract that information. Please check your input");
		}
		catch(NumberFormatException nfe) {
			nfe.printStackTrace();
			throw new Exception("Please enter a number for Minimum GPA");
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("We're having difficulties right now. Please try again later");
		}
	}
	
	/**
	 * returns a list containing the bean
	 */
	public List<StudentBean> retrieve(){
			
		return students;
	}
	

}
