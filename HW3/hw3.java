import java.util.*;

public class MyTemp{

	public static int searchQ(char [][] arrQ, int i, int n){
		for(int j=0; j<n; j++){
			if (arrQ[i][j]=='Q') {return j;}
		}
		System.out.println("Q not found, something's wrong");
		return -1;
	}

	//return true if arrSol and arrQ are identical in each element
	public static boolean compArr(char [][] arr1, char [][] arr2, int n){
		for (int i = 0; i < n; i++){
			for (int j = 0; j<n; j++){
				if ( arr1[i][j] != arr2[i][j] ) {return false;}
			}
		}
		return true;
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
		//number of solutions for different number of N
		final int [] numOfSol = {0, 0, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596};
		int x, cnt = 1; 

		Scanner sc = new Scanner(System.in);
		System.out.println("N Queens\nKey in a value for N (4 - 14)");
		final int N = sc.nextInt();

		if (N<4 || N > 14){
			System.out.println("Input out of bound");
			return;
		}

		//initialization
		char [][] arrQ = new char [N][N];
		char [][] arrSol = new char [N][N];
		for (int i = 0; i < N; i++){
			for (int j = 0; j<N; j++){
				arrQ[i][j] = '_';
				arrSol[i][j] = ' ';
			}
		}
	Outer:
		for (int i = 0; i < N; i++){
		Inner:
			for (int j=0; j < N; j++){
				//needed for final step to work
				if (arrQ[i][j]=='Q'){
					arrQ[i][j] = '_';
					j++;
				}
				if (j >= N){j--;}
				
				//if the Queen at this position does not threaten other Queens
				if (checkQ(N, arrQ, i, j)){
					arrQ[i][j] = 'Q';
					
					//if array is not identical to solution, skip this row
					if (!compArr(arrQ, arrSol, N)){
						break Inner;
					}
				}

				//go back one step if Queen has nowhere to place
				while ( j==N-1 ){
					//this 'if' statement shows a cutting-corner way to fix 
					//a bug in this messy program.
					if (arrQ[N-1][N-1]=='Q'){
						arrQ[N-1][N-1]='_';
					}

					i--;

					if (i==-1){
						System.out.println("End. "+i+","+j);
						return;
					}
					j= searchQ(arrQ, i, N);
					arrQ[i][j]='_';
					
					if ( j != N-1){
						continue Inner;
					}
				} 
			}
			

			//final step
			//if computer reaches the last row AND if there are solutions left
			if( (i == N-1) && (cnt <= numOfSol[N]) ){

				System.out.println("Solution " + cnt );
				printBoard(N, arrQ);

				//copy arrays
				for (int k = 0; k < N; k++){
					for (int l = 0; l<N; l++){
						arrSol[k][l] = arrQ[k][l];
					}
				}

				i--;
				if (i==-1){
					System.out.println("End..." );
					return;
				}
				cnt++;
			}
		}
	}

}