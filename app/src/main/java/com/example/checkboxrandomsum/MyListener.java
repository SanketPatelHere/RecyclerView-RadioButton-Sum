package com.example.checkboxrandomsum;

import android.view.View;

import java.util.ArrayList;

public interface MyListener {
    public void onClick(String position);
    public void onClick(String position, ArrayList<String> finalList);
    public void onClick(String position, int sum);
    public void onClick(View v, int position);
}
