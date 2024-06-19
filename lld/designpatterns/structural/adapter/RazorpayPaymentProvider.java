package lld.designpatterns.structural.adapter;

import lld.designpatterns.structural.adapter.paymentprovidersapi.Razorpay;

public class RazorpayPaymentProvider implements PaymentProvider{

    Razorpay razorpay = new Razorpay();
    @Override
    public String makePayment(Long accountId, Double amount) {
        return razorpay.makePayment(accountId, amount);
    }

    @Override
    public String checkStatus(Long paymentId) {
        return razorpay.checkStatus(paymentId);
    }
}
