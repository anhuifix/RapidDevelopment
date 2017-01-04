package com.rapid.rapiddevelopment.UI;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.rapid.rapiddevelopment.R;

public class UIActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
