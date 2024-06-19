package lld.designpatterns.creational.factory.flutter;

import lld.designpatterns.creational.factory.flutter.components.button.AndroidButton;
import lld.designpatterns.creational.factory.flutter.components.button.Button;
import lld.designpatterns.creational.factory.flutter.components.dropdown.AndroidDropdown;
import lld.designpatterns.creational.factory.flutter.components.dropdown.Dropdown;
import lld.designpatterns.creational.factory.flutter.components.menu.AndroidMenu;
import lld.designpatterns.creational.factory.flutter.components.menu.Menu;

public class AndroidUIFactory implements UIFactory{

    @Override public Button createButton() {
        return new AndroidButton();
    }
    @Override public Menu createMenu() {
        return new AndroidMenu();
    }
    @Override public Dropdown createDropdown() {
        return new AndroidDropdown();
    }
}
