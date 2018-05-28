package com.ayumitani.kitchentimer;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.Toast;

public class HomeFragment extends Fragment{

    Fragment mFragment = this;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //viewをidから取得する
        FloatingActionButton transitionRecipeListButton = view.findViewById(R.id.transition_recipe_list);
        // viewにOnClickListenerをセットする
        transitionRecipeListButton.setOnClickListener(new OnClickTransitionRecipeListListener());

    }

    // OnClickListenerを内包してる
    private class OnClickTransitionRecipeListListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            // 実際の処理を記述する
            getActivity().getFragmentManager().beginTransaction()
                    .hide(HomeFragment.this)
                    .add(R.id.fragment_container, new RecipeListFragment()).commit();
        }
    }
}
