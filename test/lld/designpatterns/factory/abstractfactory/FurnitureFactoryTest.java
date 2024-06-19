package test.lld.designpatterns.factory.abstractfactory;

import lld.designpatterns.creational.factory.abstractfactory.furniture.FurnitureFactory;
import lld.designpatterns.creational.factory.abstractfactory.furniture.VictorianFurniture;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.chair.Chair;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.chair.VictorianChair;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.stool.Stool;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.stool.VictorianStool;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.table.Table;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.table.VictorianTable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FurnitureFactoryTest {

    private FurnitureFactory furnitureFactory;

    @Before
    public void setUp(){
        furnitureFactory = new VictorianFurniture();
    }

    @Test
    public void testVictorianFurniture(){
        Chair chair = furnitureFactory.createChair();
        Stool stool = furnitureFactory.createStool();
        Table table = furnitureFactory.createTable();

        assertTrue("Should get chair of type Victorian", chair instanceof VictorianChair);
        assertTrue("Should get stool of type Victorian", stool instanceof VictorianStool);
        assertTrue("Should get table of type Victorian", table instanceof VictorianTable);

    }
}
