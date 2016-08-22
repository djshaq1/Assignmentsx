package ssa;

public class Account {
	int accountId;
	String description;
	double balance;
	
	void getDetails() { //method for all account info
		 System.out.printf(description + "  id is "+ accountId + " and my balance is  %.2f ", + balance); 
		 System.out.println(" ");
	}
	void deposit (double addMoney) { 
		balance = balance + addMoney;
		System.out.printf(" I made a deposit in the amount of %.2f ", addMoney);
		
	}
	void withdraw (double takemoney) {
		if (takemoney < balance) {
			balance = balance - takemoney;
		System.out.printf(" I made a withdrawal in the amount of %.2f ", takemoney);
		}
		else System.out.println("Insufficient funds. Do Not withdraw!");
		
	}
	

		
		
}
