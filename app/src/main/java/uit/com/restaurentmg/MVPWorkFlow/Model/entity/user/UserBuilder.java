package uit.com.restaurentmg.MVPWorkFlow.Model.entity.user;

/**
 * Created by dell on 3/16/2018.
 */

public class UserBuilder implements IUser {
    private static IUser iUser;
    private static User user;

    public static IUser Init(){
        user=new User();
        iUser=new UserBuilder();
        return iUser;
    }


    @Override
    public IUser id(long id) {
        user.setId(id);
        return iUser;
    }

    @Override
    public IUser userName(String username) {
        user.setUserName(username);
        return iUser;
    }

    @Override
    public IUser password(String password) {
        user.setPassword(password);
        return iUser;
    }

    @Override
    public IUser email(String email) {
        user.setEmail(email);
        return iUser;
    }

    @Override
    public User Create() {
        return user;
    }
}
