import java.util.Random;
import java.lang.Math;
import java.math.BigInteger;

public class MyTemp{
	public static void main(String[] args){
		Random rnd = new Random();
		double cnt = 0;
		int r = 10000;
		int N = 1000000000;

		//area of the square
		int aos = r*r;
		//area of the quarter circle
		double aoqc = Math.PI * r * r / 4;
		double num = aoqc/aos;
		System.out.println("area of the square is "+aos+"\narea of the quarter circle is "+aoqc+"\nThe ratio is "+num);

		for (int i = 0; i < N; i++){
			if (rnd.nextDouble() <= num){
				cnt++;
			}
		}
		System.out.println("q1");
		for (int i = 0; i < N; i++){
			if (rnd.nextDouble() <= num){
				cnt++;
			}
		}
		System.out.println("q2");
		for (int i = 0; i < N; i++){
			if (rnd.nextDouble() <= num){
				cnt++;
			}
		}
		System.out.println("q3");
		for (int i = 0; i < N; i++){
			if (rnd.nextDouble() <= num){
				cnt++;
			}
		}
		
		System.out.println("count is " + cnt);
		double dbn = ((double)N) * 4;
		System.out.println("N is " + dbn);
		double db = cnt / dbn;
		System.out.println("ratio is " + db);
	}
}