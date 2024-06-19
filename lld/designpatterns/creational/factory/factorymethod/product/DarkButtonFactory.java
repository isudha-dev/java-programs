package lld.designpatterns.creational.factory.factorymethod.product;

import lld.designpatterns.creational.factory.simplefactory.Button;
import lld.designpatterns.creational.factory.simplefactory.DarkButton;

public class DarkButtonFactory implements ButtonFactory{
    @Override
    public Button getButton() {
        return new DarkButton();
    }
}
