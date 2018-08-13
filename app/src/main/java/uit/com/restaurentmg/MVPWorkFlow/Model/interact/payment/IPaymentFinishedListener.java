package uit.com.restaurentmg.MVPWorkFlow.Model.interact.payment;


import uit.com.restaurentmg.server.PaymentAPI.PaymenDataOutput;

/**
 * Created by Sinh on 3/20/2018.
 */

public interface IPaymentFinishedListener {
    void onSuccess(PaymenDataOutput paymenDataOutput);
    void onFail();
}
