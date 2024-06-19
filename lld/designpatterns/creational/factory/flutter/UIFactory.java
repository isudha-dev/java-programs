package lld.designpatterns.creational.factory.flutter;

import lld.designpatterns.creational.factory.flutter.components.button.Button;
import lld.designpatterns.creational.factory.flutter.components.dropdown.Dropdown;
import lld.designpatterns.creational.factory.flutter.components.menu.Menu;

public interface UIFactory {

    Button createButton();
    Menu createMenu();
    Dropdown createDropdown();

}
