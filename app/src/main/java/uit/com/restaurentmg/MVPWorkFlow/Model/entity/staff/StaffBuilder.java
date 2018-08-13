package uit.com.restaurentmg.MVPWorkFlow.Model.entity.staff;

/**
 * Created by thanh_uit on 07/04/2018.
 */

public class StaffBuilder implements IStaff {
    private static IStaff iStaff;
    private static Staff staff;

    public static IStaff Init(){
        iStaff=new StaffBuilder();
        staff=new Staff(-1,"",0,"");
        return iStaff;
    }
    @Override
    public IStaff Name(String name) {
        staff.setName(name);
        return iStaff;
    }

    @Override
    public IStaff Age(int age) {
        staff.setAge(age);
        return iStaff;
    }

    @Override
    public IStaff Address(String address) {
        staff.setAddress(address);
        return iStaff;
    }

    @Override
    public Staff Create() {
        return staff;
    }
}
