import java.util.*;
import java.io.*;

public class MyTemp{
	public static void main(String[] args) throws Exception {

		File file = new File("Q4numfile.txt");

		Scanner input = new Scanner(file);
	
		while (input.hasNext()){
			System.out.println(input.next());
		}
		
	}
}