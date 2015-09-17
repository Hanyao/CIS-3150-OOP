import java.util.*;

public class MyTemp{


	public static void main(String[] args){
		int i = 0;
		Scanner sc = new Scanner(System.in);
		String a;
		boolean hungry = true;
		final String [] ITEM = {"a T-shirt", "three dollar bills", "a pen",
					"a soap", "a bag of chips", "a pair of socks"};
		System.out.println("John wakes up\nHe starts to search for food");
		
	A:
		while(hungry){
			System.out.println("press \"enter\" to search");
			a = sc.nextLine();
			if( a.compareToIgnoreCase("") != 0 ) {
				System.out.println("something's wrong");
			}
		B:
			while(i<6){
				System.out.println("He found " + ITEM[i]);
				if ( ITEM[i] == "a bag of chips" ){
					System.out.println("He found food!");
					hungry = false;
					break A;
				} else { 
					System.out.println("He doesn't want to eat this\n");
					i++;
					break B;
				}
			}

		}
		System.out.println("\nThe End\n");
	}
}
/* I found this link very helpful
https://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html
*/