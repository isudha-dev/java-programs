package lld.designpatterns.structural.decorator.datasource;

public class FileDatasource implements Datasource{
    @Override
    public String read() {
        return "Base";
    }

    @Override
    public void write(String value) {
        System.out.println(value);
    }
}
