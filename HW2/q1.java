import java.lang.Math;
import java.util.*;
public class MyTemp{
	public static void main(String[] args){
		int i, input, k, d;
		Scanner sc = new Scanner(System.in);
		System.out.println("give me an integer");
		input = sc.nextInt();

		for( i=0; i < input; i++){
			for(k=0; k < (i + input); k++){
				d=Math.abs(k-(input-1));
				if ((i-d+1) > 0) {System.out.print((i-d+1)+"\t");}
				else {System.out.print("\t");}
			}
			System.out.println();
		}
	}
}