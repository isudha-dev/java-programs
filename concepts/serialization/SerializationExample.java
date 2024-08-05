package javas.serialization;

import java.io.*;

class Demo1 implements Serializable {
    public int a;
    public String b;
    @Serial
    private static final long serialVersionUID = 1L;

    public Demo1(int a, String b) {
        this.a = a;
        this.b = b;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        // Create an object to be serialized
        Demo1 object = new Demo1(1, "hello");

        // Serialize the object to a byte array
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(byteOut)) {
            out.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object from the byte array
        byte[] bytes = byteOut.toByteArray();
        ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
        try (ObjectInputStream in = new ObjectInputStream(byteIn)) {
            Demo1 deserializedObject = (Demo1) in.readObject();
            System.out.println(deserializedObject.a);
            System.out.println(deserializedObject.b);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}