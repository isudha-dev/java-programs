package javas.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// using server-client model to serialize and deserialize object

public class Server {
    public static void main(String[] args) throws IOException, IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        // Serialize and send objects over the network
        Demo demo = new Demo(3, "From server");
        out.writeObject(demo);
        System.out.println("Object serialized");
    }
}
