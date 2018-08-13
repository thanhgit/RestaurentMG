package uit.com.restaurentmg.MVPWorkFlow.View;

public interface IViewRegister {
    void failRegisterSameUserNamem();
    void failRegisterSameEmail();
    void successfulRegister();
    void errorRegister();
}
