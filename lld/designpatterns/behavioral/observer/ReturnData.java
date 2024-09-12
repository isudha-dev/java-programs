package lld.designpatterns.behavioral.observer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReturnData {

    String data;

    public ReturnData(String data) {
        this.data = data;
        System.out.println(data);
    }


}
