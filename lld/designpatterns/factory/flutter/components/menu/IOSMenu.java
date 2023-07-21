package lld.designpatterns.factory.flutter.components.menu;

public class IOSMenu implements Menu{
    public IOSMenu(){
        System.out.println("IOS menu created");
    }

    @Override public void selectMenu() {
        System.out.println("IOS menu selected");
    }
}
