package lld.solid.v0;

public class Birds {
    String name;
    int noOfLegs;
    String color;

    public void fly1() {
        if (name == "Sparrow") {
            // fly sparrow
        } else if (name == "Crow") {
            // fly crow
        } else if (name == "pigeon") {
            // fly crow
        }
    }
    // Issue:
    // this violates SPR, because fly() method is responsible for checking name of
    // the bird and also executing fly steps

    // solution v0:
    // Implement specific fly methods separately and call them after checking

    public void fly2() {
        if (name == "Sparrow") {
            flySparrow();
        } else if (name == "Crow") {
            flyCrow();
        } else if (name == "pigeon") {
            flyPigeon();
        }
    }

    public void flySparrow() {
        // fly sparrow
    }

    public void flyCrow() {
        // fly crow
    }

    public void flyPigeon() {
        // fly pigeon
    }

    // Issue:
    // This violates OCP, cant extend this if a new type of bird is added eg.peocock

    // Solution v1:
    // Create child classes of Bird class and make Bird class abstract.

}
