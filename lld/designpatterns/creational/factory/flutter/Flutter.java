package lld.designpatterns.creational.factory.flutter;

public class Flutter {

    private SupportedPlatforms platform;

    public Flutter(SupportedPlatforms platform){
        this.platform = platform;
    }

    public void setTheme(){
        System.out.println("Setting theme");
    }

    public void refreshRate(){
        System.out.println("Setting refresh rate");
    }

    public UIFactory createUIFactory(){
        return UIFactoryFactory.createUIFactory(platform);
    }

}

//Assignment -> Booking type on a plane -> Business, Premium, Economy. Each have 3 sets of features, seattype, food menu and drinks menu
// depending on the booking type chosen, create the ticket object with internal 3 set of features.
