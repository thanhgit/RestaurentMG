package uit.com.restaurentmg.MVPWorkFlow.Model.interact.search;

import java.util.ArrayList;

import uit.com.restaurentmg.MVPWorkFlow.Model.entity.SearchObject;

public interface IModelSearch {
    void handleSearchByName(CharSequence charText, ArrayList<SearchObject> list);
    void getListFood(ArrayList<SearchObject> searchObjects);
    void getListDrink(ArrayList<SearchObject> searchObjects);
}
