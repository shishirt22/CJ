package codejudge;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Codejudge {
	
	public static void main(String args[]) {
		int n=0;
		try {
			ServerSocket server = new ServerSocket(9090); // create a new socket to listen on
			System.out.println("Codejudge compilation server running ...");
			while(true) {
				n++;
				// accept any incoming connection and process it on a new thread
				Socket s = server.accept();
				RequestThread request = new RequestThread(s, n);
				request.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
