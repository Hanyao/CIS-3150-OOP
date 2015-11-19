import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.*;

public class Calculator{
	public static void main(String[] args) {
		double result = 0;
		ArrayList<String> numlist = new ArrayList<String>();
		ArrayList<String> operlist = new ArrayList<String>();

		try{
			if(args.length % 2 == 0){
				throw new NotEnoughNumbersException();
			}
		}catch(NotEnoughNumbersException ex){
			return;
		}
		
		//initialize numlist 
		for(int i=0; i<(args.length/2 + 1); i++){
			numlist.add(args[i*2]);
		}

		//initialize operlist 
		for(int i=0; i<(args.length/2); i++){
			operlist.add(args[i*2+1]);
		}

		while(!(operlist.isEmpty())){
			try{
				int i = 0;
				if ( operlist.size() == 1){
					numlist.set(i, operation(numlist.get(i), numlist.get(i+1), operlist.get(i)) );
					numlist.remove(i+1);
					operlist.remove(i);

				}else if ( (operlist.get(i+1)).equals("x") || (operlist.get(i+1)).equals("/") || (operlist.get(i+1)).equals("%") ){
					numlist.set(i+1, operation(numlist.get(i+1), numlist.get(i+2), operlist.get(i+1)) );
					numlist.remove(i+2);
					operlist.remove(i+1);

				} else {
					numlist.set(i, operation(numlist.get(i), numlist.get(i+1), operlist.get(i)) );
					numlist.remove(i+1);
					operlist.remove(i);
				}
			}catch( IllegalArgumentException ex){
				return;
			}
		}
		System.out.println(numlist.get(0));
	}

	public static String operation(String a, String b, String o)throws IllegalArgumentException{
		char ch;
		double left, right;

		for(int i=0; i<a.length(); i++){
			if( !( Character.isDigit( a.charAt(i) ) || a.charAt(i) == '.') ){
				throw new NotANumberException();
			}
		}
		left = Double.valueOf(a);

		for(int i=0; i<b.length(); i++){
			if( !( Character.isDigit( b.charAt(i) ) || b.charAt(i) == '.') ){
				throw new NotANumberException();
			}
		}
		right = Double.valueOf(b);

		ch = o.charAt(0);

		switch(ch){
		case '+':
			return String.valueOf(left + right);
		case '-':
			return String.valueOf(left - right);
		case 'x':
			return String.valueOf(left * right);
		case '/':
			return String.valueOf(left / right);
		case '%':
			return String.valueOf(left % right);
		default:
			throw new IllegalOperationException();
		}
	}
}
class NotANumberException extends IllegalArgumentException{
	NotANumberException(){
		System.out.println("\nDude~~~~~ that's not a number. Re-enter the number");
	}
}
class IllegalOperationException extends IllegalArgumentException{
	IllegalOperationException(){
		System.out.println("\nDude~~~~~ that's a bad operator. Correct the operator");
	}
}
class NotEnoughNumbersException extends IllegalArgumentException{
	NotEnoughNumbersException(){
		System.out.println("\nDude~~~~~ there's a number missing. Enter that number");
	}
}