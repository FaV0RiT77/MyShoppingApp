package com.example.myshoppingapp.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Category.class, Items.class}, version = 1)
public abstract class AppDB extends RoomDatabase {

    public abstract ShoppingListDao shoppingListDao();
    public static AppDB instance;

    public static AppDB getDBInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDB.class, "AppDB")
                    .allowMainThreadQueries().build();
        }
        return instance;
    }
}
