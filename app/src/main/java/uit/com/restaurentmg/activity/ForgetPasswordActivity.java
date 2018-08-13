package uit.com.restaurentmg.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import uit.com.restaurentmg.R;

public class ForgetPasswordActivity extends AppCompatActivity {
    @BindView(R.id.forget_password_btn)
    AppCompatButton forget_password_btn;

    @BindView(R.id.forget_password_email)
    AppCompatEditText email;

    @BindView(R.id.forget_password_login)
    AppCompatTextView tv_login;
    @BindView(R.id.forget_password_register)
    AppCompatTextView tv_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);

        forget_password_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ForgetPasswordActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ForgetPasswordActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
