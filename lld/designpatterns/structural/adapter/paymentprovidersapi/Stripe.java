package lld.designpatterns.structural.adapter.paymentprovidersapi;

public class Stripe {

    public String debitAccount(Long accountId, Double amount){
        return "Strip Failed payment";
    }

    public String findStatus(Long paymentId){
        return "Stripe Success status";
    }

}
