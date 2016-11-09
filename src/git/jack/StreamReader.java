package git.jack;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class StreamReader extends Thread{
	//http://www.rgagnon.com/javadetails/java-0480.html
	private InputStream is;
	private StringWriter sw;

	StreamReader(InputStream is){
		this.is = is;
		sw = new StringWriter();
	}

	@Override
	public void run(){
		try{
			int c;
			while((c = is.read()) != -1)
				sw.write(c);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	String getResult(){
		return sw.toString();
	}

}
