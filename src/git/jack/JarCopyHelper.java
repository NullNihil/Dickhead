package git.jack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;

public class JarCopyHelper{

	public static void copyJarFile(JarFile jarFile, File destDir) throws IOException{
		String fileName = jarFile.getName();
		String fileNameLastPart = fileName.substring(fileName.lastIndexOf(File.separator));
		File destFile = new File(destDir, fileNameLastPart);

		JarOutputStream jos = new JarOutputStream(new FileOutputStream(destFile));
		Enumeration<JarEntry> entries = jarFile.entries();

		while(entries.hasMoreElements()){
			JarEntry entry = entries.nextElement();
			InputStream is = jarFile.getInputStream(entry);

			//jos.putNextEntry(entry);
			//create a new entry to avoid ZipException: invalid entry compressed size
			jos.putNextEntry(new JarEntry(entry.getName()));
			byte[] buffer = new byte[4096];
			int bytesRead = 0;
			while((bytesRead = is.read(buffer)) != -1){
				jos.write(buffer, 0, bytesRead);
			}
			is.close();
			jos.flush();
			jos.closeEntry();
		}
		jos.close();
	}

	//Ecco come si usa:
	//	public static void main(String[] args) throws IOException{
	//		String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	//		String decodedPath = URLDecoder.decode(path, "UTF-8");
	//		System.out.println(decodedPath);
	//		copyJarFile(new JarFile("C:\\Users\\user\\Desktop\\CopyTest\\HelloWorld.jar"), new File(decodedPath.substring(0, decodedPath.length() - 4)));
	//	}

}
