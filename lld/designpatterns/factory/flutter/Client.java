package lld.designpatterns.factory.flutter;

import lld.designpatterns.factory.flutter.components.button.Button;
import lld.designpatterns.factory.flutter.components.dropdown.Dropdown;
import lld.designpatterns.factory.flutter.components.menu.Menu;

public class Client {

    public static void main(String[] args) {
        Flutter flutter = new Flutter(SupportedPlatforms.ANDROID);
        UIFactory uiFactory = flutter.createUIFactory();
        Menu menu = uiFactory.createMenu();
        Button button = uiFactory.createButton();
        Dropdown dropdown = uiFactory.createDropdown();
    }


}
