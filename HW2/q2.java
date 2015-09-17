import java.util.*;

public class MyTemp{

	public static int printCalRow(int cnt, int dnum){
		for (int j=0; j<7; j++){
			if( (cnt>0) && (cnt<=dnum) ){
				System.out.printf("%3d", cnt++);
		} else {
			System.out.printf("%3s", "");
			cnt++;
			}
		}
		System.out.println();
		return cnt;
	}

	public static void main(String[] args){
		int yr, Jan_1, offset, i, j, temp;
		String [] mth = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		Scanner sc = new Scanner(System.in);

		System.out.println("enter a year");
		yr = sc.nextInt();
		System.out.println("\nenter the day(0-6) the first of January fell on.\n0 is Sunday and 1 is Monday");
		offset = sc.nextInt();
		
		for ( i = 0; i < 12; i++){
			switch(i){
			case 0: case 2: case 4: case 6: case 7: case 9: case 11:
				System.out.printf("%12s %4d%n", mth[i], yr);
				System.out.println(" Su Mo Tu We Th Fr Sa");
				temp = offset;
				offset = 0 - offset +1;

				for (j=0; j<6; j++){
					offset = printCalRow(offset, 31);
				}

				offset = (31 + temp) % 7;
				System.out.println();
				break;

			case 3: case 5: case 8: case 10:
				System.out.printf("%12s %4d%n", mth[i], yr);
				System.out.println(" Su Mo Tu We Th Fr Sa");
				temp = offset;
				offset = 0 - offset + 1;
				
				for (j=0; j<6; j++){
					offset = printCalRow(offset, 30);
				}
				
				offset = (30 + temp) % 7;
				System.out.println();
				break;

			//this is the case for February
			case 1:
				System.out.printf("%12s %4d%n", mth[i], yr);
				System.out.println(" Su Mo Tu We Th Fr Sa");
				temp = offset;
				offset = 0 - offset + 1;
				
				if ((yr % 4) == 0) {
					for (j=0; j<5; j++){
						offset = printCalRow(offset, 29);
					}

					offset = (29 + temp) % 7;
				} else {
					for (j=0; j<5; j++){
						 offset = printCalRow(offset, 28);
					}

					offset = (28 + temp) % 7;
				}
				System.out.println();
				break;

			default:
				System.out.println("Something's wrong");
				break;
			}
		}
	}
}
/* I found this web page very helpful
http://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
*/