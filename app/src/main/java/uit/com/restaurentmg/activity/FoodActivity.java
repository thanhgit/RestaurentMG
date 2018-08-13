package uit.com.restaurentmg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.SearchObject;
import uit.com.restaurentmg.R;

public class FoodActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.expandedImageFood)
    ImageView imageView;

    @BindView(R.id.add_food_btn)
    ImageButton add_btn;
    @BindView(R.id.subtract_food_btn)
    ImageButton subtract_btn;
    @BindView(R.id.amount_food)
    AppCompatTextView amount;
    @BindView(R.id.money_food)
    AppCompatTextView money;

    SearchObject searchObject;

    long table_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getBundleExtra("data");
        if(bundle!= null && bundle.getSerializable("object")!=null) {
            searchObject = (SearchObject) bundle.getSerializable("object");

            getSupportActionBar().setTitle(searchObject.filterName());
            String url = searchObject.getSearchImagePath().replace("https", "http");
            Glide.with(getApplicationContext()).load(url).into(imageView);
            money.setText(searchObject.getSearchPrice()+" VND");
        }

        if(bundle!= null && bundle.getLong("table_id",-1)!=-1){
            table_id = bundle.getLong("table_id");
            Log.d("table",table_id+"");
        }else{
            Intent intent = new Intent(getApplicationContext(), TableActivity.class);
            startActivity(intent);
            finish();
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money.setText(searchObject.getSearchPrice()+"");
                amount.setText("1");
                Snackbar.make(view, "Đã đặt món", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amountDrink = Integer.parseInt(amount.getText().toString())+1;
                double price =0;

                if(searchObject!=null){
                    price=searchObject.getSearchPrice();
                }

                price*=amountDrink;
                money.setText(price+" VND");
                amount.setText(amountDrink+"");
            }
        });

        subtract_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amountDrink = Integer.parseInt(amount.getText().toString())-1;
                if(amountDrink<1){
                    amount.setText("1");
                    double price =0;
                    if(searchObject!=null){
                        price = searchObject.getSearchPrice();
                    }

                    money.setText(price+" VND");
                }else {
                    double price = 0;
                    if(searchObject!=null){
                        price=searchObject.getSearchPrice();
                    }

                    price*=amountDrink;
                    money.setText(price+" VND");
                    amount.setText(amountDrink+"");
                }
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
}
