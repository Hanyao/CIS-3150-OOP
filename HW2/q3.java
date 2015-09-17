import java.util.*;

public class MyTemp{

	public static boolean check(String st){
		final int L = st.length();
		for ( int i = 0; i < L/2; i++){
			if ( st.charAt(i) != st.charAt(L-1-i) ) return false;
		}
		return true;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a string");
		
		if ( check( sc.next() ) ){
			System.out.println("it's a palindrome");
		} else {
			System.out.println("it's not a palindrome");
		}
	}
}
