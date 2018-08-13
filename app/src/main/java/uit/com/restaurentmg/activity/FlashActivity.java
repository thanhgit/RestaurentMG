package uit.com.restaurentmg.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;

import butterknife.BindView;
import butterknife.ButterKnife;
import uit.com.restaurentmg.R;
import uit.com.restaurentmg.usersessionmg.SessionManager;

public class FlashActivity extends AppCompatActivity {
    @BindView(R.id.circle_loading_view)
    public AnimatedCircleLoadingView loadingView;

    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(getApplicationContext());

        new WaitOperator().execute();
    }

    private class WaitOperator extends AsyncTask<Void, Integer, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loadingView.startDeterminate();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(50);
                    publishProgress(i+1);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int percent = values[0];
            loadingView.setPercent(percent);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            loadingView.stopOk();
            Intent intent = new Intent(FlashActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
