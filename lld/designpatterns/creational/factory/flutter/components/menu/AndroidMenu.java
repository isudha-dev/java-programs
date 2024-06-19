package lld.designpatterns.creational.factory.flutter.components.menu;

public class AndroidMenu implements Menu{
    public AndroidMenu(){
        System.out.println("Android menu created");
    }
    @Override public void selectMenu() {
        System.out.println("Android menu selected");
    }
}
