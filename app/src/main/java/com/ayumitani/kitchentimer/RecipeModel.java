package com.ayumitani.kitchentimer;

import io.realm.Realm;

public class RecipeModel {

    private Realm mRealm = Realm.getDefaultInstance();

    public Recipe createRecipe(String recipeName, String cookingTime) {
        mRealm.beginTransaction();
        Recipe recipe = mRealm.createObject(Recipe.class, makeRecipeId());
        recipe.setRecipe(recipeName);
        recipe.setTime(cookingTime);
        mRealm.commitTransaction();
        return recipe;
    }

    private int makeRecipeId(){
        int recipeId = 1;

        Number maxRecipeId = mRealm.where(Recipe.class).max("id");

        if (maxRecipeId != null){
            recipeId = maxRecipeId.intValue() + 1;
        }

        return recipeId;
    }

}
