package uit.com.restaurentmg.MVPWorkFlow.Model.interact.order;

import java.util.List;

import uit.com.restaurentmg.MVPWorkFlow.Model.entity.OrderObject;

/**
 * Created by Sinh on 3/20/2018.
 */

public interface IModelOrder
{
    void handleOrder(List<OrderObject> orderObjects, long idTable);
}
