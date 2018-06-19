package com.ayumitani.kitchentimer;

import android.app.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

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


        NumberPicker numberPicker1 = view.findViewById(R.id.picker1);
        NumberPicker numberPicker2 = view.findViewById(R.id.picker2);

        numberPicker1.setMaxValue(59);
        numberPicker1.setMinValue(0);

        numberPicker2.setMaxValue(59);
        numberPicker2.setMinValue(0);

        final LinearLayout linearLayout = view.findViewById(R.id.time_picker);
        final TextView textView = view.findViewById(R.id.timer);


        // viewをidから取得する
        FloatingActionButton transitionRecipeListButton = view.findViewById(R.id.transition_recipe_list);
        // viewにOnClickListenerをセットする
        transitionRecipeListButton.setOnClickListener(new OnClickTransitionRecipeListListener());

        Button startButton = view.findViewById(R.id.button_start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);

            }
        });

        Button resetButton = view.findViewById(R.id.button_reset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.VISIBLE);
                textView.setVisibility(View.GONE);
            }
        });


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


    private void tick(){}

    private void finishTimer(){
        //v.playSoundEffect(SoundEffectConstants.CLICK);


    }

    private class KitchenTimer extends CountDownTimer {

        private SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss", Locale.JAPAN);

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public KitchenTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            tick();
        }

        @Override
        public void onFinish() {
            // 完了
        }


    }
}

