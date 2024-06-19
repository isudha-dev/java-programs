package lld.designpatterns.behavioral.strategy;

public class Client {

    public static void main(String[] args) {
        Maps map = new Maps();
        map.findPath("Delhi","Bangalore","Car");
    }

}
