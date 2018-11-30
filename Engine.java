package model;

import java.math.BigInteger;
import java.util.List;

import com.google.gson.Gson;

public class Engine {
	
	private static Engine instance = null;
	
	private Engine() {
		//should not be instantiated by an outsider
	}
	
	
	/**
	 * @return singleton instance of Engine
	 */
	public synchronized static Engine getInstance() {
		
		if(instance == null) {
			instance = new Engine();
		}
		
		return instance;
	}
	
	
	/**
	 * given min and max computes the next smallest prime number in this
	 * range if any.
	 */
	public String doPrime(String min, String max)throws Exception {
		
		String result = "";
		
		
		try {
			int l = Integer.parseInt(min);
			int r = Integer.parseInt(max);
			
			if (l < 1 || r < 1) {
				throw new Exception("input must be a positive integer");
			}
			
			BigInteger bI = new BigInteger("" + l).nextProbablePrime();
			
			if(bI.intValueExact() > r) { // ERROR
				throw new Exception("No more primes in range");
			}
			
			result = "{\"status\":true, \"data\":\"" + bI.toString() + "\"}";
			
		}
		catch(NumberFormatException nfe) {
//			nfe.printStackTrace();
			result = "{\"status\":false, \"data\":\"incorrect format\"}";
			
		}
		catch(Exception e) {
//			e.printStackTrace();
			result = "{\"status\":false, \"data\":\"" + e.getMessage() + "\"}";
			
		}
		
		return result;
	}
	
	
	/**
	 * given a name prefix, minimum GPA and a category to sort by, returns a JSON
	 * string with all the students that meet the specified parameters
	 */
	public String doSis(String prefix, String minGPA, String sortBy)throws Exception{
		String result = "";
		String prfx =rmvTroubleMaker(prefix),
				mngp = rmvTroubleMaker(minGPA),
				srtby = rmvTroubleMaker(sortBy);
		
		try {
			if(prfx.equals("undefined")) {
				prfx = "";
			}

			if(mngp.equals("undefined")) {
				mngp = "";
			}
			if(srtby.equals("undefined")) {
				srtby = "SURNAME";
			}
			StudentDAO dao = new StudentDAO(prfx, mngp, srtby);
			List<StudentBean> beans  = dao.retrieve();
			System.out.println(beans.get(0).getFirstName());
			Table src = new Table(beans);
			Gson json = new Gson();
			result = json.toJson(src);
		}
		catch(Exception e) {
//			e.printStackTrace();
			result = "{\"status\":false, \"data\":\"" + e.getMessage() + "\"}";
		}
		
		
		return result;
	}
	
	
	
	
	//------------------Helpers below-------------------//
	

	private String rmvTroubleMaker(String input) {
			
		return input.replace(";", "").replace("\"", "").replace("+", "").replace("=","").trim();
	}

}
