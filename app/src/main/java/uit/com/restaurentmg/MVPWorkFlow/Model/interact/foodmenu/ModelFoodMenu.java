package uit.com.restaurentmg.MVPWorkFlow.Model.interact.foodmenu;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.drink.Drink;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.drink.DrinkBuilder;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.food.Food;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.food.FoodBuilder;
import uit.com.restaurentmg.server.APIUtils;
import uit.com.restaurentmg.server.DrinkAPI.DrinkClient;
import uit.com.restaurentmg.server.DrinkAPI.DrinkDataOutput;
import uit.com.restaurentmg.server.DrinkAPI.DrinkOutput;
import uit.com.restaurentmg.server.FoodAPI.FoodClient;
import uit.com.restaurentmg.server.FoodAPI.FoodDataOutput;
import uit.com.restaurentmg.server.FoodAPI.FoodOutput;

public class ModelFoodMenu implements IModelFoodMenu {

    private IFoodMenuFinishedListener foodMenuFinishedListener;

    public ModelFoodMenu(IFoodMenuFinishedListener foodMenuFinishedListener) {
        this.foodMenuFinishedListener = foodMenuFinishedListener;
    }

    @Override
    public void getFoods() {
        FoodClient foodClient = APIUtils.getFoodClient();
        retrofit2.Call<FoodOutput> callback = foodClient.getFoods();
        callback.enqueue(new Callback<FoodOutput>() {
            @Override
            public void onResponse(Call<FoodOutput> call, Response<FoodOutput> response) {
                List<Food> foods = new ArrayList<>();
                for(FoodDataOutput dataOutput : response.body().getData()){
                    foods.add(FoodBuilder.build().id(dataOutput.getId())
                            .name(dataOutput.getName())
                            .imagePath(dataOutput.getImagePath())
                            .price(dataOutput.getPrice()).create());
                }

                foodMenuFinishedListener.onSuccessFood(foods);
            }

            @Override
            public void onFailure(Call<FoodOutput> call, Throwable t) {
                foodMenuFinishedListener.onFailFood();
            }
        });
    }

    @Override
    public void getDrinks() {
        DrinkClient drinkClient = APIUtils.getDrinkClient();
        retrofit2.Call<DrinkOutput> callback = drinkClient.getDrinks();
        callback.enqueue(new Callback<DrinkOutput>() {
            @Override
            public void onResponse(Call<DrinkOutput> call, Response<DrinkOutput> response) {
                List<Drink> drinks = new ArrayList<>();
                for(DrinkDataOutput dataOutput : response.body().getData()){
                    drinks.add(DrinkBuilder.build().id(dataOutput.getId())
                            .name(dataOutput.getName())
                            .imagePath(dataOutput.getImagePath())
                            .price(dataOutput.getPrice()).create());
                }

                foodMenuFinishedListener.onSuccessDrink(drinks);
            }

            @Override
            public void onFailure(Call<DrinkOutput> call, Throwable t) {
                foodMenuFinishedListener.onFailDrink();
            }
        });
    }
}
