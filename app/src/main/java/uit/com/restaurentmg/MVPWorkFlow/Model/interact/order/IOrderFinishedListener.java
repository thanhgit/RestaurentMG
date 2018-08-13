package uit.com.restaurentmg.MVPWorkFlow.Model.interact.order;


import java.util.List;

import uit.com.restaurentmg.MVPWorkFlow.Model.entity.OrderObject;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.user.User;

/**
 * Created by Sinh on 3/20/2018.
 */

public interface IOrderFinishedListener {
    void onSuccess(List<OrderObject> orderObjects, long idTable);
}
