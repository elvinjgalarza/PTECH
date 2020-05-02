package package1;

import java.util.Scanner;

public class PrepareTax {
	public static void main(String[] args) {
		TaxReturn1 tr = new TaxReturn1(null, null, null, null, null, null, null, 0, null);
		// write your code here
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your first name: ");
		String fn = sc.nextLine();
		tr.setFirstName(fn);

		System.out.print("Enter your last name: ");;
		String ln = sc.nextLine();
		tr.setLastName(ln);

		System.out.print("Enter your address: ");
		String addr = sc.nextLine();
		tr.setAddress(addr);

		System.out.print("Enter your city: ");
		String cty = sc.nextLine();
		tr.setCity(cty);

		System.out.print("Enter your state: ");
		String st = sc.nextLine();
		tr.setState(st);
		
		System.out.print("Enter your zip code: ");
		String zip = sc.nextLine();
		tr.setZip(zip);

		System.out.print("Enter your SSN: ");
		String ssn = sc.nextLine();
		tr.setSSN(ssn);
		
		System.out.print("Enter your marital status (M: married, S: single): ");
		String mar_st = sc.nextLine();
		tr.setMaritalStatus(mar_st);
		
		System.out.print("Enter your annual income: ");
		Double income = sc.nextDouble();
		tr.setAnnualIncome(income);
		
		tr.setTaxReturn(income, mar_st);
		
		tr.display();
	}
}
