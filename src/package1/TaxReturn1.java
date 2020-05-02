package package1;

import java.util.*;

public class TaxReturn1{
	 // taxpayer fields
	 private String social_security_number;
	 private String last_name;
	 private String first_name;
	 private String address;
	 private String city;
	 private String state;
	 private String zip_code;
	 private double annual_income;
	 private String marital_status;
	 private double tax_liability;
	 
	 // annual income and percentages chart
	 private final double LOWINCOME = 20000;
	 private final double HIGHINCOME = 50000;
	 private final double SINGLELOW = 0.15;
	 private final double SINGLEMED = 0.22;
	 private final double SINGLEHIGH = 0.30;
	 private final double MARRIEDLOW = 0.14;
	 private final double MARRIEDMED = 0.20;
	 private final double MARRIEDHIGH = 0.28;
	
	 	/**
	 	 * Constructor calculates tax liability based off of annual income and percentages of marital status.
	 	 * @param ssn
	 	 * @param last_nm
	 	 * @param first_nm
	 	 * @param addr
	 	 * @param cty
	 	 * @param st
	 	 * @param zip
	 	 * @param income
	 	 * @param mar_st
	 	 */
		public TaxReturn1(String ssn, String last_nm, String first_nm, String addr, String cty, 
				 String st, String zip, double income, String mar_st){
		    //write code here 
			this.social_security_number = ssn;
			this.first_name = first_nm;
			this.last_name = last_nm;
			this.address = addr;
			this.city = cty;
			this.state = st;
			this.zip_code = zip;
			this.annual_income = income;
			this.marital_status = mar_st;  
		}
		
		public String setSSN(String ssn) {
			// Prompt the user to enter a Social Security number
			Scanner input = new Scanner(System.in);
	        boolean isValid = false;
			while(isValid == false) {
				System.out.print("Enter your SSN: ");
				ssn = input.nextLine();
				// Check whether the input is valid
				isValid = 
					(ssn.length() == 11) && 
					(Character.isDigit(ssn.charAt(0))) &&
					(Character.isDigit(ssn.charAt(1))) &&
					(Character.isDigit(ssn.charAt(2))) &&
					(ssn.charAt(3) == '-') &&
					(Character.isDigit(ssn.charAt(4))) &&
					(Character.isDigit(ssn.charAt(5))) &&
					(Character.isDigit(ssn.charAt(7))) &&
					(ssn.charAt(6) == '-') &&
					(Character.isDigit(ssn.charAt(8))) &&
					(Character.isDigit(ssn.charAt(9))) &&
					(Character.isDigit(ssn.charAt(10)));	
			}
			return ssn;
		}
		public String getSSN() {
			return social_security_number;
		}
		
		public String getFirstName(){
			return first_name;
		}
		public String setFirstName(String first_nm) {
			return this.first_name = first_nm;
		}
	
		public String getLastName() {
			return last_name;
		}
		public String setLastName(String last_nm) {
			return this.last_name = last_nm;
		}
	
		public String getAddress() {
			return address;
		}
		public String setAddress(String addr) {
			return this.address = addr;
		}
		
		public String getCity() {
			return city;
		}
		public String setCity(String cty) {
			return this.city = cty;
		}
		
		public String getState() {
			return state;
		}
		public String setState(String st) {
			return this.state = st;
		}
		
		public String getZip() {
			return zip_code;
		}
		public String setZip(String zip) {
			boolean isValid = false;
			// Prompt the user to enter a zip
	        while(isValid == false) {
	        	isValid = (zip.length() == 5) &&
	        			  (Character.isDigit(zip.charAt(0))) &&
	        			  (Character.isDigit(zip.charAt(1))) &&
	        			  (Character.isDigit(zip.charAt(2))) &&
	        			  (Character.isDigit(zip.charAt(3))) &&
	        			  (Character.isDigit(zip.charAt(4)));
	        	if(isValid == false) {
	            	System.out.print("Enter your zip code: ");
	            	Scanner input = new Scanner(System.in);
	            	zip = input.nextLine();
	        	}
	        }
	        return this.zip_code = zip;
		}
		
		public String getMaritalStatus() {
			return marital_status;
		}
		public String setMaritalStatus(String mar_st) {
			boolean isValid = false;    
	        isValid = false;
	        while(isValid == false) {
	        	isValid = (mar_st.length() == 1) &&
	        			  (mar_st.charAt(0) == 'M') ||
	        			  (mar_st.charAt(0) == 'm') ||
	        			  (mar_st.charAt(0) == 'S') ||
	        			  (mar_st.charAt(0) == 's');
	        	if(isValid == false) {
	            	System.out.print("Enter your marital status: ");
	        		Scanner input = new Scanner(System.in);
	            	mar_st = input.nextLine();
	        	}
	
	        }
	        return this.marital_status = mar_st;
		}
		
		public Double setAnnualIncome(Double income) {
			boolean isValid = false;        
		    isValid = false;
		    while(isValid == false) {
		    	isValid = (income >= 0);
		    	if(isValid == false) {
		    		System.out.print("Enter your income: ");
					Scanner input = new Scanner(System.in);
			    	income = input.nextDouble();
		    	}
		     }
		     return this.annual_income = income;
		}
		public Double getAnnualIncome() {
			return annual_income;
		}
		
		public Double setTaxReturn(Double income, String mar_st) {
			double tax = 0;
			if(mar_st.charAt(0) == 'M' || mar_st.charAt(0) == 'm') { //married
				if(income <= LOWINCOME) { // 15%
					tax = SINGLELOW*income;
				}
				if(income > LOWINCOME && income <= HIGHINCOME) { //22%
					tax = SINGLEMED*income;
				}
				if(income > HIGHINCOME) { //30%
					tax = SINGLEHIGH*income;
				}
			}
			if(mar_st.charAt(0) == 'S' || mar_st.charAt(0) == 's') { //single
				if(income <= LOWINCOME) { // 15%
					tax = MARRIEDLOW*income;
				}
				if(income > LOWINCOME && income <= HIGHINCOME) { //22%
					tax = MARRIEDMED*income;
				}
				if(income > HIGHINCOME) { //30%
					tax = MARRIEDHIGH*income;
				}
			}   
			return this.tax_liability = tax;
		}
		public Double getTaxReturn() {
			return tax_liability;
		}
		
		public void display(){
		     System.out.println("Taxpayer:");
		     System.out.println(getFirstName() + " " + getLastName());
		     System.out.println(getAddress());
		     System.out.println(getCity() + ", " + getState() + " " + getZip());
		     System.out.format("Income: $%.2f \nTax: $%.2f", annual_income, tax_liability);
		}
	}
	
