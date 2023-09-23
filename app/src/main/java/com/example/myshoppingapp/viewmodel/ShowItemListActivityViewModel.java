package com.example.myshoppingapp.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myshoppingapp.db.AppDB;
import com.example.myshoppingapp.db.Items;

import java.util.List;

public class ShowItemListActivityViewModel extends AndroidViewModel {

    private MutableLiveData<List<Items>> listOfItems;
    private AppDB appDB;

    public ShowItemListActivityViewModel(Application application) {
        super(application);
        listOfItems = new MutableLiveData<>();

        appDB = AppDB.getDBInstance(getApplication().getApplicationContext());
    }

    public MutableLiveData<List<Items>> getItemsListObserver() {
        return listOfItems;
    }

    public void getAllItemsList(int categoryID) {
        List<Items> itemsList = appDB.shoppingListDao().getAllItemsList(categoryID);
        if (itemsList.size() > 0) listOfItems.postValue(itemsList);
        else listOfItems.postValue(null);
    }

    public void insertItems(Items item) {
        appDB.shoppingListDao().insertItems(item);
        getAllItemsList(item.categoryId);
    }

    public void updateItems(Items item) {
        appDB.shoppingListDao().updateItems(item);
        getAllItemsList(item.categoryId);
    }

    public void deleteItems(Items item) {
        appDB.shoppingListDao().deleteItems(item);
        getAllItemsList(item.categoryId);
    }
}
