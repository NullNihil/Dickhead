package git.jack;

public class Main{

	public static final Runtime runtime = Runtime.getRuntime();

	public static void main(String args[]){
		//PROCESS EXAMPLE
		//		try{
		//			String command = "cmd /C set";
		//			Process process = null;
		//
		//			process = runtime.exec(command);
		//			StreamReader reader = new StreamReader(process.getInputStream());
		//
		//			reader.start();
		//			process.waitFor();
		//			reader.join();
		//
		//			String result = reader.getResult();
		//			System.out.println(result);
		//		}catch(Exception e){
		//			e.printStackTrace();
		//		}

		//metti nome di os in osName, vedi se contiene "windows", se sì allora è windows.
		String osName = System.getenv("OS");
		if(osName.toLowerCase().contains("windows")){
			System.out.println("WINDOWS DETECTED");
		}
	}
}
