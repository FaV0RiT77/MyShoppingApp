package com.example.myshoppingapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.PopupMenu;

import java.util.ArrayList;
import java.util.Arrays;

public class MainMenu extends Activity {

    private LinearLayout lemonade;
    private LinearLayout sweets;
    private LinearLayout veges;
    private LinearLayout chems;
    private ListPopupWindow popupWindow;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        lemonade = findViewById(R.id.lemonade);
        sweets = findViewById(R.id.sweets);
        veges = findViewById(R.id.veges);
        chems = findViewById(R.id.chems);

        arrayList = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.sweets)));



        chems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v, arrayList);
            }
        });


    }

    public void showSweets(View v) {

    }



    public void showPopup(View v, ArrayList<String> list) {
        PopupMenu menu = new PopupMenu(this, v);
        for (String item : list) {
            menu.getMenu().add(item);
        }
        menu.show();

    }

//    public void showPopup(ArrayList<String> arrayList, LinearLayout anchor) {
//        popupWindow = new ListPopupWindow(this);
//        popupWindow.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrayList));
//        popupWindow.setAnchorView(anchor);
//        popupWindow.setHeight(400);
//        popupWindow.setModal(true);
//        anchor.post(new Runnable() {
//            @Override
//            public void run() {
//                popupWindow.setWidth(anchor.getMeasuredWidth());
//                popupWindow.setHeight(anchor.getMeasuredHeight());
//            }
//        });
//
//        anchor.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                popupWindow.show();
//            }
//        });
//    }
}
