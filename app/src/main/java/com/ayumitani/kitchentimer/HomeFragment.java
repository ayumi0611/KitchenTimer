package com.ayumitani.kitchentimer;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.media.AudioAttributes;
import android.media.SoundPool;
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

public class HomeFragment extends Fragment {

    private SoundPool mSoundPool;
    private int mSoundId;

    NumberPicker mMinutePicker;
    NumberPicker mSecondPicker;

    TextView mRemainingTimeView;
    LinearLayout mTimePicker;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMinutePicker = view.findViewById(R.id.picker1);
        mSecondPicker = view.findViewById(R.id.picker2);

        mMinutePicker.setMaxValue(59);
        mMinutePicker.setMinValue(0);

        mSecondPicker.setMaxValue(59);
        mSecondPicker.setMinValue(0);

        mRemainingTimeView = view.findViewById(R.id.remaining_time_view);
        mTimePicker = view.findViewById(R.id.time_picker);

        // viewをidから取得する
        FloatingActionButton transitionRecipeListButton = view.findViewById(R.id.transition_recipe_list);
        // viewにOnClickListenerをセットする
        transitionRecipeListButton.setOnClickListener(new OnClickTransitionRecipeListListener());

        Button startButton = view.findViewById(R.id.button_start);
        startButton.setOnClickListener(new OnClickStartButton());

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ALARM)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        mSoundPool = new SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .setMaxStreams(1)
                .build();

        mSoundId = mSoundPool.load(this.getActivity(), R.raw.time_up, 1);

    }

    @Override
    public void onPause() {
        super.onPause();
        mSoundPool.unload(mSoundId);
        mSoundPool.release();
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
    

    private class OnClickStartButton implements View.OnClickListener {
        @SuppressLint("DefaultLocale")
        @Override
        public void onClick(View v) {
            int minuteTime = mMinutePicker.getValue();
            int secondTime = mSecondPicker.getValue() + 1;

            KitchenTimer countDownTimer = new KitchenTimer(minuteTime * 60 * 1000 + secondTime * 1000, 1000);

            mRemainingTimeView.setText(formatTime(minuteTime, secondTime));

            mRemainingTimeView.setText(formatTime(minuteTime, secondTime));

            mRemainingTimeView.setVisibility(View.VISIBLE);

            mTimePicker.setVisibility(View.GONE);

            countDownTimer.start();
        }
    }

    @SuppressLint("DefaultLocale")
    private String formatTime(int mm, int ss) {
        return String.format("%02d:%02d", mm, ss);
    }

    private class KitchenTimer extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        KitchenTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @SuppressLint("DefaultLocale")
        @Override
        public void onTick(long millisUntilFinished) {
            int minute = (int)(millisUntilFinished / 1000 / 60);
            int second = (int)(millisUntilFinished / 1000 % 60);

            mRemainingTimeView.setText(formatTime(minute, second));
        }

        @Override
        public void onFinish() {
            //音を鳴らす
            mSoundPool.play(mSoundId, 1.0f, 1.0f, 0, 0, 1);
            //残り時間を表示するViewを見えなくする
            mRemainingTimeView.setVisibility(View.GONE);
            //timePickerを表示する
            mTimePicker.setVisibility(View.VISIBLE);
        }


    }
}

