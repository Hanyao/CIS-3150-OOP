import java.lang.String;
import java.io.*;
import java.util.*;

public class Bur{
	public static void main(String[] args){
		try{
			int cnt = 0;
			File ofile = new File("dir_tree.txt");
			if(!ofile.exists()){
				ofile.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(ofile));

			//initial the scanner file to root directory
			File scfile = File.listRoots()[0];
			bw.write(scfile + "");
			bw.newLine();
			bw.flush();

			scanDir(scfile, bw, cnt);
		}catch(IOException e){
			//prints the trace when something wrong
			e.printStackTrace();
		}
	}

	public static void scanDir(File scf, BufferedWriter bw, int cnt)throws IOException{
		cnt++;
		String [] starr = scf.list();
		File [] farr = scf.listFiles();

		//if nothing in this dir, return
		if(starr == null){
			System.out.println("oops, nothing in this dir");
			return;
		}
		
		for(int i = 0; i < starr.length; i++){
			File tempf = new File(scf.getPath());
			Stack<String> stk = new Stack<String>();
			while (tempf != null){
				if (isLast(tempf)){
					stk.push( new String("   ") );
				} else {
					stk.push( new String("|  ") );
				}
				tempf = tempf.getParentFile();
			}
			//get rid of the top one, it's useless
			stk.pop();
			while (!stk.empty()){
				bw.write(stk.peek(), 0, (stk.peek()).length());
				stk.pop();
			}
			bw.write("|--" + starr[i]);
			bw.newLine();
			bw.flush();
			
			if(farr[i].isDirectory()){
				scanDir(farr[i], bw, cnt);
			}
		}
	}
	public static boolean isLast(File f){
		boolean l = false;
		File pf = f.getParentFile();
		if ( pf == null ){
			return l;
		}
		int i = pf.list().length - 1;
		if ( (pf.listFiles()[i]).compareTo(f) == 0 ) {
			l = true;
		}
		return l;
	}
}
/*
CITE
http://www.mkyong.com/java/how-to-write-to-file-in-java-bufferedwriter-example/

*/