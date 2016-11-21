package git.jack;

import java.io.File;
import java.io.PrintWriter;

public class Main{

	public static final Runtime runtime = Runtime.getRuntime();

	@SuppressWarnings("unused")
	private static String getOs(){
		//metti nome di os in osName, vedi se contiene "windows", se sì allora è windows.
		String osName = System.getenv("OS");
		if(osName.toLowerCase().contains("windows")){
			return "Windows";
		}else if(osName.toLowerCase().contains("mac")){
			return "Mac";
		}else if(osName.toLowerCase().contains("linux")){
			return "Linux";
		}
		return "wtfisthis";
	}

	@SuppressWarnings("unused")
	private static void exec(){
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

	}

	private static void createBatchFile(String[] content){
		try{
			File file = new File("test.bat");
			file.createNewFile();
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			//per ogni String in content, scrivi quella String nel file
			for(String s : content){
				writer.println(s);
			}
			writer.close();
		}catch(Exception e){

		}
	}

	public static void main(String args[]){
		/*
		 * cose interessanti scritte in ordine di comparsa nel comando ALLUSERPROFILE APPDATA ComSpec HOMEDRIVE HOMEPATH SystemDrive USERNAME USERPROFILE windir
		 */

		//crea file hello world, ricordati di refreshare il navigator cancellare il .bat
		createBatchFile(new String[] { "@echo off", "echo Hello World", "pause" });
	}
}
