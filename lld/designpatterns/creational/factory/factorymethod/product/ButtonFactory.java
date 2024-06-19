package lld.designpatterns.creational.factory.factorymethod.product;

import lld.designpatterns.creational.factory.simplefactory.Button;
import lld.designpatterns.creational.factory.simplefactory.ButtonType;

public interface ButtonFactory {

    Button getButton();
}
