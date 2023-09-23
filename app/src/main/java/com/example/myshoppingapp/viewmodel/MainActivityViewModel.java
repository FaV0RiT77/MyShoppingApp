package com.example.myshoppingapp.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myshoppingapp.MainActivity;
import com.example.myshoppingapp.db.AppDB;
import com.example.myshoppingapp.db.Category;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<List<Category>> listOfCategory;
    private AppDB appDB;

    public MainActivityViewModel(Application application) {
        super(application);
        listOfCategory = new MutableLiveData<>();

        appDB = AppDB.getDBInstance(getApplication().getApplicationContext());
    }

    public MutableLiveData<List<Category>> getCategoryListObserver() {
        return listOfCategory;
    }

    public void getAllCategoryList() {
        List<Category> categoryList = appDB.shoppingListDao().getAllCategoriesList();
        if (categoryList.size() > 0) listOfCategory.postValue(categoryList);
        else listOfCategory.postValue(null);
    }

    public void insertCategory(String catName) {
        Category category = new Category();
        category.categoryName = catName;
        appDB.shoppingListDao().insertCategory(category);
        getAllCategoryList();
    }

    public void updateCategory(Category category) {
        appDB.shoppingListDao().updateCategory(category);
        getAllCategoryList();
    }

    public void deleteCategory(Category category) {
        appDB.shoppingListDao().deleteCategory(category);
        getAllCategoryList();
    }
}
