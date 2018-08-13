package uit.com.restaurentmg.MVPWorkFlow.Model.entity.food;

public interface IFood {
    IFood id(long id);
    IFood name(String name);
    IFood description(String description);
    IFood imagePath(String imagePath);
    IFood price(double price);
    Food create();
}
