package uit.com.restaurentmg.MVPWorkFlow.Model.entity.staff;

/**
 * Created by thanh_uit on 07/04/2018.
 */

public interface IStaff {
    IStaff Name(String name);
    IStaff Age(int age);
    IStaff Address(String address);
    Staff Create();
}
