package git.jack;

public class Main{

	public static final Runtime runtime = Runtime.getRuntime();

	public static void main(String args[]){
		/*
		 * cose interessanti scritte in ordine di comparsa nel comando ALLUSERPROFILE APPDATA ComSpec HOMEDRIVE HOMEPATH SystemDrive USERNAME USERPROFILE windir
		 */
		try{
			//crea string con comando e processo vuoto
			String command = "cmd /C set";
			Process process = null;

			//esegue il comando col processo
			process = runtime.exec(command);
			//crea un leggi-processo
			StreamReader reader = new StreamReader(process.getInputStream());

			//apre il leggi-processo
			reader.start();
			//aspetta che finisce il processo
			process.waitFor();
			//chiude il leggi-processo
			reader.join();

			//prende risultato
			String result = reader.getResult();
			System.out.println(result);
		}catch(Exception e){
			e.printStackTrace();
		}

		//metti nome di os in osName, vedi se contiene "windows", se sì allora è windows.
		String osName = System.getenv("OS");
		if(osName.toLowerCase().contains("windows")){
			System.out.println("WINDOWS DETECTED");
		}else if(osName.toLowerCase().contains("mac")){
			System.out.println("MAC DETECTED");
		}else if(osName.toLowerCase().contains("linux")){
			System.out.println("LINUX DETECTED");
		}
	}
}
