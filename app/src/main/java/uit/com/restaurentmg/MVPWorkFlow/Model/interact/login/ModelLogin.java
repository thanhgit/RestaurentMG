package uit.com.restaurentmg.MVPWorkFlow.Model.interact.login;



import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uit.com.restaurentmg.server.APIUtils;
import uit.com.restaurentmg.server.UserAPI.LoginOutput;
import uit.com.restaurentmg.server.UserAPI.UserClient;

/**
 * Created by Sinh on 3/20/2018.
 */

public class ModelLogin implements IModelLogin {
    public ILoginFinishedListener loginFinishedListener;

    public ModelLogin(ILoginFinishedListener loginFinishedListener){
        this.loginFinishedListener=loginFinishedListener;
    }
    @Override
    public void handleLogin(String userName, String password) {

        JsonObject object = new JsonObject();
        object.addProperty("userName", userName);
        object.addProperty("password", password);

        UserClient userClient = APIUtils.getUserClient();
        retrofit2.Call<LoginOutput> callback = userClient.login(object);
        callback.enqueue(new Callback<LoginOutput>() {
            @Override
            public void onResponse(Call<LoginOutput> call, Response<LoginOutput> response) {
                    if (response.body().getData().getState().booleanValue()) {
                        loginFinishedListener.onSuccess();
                    } else {
                        loginFinishedListener.onFailed();
                    }

            }

            @Override
            public void onFailure(Call<LoginOutput> call, Throwable t) {
                loginFinishedListener.onError();
            }
        });
    }


}
