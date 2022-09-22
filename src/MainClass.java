import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String user,pass;
		
		System.out.println("Enter your userId: ");
		user = sc.nextLine();
		
		System.out.println("Enter your password: ");
		pass = sc.nextLine();
		
		if(user.equals("ayush") && pass.equals("jais")) {
			System.out.println();
		System.out.println("Welcome "+user+"!");
		BankAccount obj = new BankAccount();
		obj.showMenu();
		}else {
			System.out.println("Please check your credentials");
		}
	}
}
