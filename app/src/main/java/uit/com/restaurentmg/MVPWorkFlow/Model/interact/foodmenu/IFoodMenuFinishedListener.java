package uit.com.restaurentmg.MVPWorkFlow.Model.interact.foodmenu;

import java.util.List;

import uit.com.restaurentmg.MVPWorkFlow.Model.entity.drink.Drink;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.food.Food;

public interface IFoodMenuFinishedListener {
    void onSuccessFood(List<Food> foodList);
    void onSuccessDrink(List<Drink> drinkList);

    void onFailFood();
    void onFailDrink();
}
