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
		Socket s = new Socket(InetAddress.getByName("joshuaharmon.io"), 80);
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		pw.println("GET / HTTP/1.1");
		pw.println("Host: joshuaharmon.io");
		pw.println("");
		pw.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String t;
		while((t = br.readLine()) != null) System.out.println(t);
		br.close();
	}
}
