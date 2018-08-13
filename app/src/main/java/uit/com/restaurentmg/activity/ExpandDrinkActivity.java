package uit.com.restaurentmg.activity;

import android.app.SearchManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.SearchObject;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.drink.Drink;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.food.Food;
import uit.com.restaurentmg.MVPWorkFlow.Presenter.PresenterFoodMenu;
import uit.com.restaurentmg.MVPWorkFlow.View.IViewFoodMenu;
import uit.com.restaurentmg.R;
import uit.com.restaurentmg.adapter.ExpandFoodViewPaperAdapter;
import uit.com.restaurentmg.fragment.ExpandDrinkAllFragment;
import uit.com.restaurentmg.fragment.ExpandDrinkFavoriteFragment;
import uit.com.restaurentmg.fragment.ExpandDrinkRecentFragment;
import uit.com.restaurentmg.fragment.ExpandFoodAllFragment;
import uit.com.restaurentmg.fragment.ExpandFoodFavoriteFragment;
import uit.com.restaurentmg.fragment.ExpandFoodRecentFragment;

public class ExpandDrinkActivity extends AppCompatActivity implements IViewFoodMenu{
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.expand_drink_tablayout)
    TabLayout tabLayout;
    @BindView(R.id.expand_drink_viewpaper)
    ViewPager viewPager;

    List<Drink> drinks = new ArrayList<>();

    ExpandDrinkFavoriteFragment favoriteFragment= new ExpandDrinkFavoriteFragment();
    ExpandDrinkAllFragment allFragment = new ExpandDrinkAllFragment();
    ExpandDrinkRecentFragment recentFragment = new ExpandDrinkRecentFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_drink);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ExpandFoodViewPaperAdapter adapter = new ExpandFoodViewPaperAdapter(getSupportFragmentManager());
        adapter.add(recentFragment, "Gần đây ");
        adapter.add(favoriteFragment, "Yêu thích");
        adapter.add(allFragment, "Tất cả ");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        PresenterFoodMenu presenterFoodMenu = new PresenterFoodMenu(this);
        presenterFoodMenu.getDrinks();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getApplicationContext(), "text: "+newText,Toast.LENGTH_LONG).show();
                return false;
            }
        });



        return true;
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
    public void getFood(List<Food> foodList) {

    }

    @Override
    public void getDrink(List<Drink> drinkList) {
        drinks.addAll(drinkList);
        allFragment.updateFood(drinkList);
        List<Drink> favorite = new ArrayList<>();
        favorite.add(drinkList.get(1));
        favorite.add(drinkList.get(3));
        favorite.add(drinkList.get(5));
        favoriteFragment.updateFood(drinkList);
        recentFragment.updateFood(drinkList);
    }

    @Override
    public void error() {

    }
}
