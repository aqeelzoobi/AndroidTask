package com.aqeel.interview.androidtask.datamodels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Drinks {

    @SerializedName("drinks")
    private ArrayList<Drink> drinks;

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }
}
