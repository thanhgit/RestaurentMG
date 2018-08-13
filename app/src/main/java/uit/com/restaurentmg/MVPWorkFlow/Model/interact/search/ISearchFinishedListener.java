package uit.com.restaurentmg.MVPWorkFlow.Model.interact.search;

import java.util.ArrayList;

import uit.com.restaurentmg.MVPWorkFlow.Model.entity.SearchObject;

public interface ISearchFinishedListener {
    void onShowListAfterSearchingByName(ArrayList<SearchObject> searchs) ;
    void onListFood(ArrayList<SearchObject> searchObjects);
    void onListDrink(ArrayList<SearchObject> searchObjects);

}
