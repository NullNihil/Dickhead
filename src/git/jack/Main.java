package git.jack;

import java.io.IOException;

public class Main{

	public static final Runtime runtime = Runtime.getRuntime();

	public static void main(String args[]){
		String command = "cmd echo hi";
		try{
			System.out.println(runtime.exec(command));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
