package lld.designpatterns.structural.adapter;

public interface PaymentProvider {

    String makePayment(Long accountId, Double amount);

    String checkStatus(Long paymentId);
}
