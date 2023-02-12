package MyPackgae;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Transfer extends Withdraw{
	void transfer()
	{
		int amt,balance=0;
		int acc;
		int acc2 = 0;
		Scanner sc=new Scanner(System.in);
		Date date = new Date();
		String Date=date.toString();
		String type="Transfer";
		
		Connection con=Connect.connect();
		try {
			PreparedStatement h=con.prepareStatement("select balance from user where cid=?");
			h.setInt(1, GetSet.getCid());
			ResultSet r=h.executeQuery();
			while(r.next()){
				balance=r.getInt(1);	
				System.out.println("Enter receiver account number : ");
				 acc2=sc.nextInt();
				 PreparedStatement j=con.prepareStatement("select balance from user where acc=?");
					j.setInt(1, acc2);
					ResultSet x=j.executeQuery();
				if(x.next()){
					System.out.println("Enter Amount to transfer : ");
					 amt=sc.nextInt();
					 if(amt>0){
						 if(balance-amt>0){
							 balance-=amt;
							 PreparedStatement c=con.prepareStatement("update user set balance=? where cid=?");
						 		c.setInt(1, balance);
						 		c.setInt(2, GetSet.getCid());
						 		c.executeUpdate();
								PreparedStatement b=con.prepareStatement("update user set balance=balance+? where acc=?");
								b.setInt(1, amt);
								b.setInt(2, acc2);
								b.executeUpdate();
								
								PreparedStatement t=con.prepareStatement("insert into transation values(?,?,?,?,?)");
								t.setInt(1, GetSet.getCid());
								t.setString(2, Date);
								t.setString(3, type);
								t.setInt(4,amt);
								t.setInt(5, balance);
								int i=t.executeUpdate();
								if(i>0){
									if(i>0){
										System.out.println("Amount transferred. . .");
										System.out.println("Updated Balance : "+balance);
									}else
									{
										System.out.println("Transaction Failed!!!");
									}
								}
							 
						 }else
						 {
							 System.out.println("Insufficient Balance");
						 }
						 
					 }else
					 {
						 System.out.println("Enter Positive Amount");
					 }
				}else
				{
					System.out.println("Invalid Receiver Account Number");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
