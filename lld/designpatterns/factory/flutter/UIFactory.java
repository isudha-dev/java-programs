package lld.designpatterns.factory.flutter;

import lld.designpatterns.factory.flutter.components.button.Button;
import lld.designpatterns.factory.flutter.components.dropdown.Dropdown;
import lld.designpatterns.factory.flutter.components.menu.Menu;

public interface UIFactory {

    Button createButton();
    Menu createMenu();
    Dropdown createDropdown();

}
