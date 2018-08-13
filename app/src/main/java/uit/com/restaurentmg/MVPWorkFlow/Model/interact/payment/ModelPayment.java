package uit.com.restaurentmg.MVPWorkFlow.Model.interact.payment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uit.com.restaurentmg.server.APIUtils;
import uit.com.restaurentmg.server.PaymentAPI.PaymentClient;
import uit.com.restaurentmg.server.PaymentAPI.PaymentOutput;

/**
 * Created by Sinh on 3/20/2018.
 */

public class ModelPayment implements IModelPayment {
    public IPaymentFinishedListener paymentFinishedListener;

    public ModelPayment(IPaymentFinishedListener paymentFinishedListener){
        this.paymentFinishedListener=paymentFinishedListener;
    }

    @Override
    public void handlePayment(long table_id) {
        final PaymentClient paymentClient = APIUtils.getPaymentClient();
        retrofit2.Call<PaymentOutput> callback = paymentClient.getPayment(table_id);
        callback.enqueue(new Callback<PaymentOutput>() {
            @Override
            public void onResponse(Call<PaymentOutput> call, Response<PaymentOutput> response) {
                paymentFinishedListener.onSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Call<PaymentOutput> call, Throwable t) {
                paymentFinishedListener.onFail();
            }
        });
    }

}
