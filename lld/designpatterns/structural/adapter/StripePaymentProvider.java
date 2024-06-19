package lld.designpatterns.structural.adapter;

import lld.designpatterns.structural.adapter.paymentprovidersapi.Stripe;

public class StripePaymentProvider implements PaymentProvider {

    Stripe stripe = new Stripe();
    @Override
    public String makePayment(Long accountId, Double amount) {
        return stripe.debitAccount(accountId, amount);
    }

    @Override
    public String checkStatus(Long paymentId) {
        return stripe.findStatus(paymentId);
    }
}
