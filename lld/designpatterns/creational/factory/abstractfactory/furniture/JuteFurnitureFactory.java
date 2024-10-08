package lld.designpatterns.creational.factory.abstractfactory.furniture;

import lld.designpatterns.creational.factory.abstractfactory.furniture.components.chair.Chair;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.chair.JuteChair;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.stool.JuteStool;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.stool.Stool;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.table.JuteTable;
import lld.designpatterns.creational.factory.abstractfactory.furniture.components.table.Table;

// concrete factory
public class JuteFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new JuteChair();
    }

    @Override
    public Stool createStool() {
        return new JuteStool();
    }

    @Override
    public Table createTable() {
        return new JuteTable();
    }
}
