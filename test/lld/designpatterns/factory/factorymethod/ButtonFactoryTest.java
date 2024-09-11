package test.lld.designpatterns.factory.factorymethod;

import lld.designpatterns.creational.factory.factorymethod.product.ButtonFactory;
import lld.designpatterns.creational.factory.factorymethod.product.DarkButtonFactory;
import lld.designpatterns.creational.factory.factorymethod.factory.Button;
import lld.designpatterns.creational.factory.factorymethod.factory.DarkButton;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ButtonFactoryTest {

    @Test
    public void getCorrectButtonFromFactory(){
        ButtonFactory factory = new DarkButtonFactory();
        Button darkbutton = factory.getButton();
        darkbutton.click();
        assertTrue("Should return button of Dark type", darkbutton instanceof DarkButton);

    }

}
