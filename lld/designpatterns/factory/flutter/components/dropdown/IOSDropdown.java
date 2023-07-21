package lld.designpatterns.factory.flutter.components.dropdown;

public class IOSDropdown implements Dropdown{

    public IOSDropdown(){
        System.out.println("IOS dropdown created");
    }

    @Override public void selectDropdown() {
        System.out.println("IOS dropdown selected");
    }
}
