package lld.designpatterns.factory.flutter.components.button;

public class AndroidButton implements Button{

    public AndroidButton(){
        System.out.println("Android button created");
    }

    @Override public void clickButton() {
        System.out.println("Android button clicked");
    }
}
