package lld.designpatterns.creational.factory.flutter;

import lld.designpatterns.creational.factory.flutter.components.button.Button;
import lld.designpatterns.creational.factory.flutter.components.dropdown.Dropdown;
import lld.designpatterns.creational.factory.flutter.components.menu.Menu;

public class Client {

    public static void main(String[] args) {
        Flutter flutter = new Flutter(SupportedPlatforms.IOS);
        UIFactory uiFactory = flutter.createUIFactory();
        Menu menu = uiFactory.createMenu();
        menu.selectMenu();
        Button button = uiFactory.createButton();
        button.clickButton();
        Dropdown dropdown = uiFactory.createDropdown();
        dropdown.selectDropdown();
    }


}
