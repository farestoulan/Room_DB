package com.example.roooom_db.EntntyClass;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roooom_db.DaoClass.Daoclass;

@Database(entities = {UserModel.class} ,version = 1)
public abstract class DatabaseClass extends RoomDatabase {
    public abstract Daoclass getDao();
    private static DatabaseClass instance;


    public static DatabaseClass getDatabase(final Context context){

        if (instance== null){
            synchronized (DatabaseClass.class){
                instance = Room.databaseBuilder(context , DatabaseClass.class , "DATABASE")
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return instance;
    }
}
