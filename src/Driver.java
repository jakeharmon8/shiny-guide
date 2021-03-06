import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Driver {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//GameFrame.launchGame();
		
		// set up a socket
		Socket s = new Socket(InetAddress.getByName("joshuaharmon.io"), 80);
		
		// set up a way to give the socket text
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		
		// give it the first line
		pw.println("GET / HTTP/1.1");
		
		pw.println("Host: joshuaharmon.io");
		
		pw.println("");

		// send the message!
		pw.flush();
		
		// set up a way to read the response
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		// print it out, one line at a time
		String t;
		while((t = br.readLine()) != null) System.out.println(t);
		br.close();
	}
}
