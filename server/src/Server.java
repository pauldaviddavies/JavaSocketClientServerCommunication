import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        DataInputStream dataInputStream;
        try {
            serverSocket = new ServerSocket(9080);
            System.out.println("Server started, waiting for client...");
            socket = serverSocket.accept();
            System.out.println("Client accepted...");

            dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line ="";
            while(!line.equals("Over")) {
                try{
                    line = dataInputStream.readUTF();
                    System.out.println("Received: "+line);
                }
                catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            }
            System.out.println("Closing connection");
            socket.close();
            dataInputStream.close();
        }
        catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
