package uit.com.restaurentmg.MVPWorkFlow.Model.interact.order;

import java.util.List;

import uit.com.restaurentmg.MVPWorkFlow.Model.entity.OrderObject;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.user.User;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.user.UserBuilder;

/**
 * Created by Sinh on 3/20/2018.
 */

public class ModelOrder implements IModelOrder {
    public IOrderFinishedListener orderFinishedListener;

    public ModelOrder(IOrderFinishedListener loginFinishedListener){
        this.orderFinishedListener=orderFinishedListener;
    }

    @Override
    public void handleOrder(List<OrderObject> orderObjects, long idTable) {
        orderFinishedListener.onSuccess(orderObjects,idTable);
    }

}
