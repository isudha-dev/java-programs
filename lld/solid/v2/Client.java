package lld.solid.v2;

public class Client {

    // LSP
    public void func1(Birds b) {

        b.breathe();

    }

    public void func2() {
        Crow c = new Crow();
        func1(c);

        Sparrow s = new Sparrow();
        func1(s);
    }

}
