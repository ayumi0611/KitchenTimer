package com.ayumitani.kitchentimer;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

public class RecipeFragment extends Fragment {

    NumberPicker mMinutePicker;
    NumberPicker mSecondPicker;

    LinearLayout mTimePicker;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_recipe, container, false);
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

        mTimePicker = view.findViewById(R.id.time_picker);

        Button saveButton = view.findViewById(R.id.button_save);
        saveButton.setOnClickListener(new OnClickSaveButton());

    }

    private class OnClickSaveButton implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }

    }

}
