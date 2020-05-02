package package1;

import java.util.*;

//constructor 
public class TaxReturn{
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
	public TaxReturn(String ssn, String last_nm, String first_nm, String addr, String cty, 
			 String st, String zip, double income, String mar_st){
	     	//write code here 
		double tax = 0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your first name: ");
		first_nm = input.nextLine();
		
		System.out.print("Enter your last name: ");
		last_nm = input.nextLine();
		
		System.out.print("Enter your address: ");
		addr = input.nextLine();
		
		System.out.print("Enter your city: ");
		cty = input.nextLine();
		
		System.out.print("Enter your state: ");
		st = input.nextLine();
		
		boolean isValid = false;

		// Prompt the user to enter a zip
        while(isValid == false) {
        	System.out.print("Enter your zip code: ");
        	zip = input.nextLine();
        	isValid = (zip.length() == 5) &&
        			  (Character.isDigit(zip.charAt(0))) &&
        			  (Character.isDigit(zip.charAt(1))) &&
        			  (Character.isDigit(zip.charAt(2))) &&
        			  (Character.isDigit(zip.charAt(3))) &&
        			  (Character.isDigit(zip.charAt(4)));
        }
			
		// Prompt the user to enter a Social Security number
        isValid = false;
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
			
	        
        isValid = false;
        while(isValid == false) {
        	System.out.print("Enter your marital status: ");
        	mar_st = input.nextLine();
        	isValid = (mar_st.length() == 1) &&
        			  (mar_st.charAt(0) == 'M') ||
        			  (mar_st.charAt(0) == 'm') ||
        			  (mar_st.charAt(0) == 'S') ||
        			  (mar_st.charAt(0) == 's');

        }
	        
	     isValid = false;
	     while(isValid == false) {
	    	 System.out.print("Enter your income: ");
	    	 income = input.nextDouble();
	    	 isValid = (income >= 0);
	     }
	 
	     
	     
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
		
		this.social_security_number = ssn;
		this.first_name = first_nm;
		this.last_name = last_nm;
		this.address = addr;
		this.city = cty;
		this.state = st;
		this.zip_code = zip;
		this.annual_income = income;
		this.marital_status = mar_st;
		this.tax_liability = tax;
	     
	}
 

	public void display(){
	     System.out.print("Taxpayer:\n" + social_security_number + "\n" 
	     + first_name + " " + last_name + "\n" + address + "\n" + city + ", " 
	     + state + " " + zip_code + "\nMarital Status: " + marital_status
	     + "\n");
	     System.out.format("Income: $%.2f \nTax: $%.2f", annual_income, tax_liability);
	}
}

