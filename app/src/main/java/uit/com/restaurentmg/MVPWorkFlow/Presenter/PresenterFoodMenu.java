package uit.com.restaurentmg.MVPWorkFlow.Presenter;

import java.util.List;

import uit.com.restaurentmg.MVPWorkFlow.Model.entity.drink.Drink;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.food.Food;
import uit.com.restaurentmg.MVPWorkFlow.Model.interact.foodmenu.IFoodMenuFinishedListener;
import uit.com.restaurentmg.MVPWorkFlow.Model.interact.foodmenu.ModelFoodMenu;
import uit.com.restaurentmg.MVPWorkFlow.View.IViewFoodMenu;

public class PresenterFoodMenu implements IFoodMenuFinishedListener {

    IViewFoodMenu viewFoodMenu;
    ModelFoodMenu modelFoodMenu = new ModelFoodMenu(this);

    public PresenterFoodMenu(IViewFoodMenu viewFoodMenu) {
        this.viewFoodMenu = viewFoodMenu;
    }

    public void getFoods(){
        modelFoodMenu.getFoods();
    }

    public void getDrinks(){
        modelFoodMenu.getDrinks();
    }

    @Override
    public void onSuccessFood(List<Food> foodList) {
        viewFoodMenu.getFood(foodList);
    }

    @Override
    public void onSuccessDrink(List<Drink> drinkList) {
        viewFoodMenu.getDrink(drinkList);
    }

    @Override
    public void onFailFood() {
        viewFoodMenu.error();
    }

    @Override
    public void onFailDrink() {
        viewFoodMenu.error();
    }
}
