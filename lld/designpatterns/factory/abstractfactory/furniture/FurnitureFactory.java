package lld.designpatterns.factory.abstractfactory.furniture;

import lld.designpatterns.factory.abstractfactory.furniture.components.chair.Chair;
import lld.designpatterns.factory.abstractfactory.furniture.components.stool.Stool;
import lld.designpatterns.factory.abstractfactory.furniture.components.table.Table;

// factory for family of furniture
public interface FurnitureFactory {
    Chair createChair();
    Stool createStool();
    Table createTable();
}
