package lld.designpatterns.structural.decorator.datasource;

public abstract class BaseDecorator implements Datasource{
    protected Datasource nextLayer;

    public BaseDecorator(Datasource nextLayer) {
        this.nextLayer = nextLayer;
    }
}
