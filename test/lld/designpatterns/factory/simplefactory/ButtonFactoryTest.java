package test.lld.designpatterns.factory.simplefactory;

import lld.designpatterns.creational.factory.simplefactory.Button;
import lld.designpatterns.creational.factory.simplefactory.ButtonFactory;
import lld.designpatterns.creational.factory.simplefactory.ButtonType;
import lld.designpatterns.creational.factory.simplefactory.DarkButton;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ButtonFactoryTest {

    @Test
    public void getCorrectButtonType(){
        Button darkbutton = ButtonFactory.getButton(ButtonType.DARK);
        darkbutton.click();
        assertTrue("Should return button of Dark type", darkbutton instanceof DarkButton);

    }

}
