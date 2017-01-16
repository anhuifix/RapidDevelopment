package com.rapid.rapiddevelopment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.rapid.rapiddevelopment.UI.UIActivity;
import com.rapid.rapiddevelopment.UI.home.CinemaFragment;
import com.rapid.rapiddevelopment.UI.home.DiscoveryFragment;
import com.rapid.rapiddevelopment.UI.home.FilmFragment;
import com.rapid.rapiddevelopment.UI.home.MineFragment;
import com.rapid.rapiddevelopment.UI.home.ShowFragment;

/**
 * Created by Jay on 2015/8/31 0031.
 */
public class UiPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 5;
    private FilmFragment mFilmFragment = null;
    private CinemaFragment mcinemaFragment = null;
    private ShowFragment mShowFragment = null;
    private DiscoveryFragment mDiscoverFragment = null;
    private MineFragment mMineFragment = null;


    public UiPagerAdapter(FragmentManager fm) {
        super(fm);
        mFilmFragment = new FilmFragment();
        mcinemaFragment = new CinemaFragment();
        mShowFragment = new ShowFragment();
        mDiscoverFragment = new DiscoveryFragment();
        mMineFragment = new MineFragment();
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case UIActivity.PAGE_ONE:
                fragment = mFilmFragment;
                break;
            case UIActivity.PAGE_TWO:
                fragment = mcinemaFragment;
                break;
            case UIActivity.PAGE_THREE:
                fragment = mShowFragment;
                break;
            case UIActivity.PAGE_FOUR:
                fragment = mDiscoverFragment;
                break;
            case UIActivity.PAGE_FIVE:
                fragment = mMineFragment;
                break;
        }
        return fragment;
    }


}

