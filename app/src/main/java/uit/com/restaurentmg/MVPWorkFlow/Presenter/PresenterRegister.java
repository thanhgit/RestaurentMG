package uit.com.restaurentmg.MVPWorkFlow.Presenter;

import uit.com.restaurentmg.MVPWorkFlow.Model.interact.register.IModelRegister;
import uit.com.restaurentmg.MVPWorkFlow.Model.interact.register.IRegisterFinishListener;
import uit.com.restaurentmg.MVPWorkFlow.Model.interact.register.ModelRegister;
import uit.com.restaurentmg.MVPWorkFlow.View.IViewRegister;

public class PresenterRegister implements IRegisterFinishListener {
    IViewRegister viewRegister;
    IModelRegister modelRegister;

    public PresenterRegister(IViewRegister  viewRegister){
        this.viewRegister = viewRegister;
    }

    public void register(String email, String userName, String password){
        modelRegister = new ModelRegister(this);
        modelRegister.handleRegister(userName,password,email);
    }

    @Override
    public void onSuccess() {
        viewRegister.successfulRegister();
    }

    @Override
    public void onSameUserName() {
        viewRegister.failRegisterSameUserNamem();
    }

    @Override
    public void onSameEmail() {
        viewRegister.failRegisterSameEmail();
    }

    @Override
    public void onError() {
        viewRegister.errorRegister();
    }
}
