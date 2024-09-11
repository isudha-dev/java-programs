package lld.designpatterns.creational.factory.factorymethod.product;

import lld.designpatterns.creational.factory.factorymethod.factory.Button;
import lld.designpatterns.creational.factory.factorymethod.factory.DarkButton;

public class DarkButtonFactory implements ButtonFactory{
    @Override
    public Button getButton() {
        return new DarkButton();
    }
}
