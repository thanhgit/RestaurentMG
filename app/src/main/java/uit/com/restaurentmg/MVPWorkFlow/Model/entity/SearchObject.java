package uit.com.restaurentmg.MVPWorkFlow.Model.entity;

import java.io.Serializable;

public interface SearchObject extends Serializable {
    long getSearchId();
    String getSearchImagePath();
    String filterName();
    double getSearchPrice();
    String getType();
}
