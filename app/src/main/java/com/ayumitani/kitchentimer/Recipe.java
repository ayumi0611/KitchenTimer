package com.ayumitani.kitchentimer;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Recipe extends RealmObject {

    @Required
    @PrimaryKey
    int id;
    @Required
    private String recipe;
    @Required
    private String time;



    public String getRecipe() {
        return recipe;
    }

    public String getTime() {
        return time;
    }

    public int getId() {
        return id;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setId(int id) {
        this.id = id;
    }


}
