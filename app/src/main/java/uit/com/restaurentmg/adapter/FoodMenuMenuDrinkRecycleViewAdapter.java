package uit.com.restaurentmg.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uit.com.restaurentmg.R;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.drink.Drink;
import uit.com.restaurentmg.activity.DrinkActivity;

public class FoodMenuMenuDrinkRecycleViewAdapter extends RecyclerView.Adapter<FoodMenuMenuDrinkRecycleViewAdapter.DrinkHolder> {

    List<Drink> drinkList = new ArrayList<>();
    Context context;
    public FoodMenuMenuDrinkRecycleViewAdapter(Context context,List<Drink> drinkList){
        super();
        this.drinkList = drinkList ;
        this.context = context;
    }

    @NonNull
    @Override
    public DrinkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_menu_menu_food, parent, false);


        return new DrinkHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkHolder holder, int position) {
        final Drink drink = drinkList.get(position);
        String path = drink.getImagePath().replace("https","http");
        Glide.with(context).load(path).into(holder.image);
        holder.title.setText(drink.getName());
        holder.price.setText(String.valueOf(drink.getPrice()));

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DrinkActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object", drink);
                intent.putExtra("data", bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }

    public class DrinkHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.item_food_menu_menu_image)
        ImageView image;
        @BindView(R.id.item_food_menu_menu_title)
        AppCompatTextView title;
        @BindView(R.id.item_food_menu_menu_price)
        AppCompatTextView price;
        @BindView(R.id.item_menu_food)
        LinearLayout layout;
        public DrinkHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}