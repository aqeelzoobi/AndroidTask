package com.aqeel.interview.androidtask.datamodels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Drink implements Serializable {

    @SerializedName("idDrink")
    private int id;

    @SerializedName("strDrink")
    private String drinkName;

    @SerializedName("strDrinkAlternate")
    private String drinkAlt;

    @SerializedName("strTags")
    private String tags;

    @SerializedName("strVideo")
    private String video;

    @SerializedName("strCategory")
    private String drinkCategory;

    @SerializedName("strIBA")
    private String drinkIBA;



    @SerializedName("strAlcoholic")
    private String alcoholic;

    @SerializedName("strGlass")
    private String glass;

    @SerializedName("strInstructions")
    private String instructions;

    @SerializedName("strInstructionsES")
    private String instructionsES;

    @SerializedName("strInstructionsDE")
    private String instructionsDE;

    @SerializedName("strInstructionsIT")
    private String InstructionsIT;

    @SerializedName("strInstructionsFR")
    private String instructionsFR;

    @SerializedName("strDrinkThumb")
    private String drinkThumb;

    @SerializedName("strImageSource")
    private String ImageSource;

    public Drink() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDrinkAlt() {
        return drinkAlt;
    }

    public void setDrinkAlt(String drinkAlt) {
        this.drinkAlt = drinkAlt;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getDrinkCategory() {
        return drinkCategory;
    }

    public void setDrinkCategory(String drinkCategory) {
        this.drinkCategory = drinkCategory;
    }

    public String getDrinkIBA() {
        return drinkIBA;
    }

    public void setDrinkIBA(String drinkIBA) {
        this.drinkIBA = drinkIBA;
    }

    public String getAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(String alcoholic) {
        this.alcoholic = alcoholic;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getInstructionsES() {
        return instructionsES;
    }

    public void setInstructionsES(String instructionsES) {
        this.instructionsES = instructionsES;
    }

    public String getInstructionsDE() {
        return instructionsDE;
    }

    public void setInstructionsDE(String instructionsDE) {
        this.instructionsDE = instructionsDE;
    }

    public String getInstructionsIT() {
        return InstructionsIT;
    }

    public void setInstructionsIT(String instructionsIT) {
        InstructionsIT = instructionsIT;
    }

    public String getInstructionsFR() {
        return instructionsFR;
    }

    public void setInstructionsFR(String instructionsFR) {
        this.instructionsFR = instructionsFR;
    }

    public String getDrinkThumb() {
        return drinkThumb;
    }

    public void setDrinkThumb(String drinkThumb) {
        this.drinkThumb = drinkThumb;
    }

    public String getImageSource() {
        return ImageSource;
    }

    public void setImageSource(String imageSource) {
        ImageSource = imageSource;
    }
}
