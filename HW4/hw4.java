import java.lang.*;
import java.util.*;

final public class MyString{
	final char [] str;
	
	public MyString(){
		this(new char[]{'\u0000'});
	}
	public MyString(char[] chars){
		int s = chars.length;
		this.str = new char[s];
		System.arraycopy(chars, 0, this.str, 0, s);
	}

	public char charAt(int index){
		char a = this.str[index];
		return a;
	}
	public int length(){
		int l = this.str.length;
		return l;
	}
	public MyString substring(int begin, int end){
		char [] chars = new char[end - begin];
		System.arraycopy(this.str, begin, chars, 0, end - begin);

		MyString mystr = new MyString(chars);
		return mystr;
	}
	public MyString toLowerCase(){
		char [] chars = new char[this.length()];
		System.arraycopy(this.str, 0, chars, 0, this.length());

		for(int i=0; i<str.length; i++){
			if ( Character.isLetter(chars[i]) && Character.isUpperCase(chars[i]) ){
				chars[i] += 32;
			}
		}

		MyString mystr = new MyString(chars);
		return mystr;
	}
	public MyString toUpperCase(){
		char [] chars = new char[this.length()];
		System.arraycopy(this.str, 0, chars, 0, this.length());

		for(int i=0; i<str.length; i++){
			if ( Character.isLetter(chars[i]) && Character.isLowerCase(chars[i]) ){
				chars[i] -= 32;
			}
		}

		MyString mystr = new MyString(chars);
		return mystr;
	}
	public boolean equals(MyString s){
		return Arrays.equals(this.str, s.str);
	}
	public MyString getMyString(){
		MyString mystr = new MyString(this.str);
		return mystr;
	}
	public String toString(){
		String st = new String(this.str);
		return st;
	}
	public static MyString valueOf(int i){
		int temp = i, cnt = 0;
		char [] quotient;
		while (temp > 0) {
			temp = temp / 10;
			cnt++;
		}
		quotient = new char[cnt];
		temp = i;
		while (cnt>0){
			int a = (int)(temp / Math.pow(10,cnt-1));
			quotient[quotient.length-cnt]=Character.forDigit(a, 10);
			temp = (int)(temp % Math.pow(10,cnt-1));
			System.out.println(temp+", "+quotient[quotient.length-cnt]);
			cnt--;
		}
		MyString mystr = new MyString(quotient);
		return mystr;
	}

	public static void main(String[] args){
		MyString mystr1 = new MyString(new char[]{'H', 'e', 'y', ',', ' ', 'B', 'r', 'o'});
		System.out.println("char at index 5 is: "+mystr1.charAt(5));
		System.out.println("substring from index 2 to index 7 is: "+mystr1.substring(2,7));
		System.out.println("take a look at it in lower case: "+mystr1.toLowerCase());
		System.out.println("take a look at it in upper case: "+mystr1.toUpperCase());

		MyString mystr2 = new MyString();
		System.out.println("print 1st MyString: "+mystr1.getMyString()+"\nprint 2nd MyString: "+mystr2.getMyString());
		System.out.println("print 1st MyString in String "+mystr1.toString());

		System.out.println("are they equal? "+mystr1.equals(mystr2));
		mystr2 = new MyString(new char[]{'H', 'e', 'y', ',', ' ', 'B', 'r', 'o'});
		System.out.println("Now, are they equal? "+mystr1.equals(mystr2));

		Scanner sc = new Scanner(System.in);
		System.out.println("key in an integer ");
		int i = sc.nextInt();
		mystr1 = MyString.valueOf(i);
		System.out.println("the value of integer appeared as a MyString object is: "+mystr1.getMyString());
		
	}
}