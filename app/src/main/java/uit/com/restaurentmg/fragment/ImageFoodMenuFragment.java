package uit.com.restaurentmg.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import uit.com.restaurentmg.R;
import uit.com.restaurentmg.adapter.FoodMenuImageRecycleViewAdapter;

public class ImageFoodMenuFragment extends Fragment {

    public static ImageFoodMenuFragment newInstance() {

        Bundle args = new Bundle();

        ImageFoodMenuFragment fragment = new ImageFoodMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_menu_image,container,false);

        initView(view);


        List<Bitmap> bitmapList = new ArrayList<>();
        bitmapList.add(BitmapFactory.decodeResource(getResources(),R.drawable.menu_food_1));
        bitmapList.add(BitmapFactory.decodeResource(getResources(),R.drawable.menu_food_2));
        bitmapList.add(BitmapFactory.decodeResource(getResources(),R.drawable.menu_food_3));

        bitmapList.add(BitmapFactory.decodeResource(getResources(),R.drawable.menu_food_1));
        bitmapList.add(BitmapFactory.decodeResource(getResources(),R.drawable.menu_food_2));
        bitmapList.add(BitmapFactory.decodeResource(getResources(),R.drawable.menu_food_3));

        bitmapList.add(BitmapFactory.decodeResource(getResources(),R.drawable.menu_food_1));
        bitmapList.add(BitmapFactory.decodeResource(getResources(),R.drawable.menu_food_2));
        bitmapList.add(BitmapFactory.decodeResource(getResources(),R.drawable.menu_food_3));

        bitmapList.add(BitmapFactory.decodeResource(getResources(),R.drawable.menu_food_1));
        bitmapList.add(BitmapFactory.decodeResource(getResources(),R.drawable.menu_food_2));
        bitmapList.add(BitmapFactory.decodeResource(getResources(),R.drawable.menu_food_3));

        bitmapList.add(BitmapFactory.decodeResource(getResources(),R.drawable.menu_food_1));
        bitmapList.add(BitmapFactory.decodeResource(getResources(),R.drawable.menu_food_2));
        bitmapList.add(BitmapFactory.decodeResource(getResources(),R.drawable.menu_food_3));


        FoodMenuImageRecycleViewAdapter adapter = new FoodMenuImageRecycleViewAdapter(bitmapList, getActivity());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);




        return view;
    }

    private void initView(View view){
        recyclerView =(RecyclerView) view.findViewById(R.id.food_menu_image_recycleview);

    }

}
