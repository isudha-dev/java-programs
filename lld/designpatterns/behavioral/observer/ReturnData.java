package lld.designpatterns.behavioral.observer;

public class ReturnData {

    String data;

    public ReturnData(String data) {
        this.data = data;
        System.out.println(data);
    }

    public String getData() {
        return data;
    }
    public void setData(final String data) {
        this.data = data;
    }


}
