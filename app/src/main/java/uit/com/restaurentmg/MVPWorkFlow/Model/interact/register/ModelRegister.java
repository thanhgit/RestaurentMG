package uit.com.restaurentmg.MVPWorkFlow.Model.interact.register;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.user.User;
import uit.com.restaurentmg.server.APIUtils;
import uit.com.restaurentmg.server.UserAPI.RegisterOutput;
import uit.com.restaurentmg.server.UserAPI.UserClient;

public class ModelRegister implements IModelRegister {
    IRegisterFinishListener registerFinishListener;
    public ModelRegister(IRegisterFinishListener registerFinishListener){
        this.registerFinishListener=registerFinishListener;
    }
    @Override
    public void handleRegister(String userName, String password, String email) {
        JsonObject object = new JsonObject();
        object.addProperty(User.USER_NAME, userName);
        object.addProperty(User.PASSWORD, password);
        object.addProperty(User.EMAIL, email);

        UserClient userClient = APIUtils.getUserClient();
        retrofit2.Call<RegisterOutput> callback = userClient.register(object);
        callback.enqueue(new Callback<RegisterOutput>() {
            @Override
            public void onResponse(Call<RegisterOutput> call, Response<RegisterOutput> response) {
                if(response.body().getStatus() == 200){
                    if(response.body().getData().getMessage() == null){
                        registerFinishListener.onSuccess();
                    }else{
                        if (response.body().getData().getMessage().equals("Email đã tồn tại")){
                            registerFinishListener.onSameEmail();
                        }else{
                            registerFinishListener.onSameUserName();
                        }
                    }
                }else{

                }
            }

            @Override
            public void onFailure(Call<RegisterOutput> call, Throwable t) {
                registerFinishListener.onError();
            }
        });

    }
}
