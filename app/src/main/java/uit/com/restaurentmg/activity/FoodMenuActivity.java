package uit.com.restaurentmg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.drink.Drink;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.food.Food;
import uit.com.restaurentmg.MVPWorkFlow.Presenter.PresenterFoodMenu;
import uit.com.restaurentmg.MVPWorkFlow.View.IViewFoodMenu;
import uit.com.restaurentmg.R;
import uit.com.restaurentmg.ToolbarMenu;
import uit.com.restaurentmg.adapter.FoodMenuViewPaperAdapter;
import uit.com.restaurentmg.fragment.ImageFoodMenuFragment;
import uit.com.restaurentmg.fragment.MenuFoodMenuFragment;
import uit.com.restaurentmg.usersessionmg.SessionManager;

public class FoodMenuActivity extends AppCompatActivity implements ToolbarMenu.ToolBarMenuListener, IViewFoodMenu{
    @BindView(R.id.food_menu_viewpaper)
    ViewPager viewPager;

    SessionManager sessionManager;

    public List<Food> foods = new ArrayList<>();
    public List<Drink> drinks = new ArrayList<>();

    MenuFoodMenuFragment menuFoodMenuFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(getApplicationContext());

        menuFoodMenuFragment = new MenuFoodMenuFragment();

        final ToolbarMenu toolbarMenu = new ToolbarMenu(this);
        setSupportActionBar(toolbarMenu.getToolbar());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FoodMenuViewPaperAdapter adapter = new FoodMenuViewPaperAdapter(getSupportFragmentManager());
        adapter.add(ImageFoodMenuFragment.newInstance());
        adapter.add(menuFoodMenuFragment);

        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                toolbarMenu.setNumtab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        PresenterFoodMenu presenterFoodMenu = new PresenterFoodMenu(this);
        presenterFoodMenu.getFoods();
        presenterFoodMenu.getDrinks();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_logout:
                sessionManager.logoutUser();
                sessionManager.checkLogin();
                return true;
            case R.id.action_tutorial:
                Intent intent = new Intent(getApplicationContext(), TutorialActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_setting:
                Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(i);
                return true;
        }
        return true;
    }

    @Override
    public void LeftButton(View view) {
        viewPager.setCurrentItem(0, true);
    }

    @Override
    public void RightButton(View view) {
        viewPager.setCurrentItem(1, true);
    }

    @Override
    public void getFood(List<Food> foodList) {
        foods.addAll(foodList);
        menuFoodMenuFragment.updateDBFood(foods);
    }

    @Override
    public void getDrink(List<Drink> drinkList) {
        drinks.addAll(drinkList);
        menuFoodMenuFragment.updateDBDrink(drinks);
    }

    @Override
    public void error() {
        Toast.makeText(this,"Error network",Toast.LENGTH_LONG).show();
    }
}