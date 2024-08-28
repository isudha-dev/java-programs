package concepts.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

// using server-client model to serialize and deserialize object
public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 8888);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        // Deserialize and process objects received from the network
        Demo demo = (Demo) in.readObject();
        System.out.println("Object de-serialized");
        System.out.println(demo.a);
        System.out.println(demo.b);
    }
}
