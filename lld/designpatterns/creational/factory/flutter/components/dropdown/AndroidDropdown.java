package lld.designpatterns.creational.factory.flutter.components.dropdown;

public class AndroidDropdown implements Dropdown{
    public AndroidDropdown(){
        System.out.println("Android dropdown created");
    }

    @Override public void selectDropdown() {
        System.out.println("Android dropdown selected");
    }
}
