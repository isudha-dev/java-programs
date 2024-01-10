package javas.serialization;

import java.io.*;

public class Demo implements Serializable {
    public int a;
    public String b;
    @Serial
    private static final long serialVersionUID = 1L;

    public Demo(int a, String b) {
        this.a = a;
        this.b = b;
    }
}

class Test {
    public static void main(String[] args) {
        Demo object = new Demo(1, "example");
        String filename = "file.txt";

        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(object); // serializes object
            out.close();
            file.close();

            FileInputStream in = new FileInputStream(filename);
            ObjectInputStream is = new ObjectInputStream(in);
            Demo ob = (Demo) is.readObject(); // de-serializes object
            System.out.println(ob.a);
            System.out.println(ob.b);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
