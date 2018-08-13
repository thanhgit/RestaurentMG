package uit.com.restaurentmg.MVPWorkFlow.Model.interact.register;

public interface IRegisterFinishListener {
    public void onSuccess();
    public void onSameUserName();
    public void onSameEmail();
    public void onError();
}
