package lld.designpatterns.creational.factory.factorymethod.product;

import lld.designpatterns.creational.factory.factorymethod.factory.Button;
import lld.designpatterns.creational.factory.factorymethod.factory.ButtonType;

public interface ButtonFactory {

    Button getButton();
}
