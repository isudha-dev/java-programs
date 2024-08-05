package javas.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serial;
import java.io.Serializable;

//example of backward compatible change when serialVersionUUID has been incremented

/*
older version -

class Person implements Serializable {
    private String name;
    private int age;
    private String address; // new field

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

 */
public class Person implements Serializable {
    private String name;
    private int age;
    private String address; // new field

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.address = ""; // default value for new field
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        if (address == null) {
            address = ""; // handle case where new field is not present
        }
    }
}
