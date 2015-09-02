import java.lang.Math;
import java.awt.Point;
import java.util.*;

public class MyTemp{
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		System.out.println("input coordinates for point A");
		Point A = new Point(input.nextInt(), input.nextInt());

		System.out.println("input coordinates for point B");
		Point B = new Point(input.nextInt(), input.nextInt());

		System.out.println("input coordinates for point C");
		Point C = new Point(input.nextInt(), input.nextInt());
		
		double s1, s2, s3;
	
		s1 = Math.sqrt( Math.pow(B.x - A.x, 2) + Math.pow(B.y - A.y, 2));
		s2 = Math.sqrt( Math.pow(C.x - B.x, 2) + Math.pow(C.y - B.y, 2));
		s3 = Math.sqrt( Math.pow(A.x - C.x, 2) + Math.pow(A.y - C.y, 2));
		System.out.println("the length of the sides are "+ s1 + " , " + s2 + " , " + s3);

		if ( s1 + s2 <= s3 ) {
			System.out.println("this is not a real triangle");
		} else if ( s2 + s3 <= s1 ) {
			System.out.println("this is not a real triangle");
		} else if ( s3 + s1 <= s2 ) {
			System.out.println("this is not a real triangle");
		} else {System.out.println("this is a real triangle");
		}
	}
}