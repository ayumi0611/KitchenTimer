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
import android.widget.TextView;
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

    // button_plusのOnClickListenerメソッド
    private class OnClickButtonPlus1 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            TextView textView = getView().findViewById(R.id.ten_minutes);
            String replaceTenMinutes = textView.getText().toString();
            int tenMinutes = Integer.parseInt(replaceTenMinutes);
            if (tenMinutes >= 9){
                tenMinutes = 0;
            } else {
                tenMinutes++;
            }
            replaceTenMinutes = Integer.toString(tenMinutes);
            textView.setText(replaceTenMinutes);
            }

        }

    private class OnClickButtonPlus2 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            TextView textView = getView().findViewById(R.id.one_minutes);
            String replaceOneMinutes= textView.getText().toString();
            int oneMinutes = Integer.parseInt(replaceOneMinutes);
            if (oneMinutes >= 9){
                oneMinutes = 0;
            } else {
                oneMinutes++;
            }
            replaceOneMinutes = Integer.toString(oneMinutes);
            textView.setText(replaceOneMinutes);
        }

    }

    private class OnClickButtonPlus3 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            TextView textView = getView().findViewById(R.id.ten_seconds);
            String replaceTenSeconds = textView.getText().toString();
            int tenSeconds = Integer.parseInt(replaceTenSeconds);
            if (tenSeconds >= 5){
                tenSeconds = 0;
            } else {
                tenSeconds++;
            }
            replaceTenSeconds = Integer.toString(tenSeconds);
            textView.setText(replaceTenSeconds);
        }

    }

    private class OnClickButtonPlus4 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            TextView textView = getView().findViewById(R.id.one_seconds);
            String replaceOneSeconds = textView.getText().toString();
            int oneSeconds = Integer.parseInt(replaceOneSeconds);
            if (oneSeconds >= 9){
                oneSeconds = 0;
            } else {
                oneSeconds++;
            }
            replaceOneSeconds = Integer.toString(oneSeconds);
            textView.setText(replaceOneSeconds);
        }
    }

    // button_minusのOnClickListenerメソッド
    private class OnClickButtonMinus1 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            TextView textView = getView().findViewById(R.id.ten_minutes);
            String replaceTenMinutes = textView.getText().toString();
            int tenMinutes = Integer.parseInt(replaceTenMinutes);
            if (tenMinutes <= 0){
                tenMinutes = 9;
            } else {
                tenMinutes--;
            }
            replaceTenMinutes = Integer.toString(tenMinutes);
            textView.setText(replaceTenMinutes);
        }
    }

    private class OnClickButtonMinus2 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            TextView textView = getView().findViewById(R.id.one_minutes);
            String replaceOneMinutes = textView.getText().toString();
            int oneMinutes = Integer.parseInt(replaceOneMinutes);
            if (oneMinutes <= 0){
                oneMinutes = 9;
            } else {
                oneMinutes--;
            }
            replaceOneMinutes = Integer.toString(oneMinutes);
            textView.setText(replaceOneMinutes);
        }
    }

    private class OnClickButtonMinus3 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            TextView textView = getView().findViewById(R.id.ten_seconds);
            String replaceTenSeconds = textView.getText().toString();
            int tenSeconds = Integer.parseInt(replaceTenSeconds);
            if (tenSeconds <= 0){
                tenSeconds = 5;
            } else {
                tenSeconds--;
            }
            replaceTenSeconds = Integer.toString(tenSeconds);
            textView.setText(replaceTenSeconds);
        }
    }

    private class OnClickButtonMinus4 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            TextView textView = getView().findViewById(R.id.one_seconds);
            String replaceOneSeconds = textView.getText().toString();
            int oneSeconds = Integer.parseInt(replaceOneSeconds);
            if (oneSeconds <= 0){
                oneSeconds = 9;
            } else {
                oneSeconds--;
            }
            replaceOneSeconds = Integer.toString(oneSeconds);
            textView.setText(replaceOneSeconds);
        }
    }
}
