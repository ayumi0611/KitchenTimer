package com.ayumitani.kitchentimer;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.QuickContactBadge;
import android.widget.Toast;

public class HomeFragment extends Fragment {

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

        // viewをidから取得する
        FloatingActionButton transitionRecipeListButton = view.findViewById(R.id.transition_recipe_list);
        // viewにOnClickListenerをセットする
        transitionRecipeListButton.setOnClickListener(new OnClickTransitionRecipeListListener());

        // button_plusのviewをidから取得する
        ImageButton button_plus_1 = view.findViewById(R.id.button_plus_1);
        ImageButton button_plus_2 = view.findViewById(R.id.button_plus_2);
        ImageButton button_plus_3 = view.findViewById(R.id.button_plus_3);
        ImageButton button_plus_4 = view.findViewById(R.id.button_plus_4);

        // button_plusのviewにOnClickListenerをセットする
        button_plus_1.setOnClickListener(new OnClickButtonPlus1());
        button_plus_2.setOnClickListener(new OnClickButtonPlus2());
        button_plus_3.setOnClickListener(new OnClickButtonPlus3());
        button_plus_4.setOnClickListener(new OnClickButtonPlus4());

        // button_minusのviewをidから取得する
        ImageButton button_minus_1 = view.findViewById(R.id.button_minus_1);
        ImageButton button_minus_2 = view.findViewById(R.id.button_minus_2);
        ImageButton button_minus_3 = view.findViewById(R.id.button_minus_3);
        ImageButton button_minus_4 = view.findViewById(R.id.button_minus_4);

        //　button_minusのviewにOnClickListenerをセットする
        button_minus_1.setOnClickListener(new OnClickButtonMinus1());
        button_minus_2.setOnClickListener(new OnClickButtonMinus2());
        button_minus_3.setOnClickListener(new OnClickButtonMinus3());
        button_minus_4.setOnClickListener(new OnClickButtonMinus4());

    }

    // OnClickListenerを内包してる
    private class OnClickTransitionRecipeListListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // 実際の処理を記述する
            getActivity().getFragmentManager().beginTransaction()
                    .hide(HomeFragment.this)
                    .add(R.id.fragment_container, new RecipeListFragment()).commit();
        }
    }

}
