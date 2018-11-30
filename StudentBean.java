/**
 * 
 */
package model;


/**
 * @author franciso
 *
 */
/**
 * @author user
 *
 */
/**
 * @author user
 *
 */
public class StudentBean
{
	private String first_name;
	private String last_name;
	private String major;
	
	private int courses;
	private double gpa;
	
	/**
	 * Default constructor
	 */
	public StudentBean(){
		this("","","",0,0.0);
		
	}
	
	/**
	 * Constructor
	 * 
	 * @param name
	 * @param major
	 * @param courses
	 * @param gpa
	 */
	public StudentBean(String first_name, String last_name, String major, int courses, double gpa){
		this.first_name = first_name;
		this.last_name = last_name;
		this.major = major;
		this.courses = courses;
		this.gpa = gpa;
		
	}
	
	
	/**
	 * @return the first name of the student
	 */
	public String getFirstName() {
		
		return this.first_name;
	}
	
	/**
	 * @param name to be changed to
	 */
	public void setFirstName(String first_name) {
		
		this.first_name = first_name;
	}
	
	/**
	 * @return the last name of the student
	 */
	public String getLastName() {
		
		return this.last_name;
	}
	
	/**
	 * @param name to be changed to
	 */
	public void setLastName(String last_name) {
		
		this.last_name = last_name;
	}
	
	//---------------------------------------//
	
	/**
	 * @return the major of the student
	 */
	public String getMajor() {
		
		return this.major;
	}
	
    /**
     * @param major to be changed to
     */
    public void setMajor(String major) {
		
		this.major = major;
	}
	
    //----------------------------------------//
    
	/**
	 * @return the number of courses the student is enrolled in
	 */
	public int getCourses() {
			
		return this.courses;
	}
	
	/**
	 * @param courses to be changed to. may be less or more than old.
	 */
	public void setCourses(int courses) {
		
		this.courses = courses;
	}
	
	//---------------------------------------//
	
	/**
	 * @return the GPA of the student
	 */
	public double getGpa() {
		
		return this.gpa;
	}
		
	
	/**
	 * @param gpa to be set to. may be lower or higher than old.
	 */
	public void setGpa(double gpa) {
		
		this.gpa = gpa;
	}
	
	//----------------------------------------//
	
}
