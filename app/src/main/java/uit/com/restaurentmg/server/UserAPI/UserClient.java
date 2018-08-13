package uit.com.restaurentmg.server.UserAPI;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserClient {

    @POST("/resa/api/v1/users/login")
    Call<LoginOutput> login(@Body JsonObject jsonObject);

    @POST("/resa/api/v1/users")
    Call<RegisterOutput> register(@Body JsonObject jsonObject);
}
