package uit.com.restaurentmg.MVPWorkFlow.Model.interact.search;

import java.text.Normalizer;
import java.util.ArrayList;

import uit.com.restaurentmg.MVPWorkFlow.Model.entity.SearchObject;

public class ModelSearch implements IModelSearch {
    public ISearchFinishedListener searchFinishedListener;
    public ModelSearch(ISearchFinishedListener searchFinishedListener)
    {
        this.searchFinishedListener=searchFinishedListener;
    }
    private static String removeAccent(String text) {
        String result = Normalizer.normalize(text, Normalizer.Form.NFD);
        return result.replaceAll("[^\\p{ASCII}]", "");
    }
    @Override
    public void handleSearchByName(CharSequence charText, ArrayList<SearchObject> searchs) {
        charText = removeAccent((String) charText).toLowerCase();
        ArrayList<SearchObject> searchObjectListByName=new ArrayList<>();

        ArrayList<SearchObject> listDrink=new ArrayList<>();
        if (charText.length() == 0) {
            searchObjectListByName.addAll(searchs);
        } else {
            for (SearchObject searchObject : searchs) {
                String name = removeAccent(searchObject.filterName());
                if (name.toLowerCase().contains(charText)) {
                    searchObjectListByName.add(searchObject);
                }
            }
        }
        searchFinishedListener.onShowListAfterSearchingByName(searchObjectListByName);
    }

    @Override
    public void getListFood(ArrayList<SearchObject> searchObjects) {
        ArrayList<SearchObject> listFood=new ArrayList<>();
        for (SearchObject searchObject : searchObjects) {
            if (searchObject.getType()== "food") {
                listFood.add(searchObject);
            }
        }
        searchFinishedListener.onListFood(listFood);

    }

    @Override
    public void getListDrink(ArrayList<SearchObject> searchObjects) {
        ArrayList<SearchObject> listDrink=new ArrayList<>();
        for (SearchObject searchObject : searchObjects) {
            if (searchObject.getType()== "drink") {
                listDrink.add(searchObject);
            }
        }
        searchFinishedListener.onListDrink(listDrink);
    }
}
