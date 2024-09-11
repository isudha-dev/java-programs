package lld.designpatterns.structural.decorator.datasource;

public interface Datasource {

    String read();

    void write(String value);
}
