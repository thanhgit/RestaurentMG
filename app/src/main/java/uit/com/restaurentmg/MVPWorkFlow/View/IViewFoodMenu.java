package uit.com.restaurentmg.MVPWorkFlow.View;

import java.util.List;

import uit.com.restaurentmg.MVPWorkFlow.Model.entity.drink.Drink;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.food.Food;

public interface IViewFoodMenu {
    void getFood(List<Food> foodList);
    void getDrink(List<Drink> drinkList);
    void error();
}
