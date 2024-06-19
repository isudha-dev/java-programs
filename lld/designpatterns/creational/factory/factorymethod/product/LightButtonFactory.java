package lld.designpatterns.creational.factory.factorymethod.product;

import lld.designpatterns.creational.factory.simplefactory.Button;
import lld.designpatterns.creational.factory.simplefactory.LightButton;

public class LightButtonFactory implements ButtonFactory{
    @Override
    public Button getButton() {
        return new LightButton();
    }
}
