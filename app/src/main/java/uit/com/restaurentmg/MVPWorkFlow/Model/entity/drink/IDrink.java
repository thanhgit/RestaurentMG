package uit.com.restaurentmg.MVPWorkFlow.Model.entity.drink;

public interface IDrink {
    IDrink id(long id);
    IDrink name(String name);
    IDrink description(String description);
    IDrink imagePath(String imagePath);
    IDrink price(double price);
    Drink create();
}
