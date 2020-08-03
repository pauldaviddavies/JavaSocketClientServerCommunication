import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket;
        DataOutputStream dataOutputStream;
        DataInputStream dataInputStream;
        try{
            socket = new Socket("127.0.0.1", 9080);
            dataInputStream = new DataInputStream(System.in);
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String line = "";
            while(!line.equals("Over")) {
                line = dataInputStream.readLine();
                dataOutputStream.writeUTF(line);
            }

            try{
                dataOutputStream.close();
                dataInputStream.close();
                socket.close();
            }
            catch (IOException e) {
                System.out.println("Error: "+e.getMessage());
            }
        }
        catch (IOException exception) {
            System.out.println("Error: "+exception.getMessage());
        }
    }
}
