package uit.com.restaurentmg.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uit.com.restaurentmg.R;
import uit.com.restaurentmg.activity.ExpandDrinkActivity;
import uit.com.restaurentmg.activity.ExpandFoodActivity;
import uit.com.restaurentmg.activity.FoodMenuActivity;
import uit.com.restaurentmg.activity.SearchActivity;
import uit.com.restaurentmg.adapter.FoodMenuMenuDrinkRecycleViewAdapter;
import uit.com.restaurentmg.adapter.FoodMenuMenuFoodRecycleViewAdapter;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.drink.Drink;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.drink.DrinkBuilder;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.food.Food;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.food.FoodBuilder;

public class MenuFoodMenuFragment extends Fragment {

    public static MenuFoodMenuFragment newInstance() {

        Bundle args = new Bundle();

        MenuFoodMenuFragment fragment = new MenuFoodMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.food_menu_menu_food_recycleview)
    RecyclerView recyclerViewFood;
    List<Food> foodList = new ArrayList<>();

    @BindView(R.id.food_menu_menu_drink_recycleview)
    RecyclerView recyclerViewDrink;
    List<Drink> drinkList = new ArrayList<>();

    @BindView(R.id.food_menu_search)
    AppCompatEditText search;

    @BindView(R.id.food_menu_menu_drink_expand)
    AppCompatTextView drinkExpand;
    @BindView(R.id.food_menu_menu_food_expand)
    AppCompatTextView foodExpand;

    @BindView(R.id.food_menu_menu_food)
    LinearLayout food;
    @BindView(R.id.food_menu_menu_drink)
    LinearLayout drink;

    FoodMenuMenuFoodRecycleViewAdapter adapterFood;
    FoodMenuMenuDrinkRecycleViewAdapter adapterDrink;

    public MenuFoodMenuFragment(){
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_menu_menu, container, false);
        ButterKnife.bind(this,view);
        events();
        configRecycleview();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void configRecycleview() {
        adapterFood = new FoodMenuMenuFoodRecycleViewAdapter(getContext(),foodList);
        LinearLayoutManager layoutManagerFood = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL,false);

        recyclerViewFood.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));
        recyclerViewFood.setItemAnimator(new DefaultItemAnimator());
        recyclerViewFood.setLayoutManager(layoutManagerFood);
        recyclerViewFood.setAdapter(adapterFood);

        adapterDrink = new FoodMenuMenuDrinkRecycleViewAdapter(getContext(),drinkList);
        LinearLayoutManager layoutManagerDrink = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerViewDrink.addItemDecoration(new DividerItemDecoration(this.getContext(), LinearLayoutManager.HORIZONTAL));
        recyclerViewDrink.setLayoutManager(layoutManagerDrink);
        recyclerViewDrink.setAdapter(adapterDrink);
    }

    public void updateDBFood(List<Food> foodList){
        if(adapterFood!= null) {
            this.foodList.addAll(foodList);
            adapterFood.notifyDataSetChanged();
        }
    }

    public void updateDBDrink(List<Drink> drinkList){
        if(adapterDrink!=null) {
            this.drinkList.addAll(drinkList);
            adapterDrink.notifyDataSetChanged();
        }
    }

    private void events() {
        search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("option","both");
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });

        foodExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ExpandFoodActivity.class);
                startActivity(intent);
            }
        });

        drinkExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ExpandDrinkActivity.class);
                startActivity(intent);
            }
        });

        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SearchActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("option","drink");
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("option","food");
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });
    }

}
