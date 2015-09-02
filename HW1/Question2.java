import java.lang.Math;
import java.util.*;

public class MyTemp{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextInt()) {
			int r = sc.nextInt();
			double a = Math.PI * Math.pow((double)r, 2);
			System.out.println("the area of the circle is " + a + "\n");
			if (sc.hasNext("^d")){return;}
			
		}
		
	}
}