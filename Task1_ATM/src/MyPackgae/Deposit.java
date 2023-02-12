package MyPackgae;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Deposit extends Login {
	void deposit(){
		int amt,balance;
		Date date=new Date();
		String Date=date.toString();
		String type="Credit";
		Scanner sc=new Scanner(System.in);
		Connection con=Connect.connect();
		balance=(int) GetSet.getBalance();
		System.out.println("Your Current balace is "+balance);
		System.out.println("Enter Amount to deposit");
		amt=sc.nextInt();
		if(amt>0){
			
		
		balance +=amt;
		
		try {
			PreparedStatement s=con.prepareStatement("update user set balance=? where cid=?" );
			s.setInt(1, balance);
			s.setInt(2, GetSet.getCid());
			int i=s.executeUpdate();
			if(i>0)
			{
				
				
				PreparedStatement v=con.prepareStatement("insert into transation values(?,?,?,?,?)");
				v.setInt(1, GetSet.getCid());
				v.setString(2,Date);
				v.setString(3, type);
				v.setInt(4, amt);
				v.setInt(5, balance);
				int j=v.executeUpdate();
				if(j>0){
					System.out.println("Amount Deposited . . .");
					System.out.println("New Balance: "+balance);
					
				}
				
			}else
			{
				System.out.println("Failed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else
		{
			System.out.println("ENter positive amount");
		}
		
			
		
	}
	

}
