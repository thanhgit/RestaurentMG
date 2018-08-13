package uit.com.restaurentmg.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.liveo.searchliveo.SearchLiveo;
import butterknife.BindView;
import butterknife.ButterKnife;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.drink.Drink;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.food.Food;
import uit.com.restaurentmg.MVPWorkFlow.Presenter.PresenterFoodMenu;
import uit.com.restaurentmg.MVPWorkFlow.View.IViewFoodMenu;
import uit.com.restaurentmg.R;
import uit.com.restaurentmg.adapter.FoodMenuSearchRecycleViewAdapter;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.SearchObject;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.drink.DrinkBuilder;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.food.FoodBuilder;

public class SearchActivity extends AppCompatActivity implements SearchLiveo.OnSearchListener, IViewFoodMenu {
    @BindView(R.id.search_liveo)
    SearchLiveo mSearchLiveo;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.food_menu_search_recycleview)
    RecyclerView recyclerView;

    FoodMenuSearchRecycleViewAdapter adapterSearch;
    List<SearchObject> searchObjectList = new ArrayList<>();

    String control="";

    long table_id = -1;

    public long getTable_id() {
        return table_id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        if(getIntent()!=null) {
            Bundle bundle = getIntent().getBundleExtra("data");

            if (bundle.getString("option") != null) {

                control = bundle.getString("option");
            } else {
                control = "both";
            }

            if (bundle.getLong("table_id", -1) != -1) {
                table_id = bundle.getLong("table_id");
            }
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        configRecycleView();

        PresenterFoodMenu presenterFoodMenu = new PresenterFoodMenu(this);
        presenterFoodMenu.getFoods();
        presenterFoodMenu.getDrinks();

        adapterSearch = new FoodMenuSearchRecycleViewAdapter(getApplicationContext(),searchObjectList,table_id);
        recyclerView.setAdapter(adapterSearch);
        defaultSearch();
    }

    private void configRecycleView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration( new DividerItemDecoration(this,LinearLayoutManager.HORIZONTAL));
        recyclerView.setItemAnimator( new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void defaultSearch(){
        mSearchLiveo.with(this).build();
        mSearchLiveo.minToSearch(0);
        mSearchLiveo.searchDelay(1);
        mSearchLiveo.with(this).
                hideSearch(new SearchLiveo.OnHideSearchListener() {
                    @Override
                    public void hideSearch() {
                        //onBackPressed();
                        finish();
                    }
                }).
                build();

        mSearchLiveo.showVoice();
        MenuItem actionSearch = new MenuItem() {
            @Override
            public int getItemId() {
                return R.id.action_search;
            }

            @Override
            public int getGroupId() {
                return 0;
            }

            @Override
            public int getOrder() {
                return 0;
            }

            @Override
            public MenuItem setTitle(CharSequence title) {
                return null;
            }

            @Override
            public MenuItem setTitle(int title) {
                return null;
            }

            @Override
            public CharSequence getTitle() {
                return null;
            }

            @Override
            public MenuItem setTitleCondensed(CharSequence title) {
                return null;
            }

            @Override
            public CharSequence getTitleCondensed() {
                return null;
            }

            @Override
            public MenuItem setIcon(Drawable icon) {
                return null;
            }

            @Override
            public MenuItem setIcon(int iconRes) {
                return null;
            }

            @Override
            public Drawable getIcon() {
                return null;
            }

            @Override
            public MenuItem setIntent(Intent intent) {
                return null;
            }

            @Override
            public Intent getIntent() {
                return null;
            }

            @Override
            public MenuItem setShortcut(char numericChar, char alphaChar) {
                return null;
            }

            @Override
            public MenuItem setNumericShortcut(char numericChar) {
                return null;
            }

            @Override
            public char getNumericShortcut() {
                return 0;
            }

            @Override
            public MenuItem setAlphabeticShortcut(char alphaChar) {
                return null;
            }

            @Override
            public char getAlphabeticShortcut() {
                return 0;
            }

            @Override
            public MenuItem setCheckable(boolean checkable) {
                return null;
            }

            @Override
            public boolean isCheckable() {
                return false;
            }

            @Override
            public MenuItem setChecked(boolean checked) {
                return null;
            }

            @Override
            public boolean isChecked() {
                return false;
            }

            @Override
            public MenuItem setVisible(boolean visible) {
                return null;
            }

            @Override
            public boolean isVisible() {
                return false;
            }

            @Override
            public MenuItem setEnabled(boolean enabled) {
                return null;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public boolean hasSubMenu() {
                return false;
            }

            @Override
            public SubMenu getSubMenu() {
                return null;
            }

            @Override
            public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
                return null;
            }

            @Override
            public ContextMenu.ContextMenuInfo getMenuInfo() {
                return null;
            }

            @Override
            public void setShowAsAction(int actionEnum) {

            }

            @Override
            public MenuItem setShowAsActionFlags(int actionEnum) {
                return null;
            }

            @Override
            public MenuItem setActionView(View view) {
                return null;
            }

            @Override
            public MenuItem setActionView(int resId) {
                return null;
            }

            @Override
            public View getActionView() {
                return null;
            }

            @Override
            public MenuItem setActionProvider(ActionProvider actionProvider) {
                return null;
            }

            @Override
            public ActionProvider getActionProvider() {
                return null;
            }

            @Override
            public boolean expandActionView() {
                return false;
            }

            @Override
            public boolean collapseActionView() {
                return false;
            }

            @Override
            public boolean isActionViewExpanded() {
                return false;
            }

            @Override
            public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
                return null;
            }
        };
        onOptionsItemSelected(actionSearch);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (requestCode == SearchLiveo.REQUEST_CODE_SPEECH_INPUT) {

                mSearchLiveo.resultVoice(requestCode, resultCode, data);
            }
        }
    }


    @Override
    public void changedSearch(CharSequence charSequence) {
        if(adapterSearch != null){
            adapterSearch.search(charSequence);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_search, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                mSearchLiveo.show();
                break;
        }
        return true;
    }

    @Override
    public void getFood(List<Food> foods) {
        if(control.equals("both") || control.equals("food")) {
            searchObjectList.addAll(foods);
            adapterSearch.updateDataFood(foods);
            adapterSearch.notifyDataSetChanged();
        }
    }

    @Override
    public void getDrink(List<Drink> drinks) {
        if(control.equals("both") || control.equals("drink")) {
            searchObjectList.addAll(drinks);
            adapterSearch.updateDataDrink(drinks);
            adapterSearch.notifyDataSetChanged();
        }
    }

    @Override
    public void error() {

    }
}