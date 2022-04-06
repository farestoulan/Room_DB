 package com.example.roooom_db.DaoClass;

 import androidx.room.Dao;
 import androidx.room.Insert;
 import androidx.room.Query;

 import com.example.roooom_db.EntntyClass.UserModel;

 import java.util.List;


 @Dao
public interface Daoclass {

    @Insert
    void insartAllData(UserModel model);

    @Query("select * from user")
    List<UserModel> getAllData();
}
