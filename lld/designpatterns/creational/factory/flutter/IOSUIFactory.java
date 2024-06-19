package lld.designpatterns.creational.factory.flutter;

import lld.designpatterns.creational.factory.flutter.components.button.Button;
import lld.designpatterns.creational.factory.flutter.components.button.IOSButton;
import lld.designpatterns.creational.factory.flutter.components.dropdown.Dropdown;
import lld.designpatterns.creational.factory.flutter.components.dropdown.IOSDropdown;
import lld.designpatterns.creational.factory.flutter.components.menu.IOSMenu;
import lld.designpatterns.creational.factory.flutter.components.menu.Menu;

public class IOSUIFactory implements UIFactory{

    @Override public Button createButton() {
        return new IOSButton();
    }
    @Override public Menu createMenu() {
        return new IOSMenu();
    }
    @Override public Dropdown createDropdown() {
        return new IOSDropdown();
    }
}
