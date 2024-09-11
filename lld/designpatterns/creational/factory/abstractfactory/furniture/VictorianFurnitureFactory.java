package lld.designpatterns.creational.factory.abstractfactory.furniture;

import lld.designpatterns.creational.factory.abstractfactory.furniture.components.chair.Chair;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.chair.ModernChair;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.chair.VictorianChair;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.stool.ModernStool;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.stool.Stool;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.stool.VictorianStool;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.table.ModernTable;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.table.Table;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.table.VictorianTable;

// concrete factory
public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Stool createStool() {
        return new VictorianStool();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }
}
