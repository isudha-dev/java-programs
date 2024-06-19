package lld.designpatterns.creational.factory.abstractfactory.furniture;

import lld.designpatterns.creational.factory.abstractfactory.furniture.components.chair.Chair;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.chair.ModernChair;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.stool.ModernStool;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.stool.Stool;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.table.ModernTable;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.table.Table;

// concrete factory
public class ModernFurniture implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Stool createStool() {
        return new ModernStool();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
}
