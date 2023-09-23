package com.example.myshoppingapp.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ShoppingListDao {

    @Query("select * from Category")
    List<Category> getAllCategoriesList();

    @Insert
    void insertCategory(Category...categories);

    @Update
    void updateCategory(Category category);

    @Delete
    void deleteCategory(Category category);

    @Query("select * from Items where categoryId = :catId") // for Items.class
    List<Items> getAllItemsList(int catId);

    @Insert
    void insertItems(Items...items);

    @Update
    void updateItems(Items items);

    @Delete
    void deleteItems(Items items);
}
