package uit.com.restaurentmg.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.drink.Drink;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.food.Food;
import uit.com.restaurentmg.R;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.SearchObject;
import uit.com.restaurentmg.activity.DrinkActivity;
import uit.com.restaurentmg.activity.FoodActivity;

public class FoodMenuSearchRecycleViewAdapter extends RecyclerView.Adapter<FoodMenuSearchRecycleViewAdapter.SearchHolder> {
    List<SearchObject> searchObjectList = new ArrayList<>();
    List<SearchObject> searchs = new ArrayList<>();
    Context context;
    long table_id = -1;

    public FoodMenuSearchRecycleViewAdapter(Context context,List<SearchObject> searchObjectList, long table_id) {
        this.searchObjectList = searchObjectList;
        this.searchs.addAll(searchObjectList);
        this.context = context;
        this.table_id = table_id;
    }

    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_meu_search, parent, false);



        return new SearchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchHolder holder, int position) {
        final SearchObject searchObject = searchObjectList.get(position);

        String path = searchObject.getSearchImagePath().replace("https","http");
        Glide.with(context).load(path).into(holder.image);
        holder.name.setText(searchObject.filterName());
        holder.price.setText(String.valueOf(searchObject.getSearchPrice()));

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                if(searchObject.getType()=="food") {
                    intent = new Intent(context, FoodActivity.class);
                }else{
                    intent = new Intent(context, DrinkActivity.class);
                }

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object",searchObject);
                bundle.putLong("table_id",table_id);
                intent.putExtra("data", bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return searchObjectList.size();
    }

    static class SearchHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.item_food_menu_search_name)
        AppCompatTextView name;
        @BindView(R.id.item_food_menu_search_image)
        ImageView image;
        @BindView(R.id.item_food_menu_search_price)
        AppCompatTextView price;
        @BindView(R.id.view)
        ConstraintLayout layout;
        public SearchHolder(View view){
            super(view);
            ButterKnife.bind(this,view);
        }
    }

    public void updateDataFood(List<Food> foods){
        this.searchs.addAll(foods);
    }

    public void updateDataDrink(List<Drink> drinks){
        this.searchs.addAll(drinks);
    }

    private static String removeAccent(String text) {
        String result = Normalizer.normalize(text, Normalizer.Form.NFD);
        return result.replaceAll("[^\\p{ASCII}]", "");
    }

    public void search(CharSequence charText){
        charText = removeAccent((String) charText).toLowerCase();
        Log.d(getClass().getName().toString(), "adapter: "+charText.toString() + "real: "+ searchObjectList.size()+"  tmp: "+searchs.size());

        searchObjectList.clear();
        if (charText.length() == 0) {
            searchObjectList.addAll(searchs);
        } else {
            for (SearchObject searchObject : searchs) {
                String name = removeAccent(searchObject.filterName());
                if (name.toLowerCase().contains(charText)) {
                    searchObjectList.add(searchObject);
                }
            }
        }

        notifyDataSetChanged();
    }
}
