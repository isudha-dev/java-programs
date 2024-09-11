package lld.designpatterns.creational.factory.simplefactory;

public class Client {
    public static void main(String[] args) {
        Button darkButton = ButtonFactory.getButton(ButtonType.DARK);
        darkButton.click();
        Button lightButton = ButtonFactory.getButton(ButtonType.LIGHT);
        lightButton.click();
    }
}
