import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private Socket socket = null;
	private ServerSocket serverSocket = null;
	private DataInputStream inputStream = null;
	
	public Server(int port) {
		
		try {
			
			serverSocket = new ServerSocket(port);
			System.out.println("Server started on Port " + port);
			
			System.out.println("Waiting for Request from client...");
			
			socket = serverSocket.accept();
			System.out.println("Client Accepted");
			
			inputStream = new DataInputStream(
					new BufferedInputStream(
							socket.getInputStream()
							)
					);
			
			String line = "";
			
			line = inputStream.readUTF();
			System.out.println(line);
			
			System.out.println("Closing the connection");
			
			socket.close();
			inputStream.close();
			
		} catch(IOException ioE) {
			ioE.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Server server = new Server(5001);
	}
	
}