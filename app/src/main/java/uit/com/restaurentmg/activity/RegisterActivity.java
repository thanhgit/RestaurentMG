package uit.com.restaurentmg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import uit.com.restaurentmg.MVPWorkFlow.Presenter.PresenterRegister;
import uit.com.restaurentmg.MVPWorkFlow.View.IViewRegister;
import uit.com.restaurentmg.R;

public class RegisterActivity extends AppCompatActivity implements IViewRegister{

    @BindView(R.id.register_btn)
    AppCompatButton register_btn;

    @BindView(R.id.sign_up_login)
    AppCompatTextView sign_up;


    @BindView(R.id.register_email)
    AppCompatEditText txt_email;
    @BindView(R.id.register_user_name)
    AppCompatEditText txt_user_name;
    @BindView(R.id.register_password)
    AppCompatEditText txt_password;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = txt_user_name.getText().toString();
                String pass = txt_password.getText().toString();
                String email = txt_email.getText().toString();

                PresenterRegister presenterRegister = new PresenterRegister(RegisterActivity.this);
                presenterRegister.register(email, userName,pass);
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return true;
    }

    @Override
    public void failRegisterSameUserNamem() {

    }

    @Override
    public void failRegisterSameEmail() {

    }

    @Override
    public void successfulRegister() {

        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();

    }

    @Override
    public void errorRegister() {

    }
}
