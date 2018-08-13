package uit.com.restaurentmg.MVPWorkFlow.Model.entity.food;

import uit.com.restaurentmg.MVPWorkFlow.Model.entity.SearchObject;

public class Food implements SearchObject{

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String IMAGE_PATH = "imagePath";
    public static final String PRICE = "price";

    private long id;
    private String name;
    private String description;
    private String imagePath;
    private double price;

    public Food(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public long getSearchId() {
        return this.id;
    }

    @Override
    public String getSearchImagePath() {
        return this.imagePath;
    }

    @Override
    public String filterName() {
        return this.name;
    }

    @Override
    public double getSearchPrice() {
        return this.price;
    }

    @Override
    public String getType() {
        return "food";
    }
}
