import java.util.*;

public class MyTemp{

	public static int searchQ(char [][] arrQ, int i, int n){
		for(int j=0; j<n; j++){
			if (arrQ[i][j]=='Q') {return j;}
		}
		System.out.println("Q not found, something's wrong");
		return -1;
	}

	public static boolean checkQ(int n, char [][] arrQ, int i, int j){
		int k;
		for (k= 0; k< n; k++){
			if (k==j){continue;}
			if (arrQ[i][k] == 'Q'){return false;}
		}
		for (k= 0; k< n; k++){
			if (k==i){continue;}
			if (arrQ[k][j] == 'Q'){return false;}
		}

		//diagonal
		for (k= 1; (i+k<n)&&(j+k<n); k++){
			if (arrQ[i+k][i+k] == 'Q'){return false;}
		}
		for (k= 1; (i-k>=0)&&(j-k>=0); k++){
			if (arrQ[i-k][j-k] == 'Q'){return false;}
		}
		for (k= 1; (i+k<n)&&(j-k>=0); k++){
			if (arrQ[i+k][j-k] == 'Q'){return false;}
		}
		for (k= 1; (i-k>=0)&&(j+k<n); k++){
			if (arrQ[i-k][j+k] == 'Q'){return false;}
		}
		return true;
	}
	
	public static void printBoard(int n, char [][] arrQ){
		for(int i = 0; i < n; i++){System.out.print("___");}
		System.out.println();
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print("|_" + arrQ[i][j]);
			}
			System.out.println("|");
		}
		System.out.println();
	}

public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("N Queens\nKey in a value for N");
		final int N = sc.nextInt();

		char [][] arrQ = new char [N][N];
		for (int i = 0; i < N; i++){
			for (int j = 0; j<N; j++){
				arrQ[i][j] = '_';
			}
		}
		for (int i = 0; i < N; i++){
		Inner:
			for (int j = 0; j < N; j++){
				if (checkQ(N, arrQ, i, j)){
					arrQ[i][j] = 'Q';
					break Inner;
				}

			//go back one step if Queen has nowhere to place
			Wloop:
				while ( j==N-1 ){
					i--;

					j= searchQ(arrQ, i, N);
					arrQ[i][j]='_';
					
					if ( j == N-1) {continue Wloop;}
					continue Inner;
				} 
			}
		}
		System.out.println(">>>>Solution<<<<");
		printBoard(N, arrQ);
	}

}