package lld.designpatterns.factory.flutter;

import lld.designpatterns.factory.flutter.components.button.Button;
import lld.designpatterns.factory.flutter.components.dropdown.Dropdown;
import lld.designpatterns.factory.flutter.components.menu.Menu;

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
