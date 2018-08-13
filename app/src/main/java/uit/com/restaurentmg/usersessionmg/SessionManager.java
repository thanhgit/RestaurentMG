package uit.com.restaurentmg.usersessionmg;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import uit.com.restaurentmg.activity.HomeActivity;
import uit.com.restaurentmg.activity.LoginActivity;

public class SessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "ResaUserSessionMGPref";

    private static final String IS_LOGIN = "isLogin";
    private static final String USER_NAME = "userName";
    private static final String EMAIL = "email";

    public SessionManager(Context context){
        this.context = context;
        pref = this.context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String userName){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(USER_NAME, userName);
        editor.commit();
    }

    public HashMap<String,String> getUserDetails(){
        HashMap<String, String>  user = new HashMap<>();
        user.put(USER_NAME, pref.getString(USER_NAME, null));
        return user;
    }

    public void checkLogin(){
        if(!IsLogin()){
            Intent intent = new Intent(context, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public Boolean IsLogin(){
        return pref.getBoolean(IS_LOGIN,false);
    }

    public void logoutUser(){
        editor.clear();
        editor.commit();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
