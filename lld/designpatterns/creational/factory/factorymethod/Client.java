package lld.designpatterns.creational.factory.factorymethod;

import lld.designpatterns.creational.factory.factorymethod.product.ButtonFactory;
import lld.designpatterns.creational.factory.factorymethod.product.DarkButtonFactory;
import lld.designpatterns.creational.factory.factorymethod.product.LightButtonFactory;

public class Client {
    public static void main(String[] args) {
        ButtonFactory bf = new DarkButtonFactory();
        bf.getButton().click();

        ButtonFactory bf2 = new LightButtonFactory();
        bf2.getButton().click();
    }
}
