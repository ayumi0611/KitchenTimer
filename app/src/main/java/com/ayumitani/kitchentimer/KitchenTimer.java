package com.ayumitani.kitchentimer;

import android.os.CountDownTimer;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class KitchenTimer extends CountDownTimer {

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

    }

    @Override
    public void onFinish() {
        // 完了
    }


}

