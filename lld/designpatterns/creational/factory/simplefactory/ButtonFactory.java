package lld.designpatterns.creational.factory.simplefactory;

public class ButtonFactory {

    public static Button getButton(ButtonType type){
        switch (type){
            case DARK -> {
                return new DarkButton();
            }
            case LIGHT -> {
                return new LightButton();
            }
        }

        throw new RuntimeException("Select correct button type");
    }
}
