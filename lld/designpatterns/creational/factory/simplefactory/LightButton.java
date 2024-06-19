package lld.designpatterns.creational.factory.simplefactory;

public class LightButton implements Button{
    @Override
    public void click() {
        System.out.println("Clicked light button!!");
    }
}
