package uit.com.restaurentmg.MVPWorkFlow.Presenter;

import uit.com.restaurentmg.MVPWorkFlow.Model.interact.login.ILoginFinishedListener;
import uit.com.restaurentmg.MVPWorkFlow.Model.interact.login.IModelLogin;
import uit.com.restaurentmg.MVPWorkFlow.Model.interact.login.ModelLogin;
import uit.com.restaurentmg.MVPWorkFlow.View.IViewLogin;

/**
 * Created by Sinh on 3/20/2018.
 */

public class PresenterLogin implements ILoginFinishedListener {
    IViewLogin viewLogin;
    IModelLogin modelLogin;
    public PresenterLogin(IViewLogin viewLogin){
        this.viewLogin=viewLogin;
    }

    public void login(String userName, String password) {
        modelLogin=new ModelLogin(this);
        modelLogin.handleLogin(userName,password);
    }

    @Override
    public void onSuccess() {
        viewLogin.successfulLogin();
    }

    @Override
    public void onFailed() {
        viewLogin.failLogin();
    }

    @Override
    public void onError() {
        viewLogin.errorLogin();
    }

}
