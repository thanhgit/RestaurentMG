package uit.com.restaurentmg.MVPWorkFlow.View;

import uit.com.restaurentmg.server.PaymentAPI.PaymenDataOutput;

public interface IViewPayment {
    void onSuccess(PaymenDataOutput paymenDataOutput);
}
