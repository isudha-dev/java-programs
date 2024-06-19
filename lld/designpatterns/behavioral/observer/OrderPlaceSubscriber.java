package lld.designpatterns.behavioral.observer;

public interface OrderPlaceSubscriber {

    ReturnData orderPlacedEvent(); // action that needs to be performed once the order placed event is consumed

}
