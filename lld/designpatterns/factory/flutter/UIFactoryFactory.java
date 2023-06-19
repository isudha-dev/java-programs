package lld.designpatterns.factory.flutter;

public class UIFactoryFactory {

    public static UIFactory createUIFactory(SupportedPlatforms platform){
        UIFactory uiFactory = null;
        switch (platform) {
            case ANDROID -> uiFactory = new AndroidUIFactory();
            case IOS -> uiFactory = new IOSUIFactory();
        }
        return uiFactory;
    }

}
