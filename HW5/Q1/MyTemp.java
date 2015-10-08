import EleDevice.*;
import PC.*;

final public class MyTemp{
	public static void main(String[] args){
		PC mypc = new PC(10, 100, "ACER", 100);
		
		//the following line works
		System.out.println("voltage of this pc is " + mypc.getVolt());

		//the following line didn't work, it only works when "volt" is declared public
		//System.out.println("voltage of this pc is " + mypc.volt);
		//note that both line failed when the visibility of "volt"
		//is "no modifier"(default) or private
		//So, we can conclude that protected variables CAN be accessed 
		//through subclass member function
	}
}

//this link is very helpful
//http://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
//see where it says
//"The protected modifier specifies that the member can only be accessed within its own package (as with package-private) and, in addition, by a subclass of its class in another package."