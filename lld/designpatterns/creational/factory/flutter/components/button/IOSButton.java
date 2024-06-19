package lld.designpatterns.creational.factory.flutter.components.button;

public class IOSButton implements Button{

    public IOSButton(){
        System.out.println("IOS button created");
    }
    @Override public void clickButton() {
        System.out.println("IOS button clicked");
    }
}
