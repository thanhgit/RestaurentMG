package uit.com.restaurentmg.MVPWorkFlow.Model.entity.drink;

public class DrinkBuilder implements IDrink {
    private static IDrink iDrink;
    private static Drink drink;

    public static IDrink build(){
        iDrink = new DrinkBuilder();
        drink = new Drink();
        return iDrink;
    }
    @Override
    public IDrink id(long id) {
        drink.setId(id);
        return iDrink;
    }

    @Override
    public IDrink name(String name) {
        drink.setName(name);
        return iDrink;
    }

    @Override
    public IDrink description(String description) {
        drink.setDescription(description);
        return iDrink;
    }

    @Override
    public IDrink imagePath(String imagePath) {
        drink.setImagePath(imagePath);
        return iDrink;
    }

    @Override
    public IDrink price(double price) {
        drink.setPrice(price);
        return iDrink;
    }

    @Override
    public Drink create() {
        return drink;
    }
}
