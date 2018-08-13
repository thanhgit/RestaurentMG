package uit.com.restaurentmg.MVPWorkFlow.Model.entity.user;

/**
 * Created by dell on 3/16/2018.
 */

public interface IUser {
    IUser id(long id);
    IUser userName(String username);
    IUser password(String password);
    IUser email(String email);
    User Create();
}
