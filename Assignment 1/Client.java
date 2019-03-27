import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private Socket socket;
	private DataInputStream inputStream = null;
	private DataOutputStream outputStream = null;
	
	public Client(String address, int port) {
			
		try {
			
			socket = new Socket(address, port);
			System.out.println("Connected");
			
			inputStream = new DataInputStream(System.in);
			
			outputStream = new DataOutputStream(socket.getOutputStream());
			
		} catch(UnknownHostException uhe) {
			uhe.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line = "";
		try {
		
			System.out.println("Enter string to send to server");
			line = inputStream.readLine();
			outputStream.writeUTF(line);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
			try {
				
				inputStream.close();
				outputStream.close();
				socket.close();
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public static void main(String[] args) {
		Client client = new Client("127.0.0.1", 5001);
	}
}