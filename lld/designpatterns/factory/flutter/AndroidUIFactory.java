package lld.designpatterns.factory.flutter;

import lld.designpatterns.factory.flutter.components.button.AndroidButton;
import lld.designpatterns.factory.flutter.components.button.Button;
import lld.designpatterns.factory.flutter.components.dropdown.Dropdown;
import lld.designpatterns.factory.flutter.components.menu.AndroidMenu;
import lld.designpatterns.factory.flutter.components.menu.Menu;

public class AndroidUIFactory implements UIFactory{

    @Override public Button createButton() {
        return new AndroidButton();
    }
    @Override public Menu createMenu() {
        return new AndroidMenu();
    }
    @Override public Dropdown createDropdown() {
        return null;
    }
}
