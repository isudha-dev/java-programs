package lld.designpatterns.structural.decorator.datasource;

import dsa.recursion.SimpleRec;

public class EncryptionDecorator extends BaseDecorator {
    public EncryptionDecorator(Datasource datasource){
        super(datasource);
    }
    @Override
    public String read() {
        String value = nextLayer.read();
        return decrypt(value);
    }

    public String decrypt(String value) {
        return value + " - Decrypted";
    }

    @Override
    public void write(String value) {
        String newValue = encrypt(value);
        nextLayer.write(newValue);
    }

    public String encrypt(String value) {
        return value + "- Encrypted";
    }
}
