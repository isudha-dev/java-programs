package lld.designpatterns.creational.factory.factorymethod.factory;

public class LightButton implements Button {
    @Override
    public void click() {
        System.out.println("Clicked light button!!");
    }
}
