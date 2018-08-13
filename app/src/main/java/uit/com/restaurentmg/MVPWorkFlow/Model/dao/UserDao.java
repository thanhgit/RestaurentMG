package uit.com.restaurentmg.MVPWorkFlow.Model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import java.util.List;

import io.reactivex.Flowable;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.user.User;

/**
 * Created by dell on 3/16/2018.
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM " + User.TABLE_NAME)
    Flowable<List<User>> getUsers();

    @Query("SELECT * FROM "+User.TABLE_NAME+" WHERE "+User.USER_NAME+" = :username")
    Flowable<User> getUserByUsername(String username);

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("DELETE FROM "+User.TABLE_NAME)
    void deleteUsers();
}
