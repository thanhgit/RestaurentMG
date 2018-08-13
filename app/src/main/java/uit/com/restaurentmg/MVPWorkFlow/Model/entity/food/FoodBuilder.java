package uit.com.restaurentmg.MVPWorkFlow.Model.entity.food;

public class FoodBuilder implements IFood {
    
    private static IFood iFood;
    private static Food food;
    
    public static IFood build(){
        iFood = new FoodBuilder();
        food = new Food();
        return iFood;
    }
    @Override
    public IFood id(long id) {
        food.setId(id);
        return iFood;
    }

    @Override
    public IFood name(String name) {
        food.setName(name);
        return iFood;
    }

    @Override
    public IFood description(String description) {
        food.setDescription(description);
        return iFood;
    }

    @Override
    public IFood imagePath(String imagePath) {
        food.setImagePath(imagePath);
        return iFood;
    }

    @Override
    public IFood price(double price) {
        food.setPrice(price);
        return iFood;
    }

    @Override
    public Food create() {
        return food;
    }
}
