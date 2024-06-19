package lld.designpatterns.structural.adapter.paymentprovidersapi;

public class Razorpay {

    public String makePayment(Long accountId, Double amount) {
        return "Razorpay Success for payment";
    }

    public String checkStatus(Long paymentId){
        return "Razorpay Failed status check";
    }
}
