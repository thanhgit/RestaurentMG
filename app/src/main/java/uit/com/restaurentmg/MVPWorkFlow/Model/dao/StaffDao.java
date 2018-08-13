package uit.com.restaurentmg.MVPWorkFlow.Model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import uit.com.restaurentmg.MVPWorkFlow.Model.entity.staff.Staff;

/**
 * Created by thanh_uit on 21/03/2018.
 */

@Dao
public interface StaffDao {
    @Query("SELECT * FROM Staff")
    List<Staff> getAll();

    @Insert
    void insert(Staff staff);

    @Update
    void update(Staff staff);

    @Delete
    void delete(Staff... staff);
}
