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
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.food.Food;
import uit.com.restaurentmg.activity.FoodActivity;

public class FoodMenuMenuFoodRecycleViewAdapter extends RecyclerView.Adapter<FoodMenuMenuFoodRecycleViewAdapter.FoodHolder> {

    List<Food> foodList = new ArrayList<>();
    Context context;
    public FoodMenuMenuFoodRecycleViewAdapter(Context context,List<Food> foodList){
        super();
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_menu_menu_food, parent, false);


        return new FoodHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHolder holder, int position) {
        final Food food = foodList.get(position);
        String path = food.getImagePath().replace("https","http");
        Glide.with(context).load(path).into(holder.image);
        holder.title.setText(food.getName());
        holder.price.setText(String.valueOf(food.getPrice()));

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FoodActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object", food);
                intent.putExtra("data", bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class FoodHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.item_food_menu_menu_image)
        ImageView image;
        @BindView(R.id.item_food_menu_menu_title)
        AppCompatTextView title;
        @BindView(R.id.item_food_menu_menu_price)
        AppCompatTextView price;
        @BindView(R.id.item_menu_food)
        LinearLayout layout;
         public FoodHolder(View view){
             super(view);
             ButterKnife.bind(this,view);
         }
    }
}
