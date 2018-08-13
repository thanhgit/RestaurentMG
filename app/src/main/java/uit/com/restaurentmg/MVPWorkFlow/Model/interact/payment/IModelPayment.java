package uit.com.restaurentmg.MVPWorkFlow.Model.interact.payment;

import java.util.List;

import uit.com.restaurentmg.MVPWorkFlow.Model.entity.OrderObject;

/**
 * Created by Sinh on 3/20/2018.
 */

public interface IModelPayment
{
    void handlePayment(long table_id);
}
