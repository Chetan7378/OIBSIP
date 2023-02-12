package MyPackgae;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Main extends History {
	public static void main(String[] args) {
		int ch;
		Scanner S = new Scanner(System.in);
		Main m=new Main();
		
		System.out.println("--------------------------------------------");
		System.out.println("-------------ATM INTERFACE-------------");
		float balance;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your  ID: ");
		int cid=sc.nextInt();
		System.out.println("Enter your pin: ");
		String pwd=sc.next();
	Connection con=Connect.connect();
	try {
		PreparedStatement t=con.prepareStatement("select balance,name from user where cid=? and pwd=?");
		t.setInt(1, cid);
		t.setString(2, pwd);
		ResultSet r=t.executeQuery();
	if(r.next()){
		System.out.println("Hello "+r.getString(2));
		GetSet.setCid(cid);
		balance = r.getFloat(1);
		GetSet.setBalance(r.getFloat(1));
		System.out.println("Your Account balance : "+balance);
		System.out.println("\n");

		do{
			
			System.out.println("Choose the one Operation  :- ");
			System.out.println("---------------------------------------------------------------");
			System.out.println("1.Transaction History \n2.Deposit \n3.Withdraw \n4.Transfer \n5.Quit");
			System.out.println("Enter your choice:");
			ch = S.nextInt();
			switch(ch){
			case 1: m.history();
			break;
			case 2: m.deposit();
			break;
			case 3: m.withdraw();
			break;
			case 4:
				m.transfer();
				break;
			case 5:
				   System.out.println("*****Thank you for choosing our services sir*****");
		           System.out.println("************* Have a great day***************");
		           System.exit(0);
		           default :
		        	   System.out.println("Invalid choice");
			}

}while(ch!=6);
}else
{
	System.out.println("Invalid Input");
}
	
}
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}	

	