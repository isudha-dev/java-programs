package test.lld.designpatterns.structural.adapter;

import lld.designpatterns.structural.adapter.PaymentProvider;
import lld.designpatterns.structural.adapter.RazorpayPaymentProvider;
import lld.designpatterns.structural.adapter.StripePaymentProvider;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentProviderTest {

    PaymentProvider pp;

    @Test
    public void checkPaymentProviderRazorPay(){
        pp = new RazorpayPaymentProvider();
        String paymentResp = pp.makePayment(1L, 100.0);
        String statusResp = pp.checkStatus(10L);

        assertEquals("Payment response should be correct", "Razorpay Success for payment", paymentResp);
        assertEquals("Status response should be correct", "Razorpay Failed status check", statusResp);

    }

    @Test
    public void checkPaymentProviderStripe(){
        pp = new StripePaymentProvider();
        String paymentResp = pp.makePayment(1L, 100.0);
        String statusResp = pp.checkStatus(10L);

        assertEquals("Payment response should be correct", "Strip Failed payment", paymentResp);
        assertEquals("Status response should be correct", "Stripe Success status", statusResp);

    }

}
