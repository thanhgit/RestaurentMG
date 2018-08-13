package uit.com.restaurentmg.server.PaymentAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PaymentClient {
    @GET("/resa/api/v1/tables/{id}/payment")
    Call<PaymentOutput> getPayment(@Path("id") long id);
}
