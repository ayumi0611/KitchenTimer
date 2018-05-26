package com.ayumitani.kitchentimer;

import javax.annotation.Nullable;

import io.realm.Realm;

public class RecipeModel {

    private Realm mRealm = Realm.getDefaultInstance();

    /**
     * レシピの新規作成もしくは編集の更新
     *
     * @param recipeId    　レシピのid
     * @param recipeName  　レシピの名前
     * @param cookingTime 　調理時間
     */
    public void copyOrUpdate(@Nullable Integer recipeId, String recipeName, String cookingTime) {
        if (recipeId == null) {
            recipeId = makeRecipeId();
        }
        Recipe recipe = new Recipe();
        recipe.setId(recipeId);
        recipe.setName(recipeName);
        recipe.setCookingTime(cookingTime);

        mRealm.beginTransaction();

        mRealm.copyToRealmOrUpdate(recipe);

        mRealm.commitTransaction();
    }


    /**
     * レシピの削除
     *
     * @param recipeId 　レシピのid
     */
    public void deleteRecipe(int recipeId) {
        mRealm.beginTransaction();

        // レシピの一覧から、recipeIdと一致するidのレシピの中で最初のものを取り出す
        Recipe recipe = mRealm.where(Recipe.class).equalTo("id", recipeId).findFirst();
        if (recipe != null) {
            recipe.deleteFromRealm();
        }

        mRealm.commitTransaction();
    }


    /**
     * レシピのidを作成
     *
     * @return レシピのid
     */
    private int makeRecipeId() {
        int recipeId = 1;

        //レシピの一覧から、idの最大値を取り出す
        Number maxRecipeId = mRealm.where(Recipe.class).max("id");

        if (maxRecipeId != null) {
            recipeId = maxRecipeId.intValue() + 1;
        }

        return recipeId;
    }


}
