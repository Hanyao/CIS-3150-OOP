/* helpful links
https://www.youtube.com/watch?v=ueWpNe0PG34
https://www.youtube.com/watch?v=-JwXtoJeos8
https://www.youtube.com/watch?v=kxIg0OUo4eI
http://stackoverflow.com/questions/8946088/set-default-classpath-to-use-in-java-command-in-command-prompt
*/

import java.sql.*;
import java.util.*;

class Bur{
	public static void main(String[] args){
		Enumeration<Driver> ed = DriverManager.getDrivers();

		try{
			Connection cnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutestdb", "root", "");
			Statement stmt = cnt.createStatement();
			ResultSet rs = stmt.executeQuery("select * from friends");
			
			//move from the 'start of result set', without next(), there will be a 'before the start of the result set' exception 
			rs.next();
			String st = rs.getString("name");
			System.out.println(st);
			st = rs.getString("birthyear");
			System.out.println(st);
			rs.next();
			st = rs.getString(2);
			System.out.println(st);
			st = rs.getString(3);
			System.out.println(st);

		} catch (Exception e){
			e.printStackTrace();
		}
	}
}