package MyPackgae;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class History extends Transfer {
	void history()
	{
		Connection con=Connect.connect();
		try {
			PreparedStatement p=con.prepareStatement("select * from transation where cid=?");
			p.setInt(1, GetSet.getCid());
			ResultSet t=p.executeQuery();
			System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("DATE                                                                TYPE                 AMOUNT            BALANCE");
			System.out.println("-------------------------------------------------------------------------------------------");
while(t.next()){
	System.out.println("-------------------------------------------------------------------------------------------");
    System.out.println(t.getString(2)+"                          "+t.getString(3)+"               "+t.getInt(4)+"              "+t.getInt(5));
    System.out.println("-------------------------------------------------------------------------------------------");
	
}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
