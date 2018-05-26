package com.ayumitani.kitchentimer;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Recipe extends RealmObject {

    @Required
    @PrimaryKey
    int id;
    @Required
    private String name;
    @Required
    private String cookingTime;


    public String getName() {
        return name;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void setId(int id) {
        this.id = id;
    }


}
