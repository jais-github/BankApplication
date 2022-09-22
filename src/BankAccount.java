import java.text.NumberFormat;
import java.util.Scanner;

public class BankAccount {
	private NumberFormat fmt = NumberFormat.getCurrencyInstance();
    private final double RATE = 0.035;
	public double Balance;
	public double previousTransaction;
	public String customerName;
	public String customerId;
	public double amount;
	
	BankAccount(String cname, String cId, double cBalance ){
		customerName = cname;
		customerId = cId;
		Balance = cBalance;
	}
	
	//default constructor
	public BankAccount() {
		Balance = 0.0;
		amount =0.0;
	}
	
	 public double getBalance() {
			return Balance;
		}

		

		public String getCustomerId() {
			return customerId;
		}

		
		
		
		@Override
		public String toString() {
			return "BankAccount [fmt=" + fmt + ", Balance=" + Balance + ", customerName=" + customerName + ", customerId="
					+ customerId + "]";
		}
		
	public void deposit(double amount) {
		// deposit value is negative
		if (amount < 0) 
        {
            System.out.println ();
            System.out.println ("Error: Deposit amount is invalid.");
            System.out.println (customerId + " " + fmt.format(amount));
        }
		else {
			Balance = Balance + amount;
			System.out.println("The amount of "+amount+ " has been deposited");
			previousTransaction = amount;
		}
	}
	
	
	public void withdrawal(double amount ) {
		// withdraw value is negative
		if (amount < 0)
	        {
	        System.out.println ();
	        System.out.println ("Error: Withdraw amount is invalid.");
	        System.out.println ("Account: " + customerId);
	        System.out.println ("Requested: " + fmt.format(amount));
	        }
	        else
	        	// withdraw value exceeds balance
	        	if (amount > Balance) 
	            {
	            System.out.println ();
	            System.out.println ("Error: Insufficient funds.");
	            System.out.println ("Account: " + customerId);
	            System.out.println ("Requested: " + fmt.format(amount));
	            System.out.println ("Available: " + fmt.format(Balance));
	            }else
	 {
		Balance = Balance - amount;
		System.out.println("The amount of "+amount+ " has been withdrawl");
		previousTransaction = -amount;
	}
}

	 public void transferFundsA( double amount, double interest)
	    {
		 
		// withdraw value is negative
		 if (amount < 0) 
	        {
	            System.out.println ();
	            System.out.println ("Error: Withdraw amount is invalid.");
	            System.out.println ("Account: " + customerId);
	            System.out.println ("Requested: " + fmt.format(amount));
	        }
	        else
	        	 // withdraw value exceeds balance
	        if (amount > Balance)
	        {
	            System.out.println ();
	            System.out.println ("Error: Insufficient funds.");
	            System.out.println ("Account: " + customerId);
	            System.out.println ("Requested: " + fmt.format(amount));
	            System.out.println ("Available: " + fmt.format(Balance));
	        }
	        else if(amount <= Balance ) {
	            Balance = Balance - amount;
	            previousTransaction = - amount;
		 		System.out.println("The requested amount has been transfered");
	        }
		 
			
	    }
	
	public void getPreviousTransaction() {
		if(previousTransaction  > 0) {
			System.out.println("Deposited: "+ previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("Withdrwal: "+Math.abs(previousTransaction));
		}else if(previousTransaction <= Balance) {
			System.out.println("Transfered Amount: "+Math.abs(previousTransaction));
		}
		
		else {
			System.out.println("No transaction occured");
		}
	}
	
	
	 public double addInterest ()
	    {
	        Balance += (Balance * RATE);
	        return Balance;
	    }
	
	

	
	
	public void showMenu() {
		char option='\0';
		Scanner sc =new  Scanner(System.in);
		
	
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("c. Withdrawl");
		System.out.println("D. Previous Transaction");
		System.out.println("E. TransferFunds");
		System.out.println("E. Exit");
		
		do {
			System.out.println("----------------------------------------------");
			System.out.println("Enter an option");
	
			option = sc.next().charAt(0);
		
			
			switch(option) {
			case 'A':
			
				System.out.println("Balance= "+Balance);
				System.out.println("\n");
				break;
				
			case 'B':
				
				System.out.println("Enter an amount to deposit:");
				int amount = sc.nextInt();
				deposit(amount);
				break;
				
			case 'C':
			
				System.out.println("Enter an amount to withdrawl: ");
				int amount2 = sc.nextInt();
				withdrawal(amount2);
				break;
				
			case 'D':
				
				System.out.println("Previous transaction details");
				getPreviousTransaction();
				break;
				
			case 'E':
		
				System.out.println("Enter the amount you want to transfer: ");
				int amount3 = sc.nextInt();
				transferFundsA(amount3, addInterest()  );
				break;
				
			case 'F':
				System.out.println("----------");
				break;
			default:
				System.out.println("Invalid option!! Please enter again");
				break;
			}
		}while(option != 'F');
		System.out.println("ThankYou for using our services");
	}
}

	
	
	
	
	
	
	
	
	


