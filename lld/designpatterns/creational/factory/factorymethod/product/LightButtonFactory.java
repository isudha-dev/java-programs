package lld.designpatterns.creational.factory.factorymethod.product;

import lld.designpatterns.creational.factory.factorymethod.factory.Button;
import lld.designpatterns.creational.factory.factorymethod.factory.LightButton;

public class LightButtonFactory implements ButtonFactory{
    @Override
    public Button getButton() {
        return new LightButton();
    }
}
