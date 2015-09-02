import java.lang.Math;
import java.awt.Point;
import java.util.*;

public class MyTemp{
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		System.out.println("input the center coordinate for circle A");
		Point A = new Point(input.nextInt(), input.nextInt());
		System.out.println("input the radius for circle A");
		int r1 = input.nextInt();

		System.out.println("input the center coordinate for circle B");
		Point B = new Point(input.nextInt(), input.nextInt());
		System.out.println("input the radius for circle B");
		int r2 = input.nextInt();

		//computes the distance between two center coordinates
		double d = Math.sqrt( Math.pow(B.x - A.x, 2) + Math.pow(B.y - A.y, 2));

		if ( r1 + r2 < d) {System.out.println("they are separated from each other");}
		if ( r1 + r2 == d) {System.out.println("they are touching each other");}
		if ( r1 >= d + r2) {System.out.println("B is completely within A");}
		else if ( r2 >= d + r1) {System.out.println("A is completely within B");}
		else if ( r1 + r2 > d) {System.out.println("they are overlapping each other");}
	}
}