import java.util.*;
import java.lang.*;
import java.io.*;

class Bur{
	public static void main(String[] args){
		Scanner sc;
		String st;
		String filest;
		File myopfile;
		boolean hasAmpersand = false;

		//without the while loop, it won't w8 for u, it will just turn off
		while(true){
			hasAmpersand = false;
			sc = new Scanner(System.in);
			st = sc.nextLine();
			
			sc = new Scanner(st);
			st = sc.next();
			
			//see if the first token ends with '&'
			if(st.charAt(st.length() - 1) == '&'){
				st = st.substring(0, st.length() - 1);
				hasAmpersand = true;
			}
			
			//create a subprocess
			ProcessBuilder pb =  new ProcessBuilder(st);
			
			//if user inputs a line with multiple token
			if (sc.hasNext()){
				if(sc.next().compareTo(">") == 0){
					try{
						filest = sc.next();
						myopfile = new File(filest);
						
						//if the file does not exist
						if(!myopfile.exists()){
							myopfile.createNewFile();
						}
						
						//redirects the output destination to the file
						pb.redirectOutput(myopfile);
						System.out.println("SHELL: redirecting the output of the subprocess to '"+filest+"'");
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}

			try{
				Process p = pb.start();
				if (!hasAmpersand){
					System.out.println("SHELL: pause until the subprocess terminates.");
					//waitFor() is need to w8 for the new process to finish executing before putting another command
					p.waitFor();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
/*
Note: So I just tried running a command line utility in linux using 
ProcessBuilder. It ran silently. I'm guessing that you need to open a new 
command prompt in linux, too.  Apparently ProcessBuilder isn't like the 
posix library fork()/exec() functions that you'd use if you were writing a 
real shell after all. Oh well. Do the assignment anyway.


Write a java shell (like the command line interface of linux or DOS). The 
java shell should be able to execute the programs that you enter in a 
separate process. It should have the following features:

1) If the program name ends with an &, the shell should execute the 
program and return immediately (a non-blocking call), and let you enter 
another command. For eg, notepad& should return immediately.

2) If the program name doesn't end with an &, the shell should wait until 
the program is finished executing.

3) The shell should let the user direct the output of a program into a 
file. So if I run BLAH > output.txt, the output of BLAH should go into 
output.txt
*/