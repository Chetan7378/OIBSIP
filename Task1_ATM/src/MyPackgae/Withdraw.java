package MyPackgae;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Withdraw extends Deposit {
	void withdraw()
	{
		Scanner sc=new Scanner(System.in);
		int amt;
		Connection con=Connect.connect();
		int balance = 0;
		try {
			PreparedStatement t=con.prepareStatement("select balance from user where cid=?");
			t.setInt(1, GetSet.getCid());
			ResultSet r=t.executeQuery();
			while(r.next()){
				balance=r.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   System.out.println("Enter amount to withdraw: ");
	   amt=sc.nextInt();
	   if(amt>0)
	   {
		   
	  
	   if(balance-amt>0){
		   balance-=amt;
		   
		   try {
			PreparedStatement m=con.prepareStatement("update user set balance=? where cid=?");
			m.setInt(1, balance);
			m.setInt(2,GetSet.getCid());
			m.executeUpdate();
			Date date=new Date();
			String Date=date.toString();
			String type="Withdraw";
			PreparedStatement t=con.prepareStatement("insert into transation values(?,?,?,?,?)");
			t.setInt(1, GetSet.getCid());
			t.setString(2, Date);
			t.setString(3, type);
			t.setInt(4,amt);
			t.setInt(5, balance);
			int i=t.executeUpdate();
			if(i>0)
			{
				System.out.println("Withdrawed Successfully");
				System.out.println("Updated Balance : "+balance);
			}else
			{
				System.out.println("Transaction Failed!!!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	   }else
	   {
		   System.out.println("Low Balance " +balance);
	   }
	   }else
	   {
		   System.out.println("Enter positive amount");
	   }
	  
		
	}
	

}
