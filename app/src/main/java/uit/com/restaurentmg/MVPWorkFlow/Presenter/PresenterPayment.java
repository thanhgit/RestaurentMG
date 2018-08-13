package uit.com.restaurentmg.MVPWorkFlow.Presenter;


import uit.com.restaurentmg.MVPWorkFlow.Model.interact.payment.IModelPayment;
import uit.com.restaurentmg.MVPWorkFlow.Model.interact.payment.IPaymentFinishedListener;
import uit.com.restaurentmg.MVPWorkFlow.Model.interact.payment.ModelPayment;
import uit.com.restaurentmg.MVPWorkFlow.View.IViewPayment;
import uit.com.restaurentmg.server.PaymentAPI.PaymenDataOutput;

/**
 * Created by Sinh on 3/20/2018.
 */

public class PresenterPayment implements IPaymentFinishedListener {
    IViewPayment viewPayment;
    IModelPayment modelPayment;
    public PresenterPayment(IViewPayment viewPayment){
        this.viewPayment=viewPayment;
    }

    @Override
    public void onSuccess(PaymenDataOutput paymenDataOutput) {
        viewPayment.onSuccess(paymenDataOutput);
    }

    @Override
    public void onFail() {

    }

    public void Payment(long table_id) {
        modelPayment=new ModelPayment(this);
        modelPayment.handlePayment(table_id);
    }
}
