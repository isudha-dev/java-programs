package lld.designpatterns.structural.decorator.datasource;

public class CompressionDecorator extends BaseDecorator{

    public CompressionDecorator(Datasource datasource) {
        super(datasource);
    }

    @Override
    public String read() {
        String value = nextLayer.read();
        return decompress(value);
    }

    public String decompress(String value) {
        return value + " - Decompressed";
    }

    @Override
    public void write(String value) {
        String newValue = compress(value);
        nextLayer.write(newValue);
    }

    public String compress(String value) {
        return value + "- Compressed";
    }
}
