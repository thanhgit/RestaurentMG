package uit.com.restaurentmg.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.SearchObject;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.drink.Drink;
import uit.com.restaurentmg.R;
import uit.com.restaurentmg.adapter.FoodMenuSearchRecycleViewAdapter;

public class ExpandDrinkAllFragment extends Fragment {

    public static ExpandDrinkAllFragment newInstance() {

        Bundle args = new Bundle();

        ExpandDrinkAllFragment fragment = new ExpandDrinkAllFragment();
        fragment.setArguments(args);
        return fragment;
    }
    List<SearchObject>  drinks = new ArrayList<>();
    @BindView(R.id.expand_drink_all)
    RecyclerView recyclerView;

    FoodMenuSearchRecycleViewAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_expand_drink_all, container, false);
        ButterKnife.bind(this,view);

        adapter = new FoodMenuSearchRecycleViewAdapter(getContext(),drinks, -1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.addItemDecoration( new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator( new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void updateFood(List<Drink> foodList){
        drinks.addAll(foodList);
        if(adapter!= null) {
            adapter.notifyDataSetChanged();
        }
    }
}
