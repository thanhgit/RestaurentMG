package uit.com.restaurentmg.MVPWorkFlow.Model.interact.login;


import uit.com.restaurentmg.MVPWorkFlow.Model.entity.user.User;

/**
 * Created by Sinh on 3/20/2018.
 */

public interface ILoginFinishedListener {
    void onSuccess();
    void onFailed();
    void onError();
}
