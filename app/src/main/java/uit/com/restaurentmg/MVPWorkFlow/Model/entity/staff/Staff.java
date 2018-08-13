package uit.com.restaurentmg.MVPWorkFlow.Model.entity.staff;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanh_uit on 21/03/2018.
 */
@Entity
public class Staff implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private long staff_id;

    private String name;
    private int age;
    private String address;

//    public Staff() {
//
//    }

    public Staff(long staff_id, String name, int age, String address) {
        this.staff_id = staff_id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(long staff_id) {
        this.staff_id = staff_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static List<Staff> CreateStaffs(int amount) {
        List<Staff> staffs = new ArrayList<>();
        int index = 0;
        for (; index < amount; index++) {
            staffs.add(new Staff(System.currentTimeMillis(), "Nguyen VAn a" + index, index, "quan " + index));
        }

        return staffs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.staff_id);
        parcel.writeString(this.name);
        parcel.writeInt(this.age);
        parcel.writeString(this.address);
    }

    public Staff(Parcel parcel) {
        this.staff_id = parcel.readLong();
        this.name = parcel.readString();
        this.age = parcel.readInt();
        this.address = parcel.readString();
    }

    public static final Creator<Staff> CREATOR = new Creator<Staff>() {
        @Override
        public Staff createFromParcel(Parcel parcel) {
            return new Staff(parcel);
        }

        @Override
        public Staff[] newArray(int i) {
            return new Staff[i];
        }
    };

    public void update(Staff staff) {
        this.name = staff.getName();
        this.age = staff.getAge();
        this.address = staff.getAddress();
    }

}
