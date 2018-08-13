package uit.com.restaurentmg.MVPWorkFlow.View;


import io.reactivex.Flowable;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.user.User;

/**
 * Created by Sinh on 3/20/2018.
 */

public interface IViewLogin {
    void failLogin();
    void successfulLogin();
    void errorLogin();
}
