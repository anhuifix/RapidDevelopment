package com.rapid.rapiddevelopment.UI.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rapid.rapiddevelopment.R;
import com.rapid.rapiddevelopment.UI.base.BaseFragment;

/**
 * 发现
 * Created by anhui on 2017-1-10.
 */

public class DiscoveryFragment extends BaseFragment {

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discovery, container);
    }
}
