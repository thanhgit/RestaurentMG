package uit.com.restaurentmg.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.UserManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import uit.com.restaurentmg.MVPWorkFlow.Presenter.PresenterLogin;
import uit.com.restaurentmg.MVPWorkFlow.View.IViewLogin;
import uit.com.restaurentmg.R;
import uit.com.restaurentmg.usersessionmg.SessionManager;

public class LoginActivity extends AppCompatActivity implements IViewLogin{

    @BindView(R.id.login_btn)
    AppCompatButton btnLogin;
    @BindView(R.id.login_sign_up)
    AppCompatTextView tvSignUp;
    @BindView(R.id.login_forget_password)
    AppCompatTextView tvForgetPassword;

    @BindView(R.id.login_user_name)
    AppCompatEditText txtUserName;
    @BindView(R.id.login_password)
    AppCompatEditText txtPassword;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = txtUserName.getText().toString();
                String password = txtPassword.getText().toString();
                PresenterLogin presenterLogin = new PresenterLogin(LoginActivity.this);
                presenterLogin.login(userName,password);
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

        tvForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,ForgetPasswordActivity.class);
                startActivity(i);
                finish();
            }
        });

    }


    @Override
    public void failLogin() {
        Toast.makeText(this,"Fail",Toast.LENGTH_LONG).show();
    }

    @Override
    public void successfulLogin() {
        sessionManager = new SessionManager(getApplicationContext());
        sessionManager.createLoginSession(txtUserName.getText().toString());
        Intent i = new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void errorLogin() {
        Toast.makeText(getApplicationContext(),"Error network",Toast.LENGTH_LONG).show();
    }

}