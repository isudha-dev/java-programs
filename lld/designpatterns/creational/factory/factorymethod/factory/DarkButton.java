package lld.designpatterns.creational.factory.factorymethod.factory;

public class DarkButton implements Button {
    @Override
    public void click() {
        System.out.println("Clicked dark button!!");
    }
}
