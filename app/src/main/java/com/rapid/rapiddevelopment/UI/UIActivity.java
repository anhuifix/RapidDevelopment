package com.rapid.rapiddevelopment.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.rapid.rapiddevelopment.R;
import com.rapid.rapiddevelopment.UI.base.BaseActivity;
import com.rapid.rapiddevelopment.UI.home.CinemaFragment;
import com.rapid.rapiddevelopment.UI.home.DiscoveryFragment;
import com.rapid.rapiddevelopment.UI.home.FilmFragment;
import com.rapid.rapiddevelopment.UI.home.MineFragment;
import com.rapid.rapiddevelopment.UI.home.ShowFragment;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;


public class UIActivity extends BaseActivity {

    @Bind(R.id.fragment_container)
    public FrameLayout fragment_container;
    @Bind(R.id.main_group)
    public RadioGroup mRadioGroup = null;
    @Bind(R.id.main_footbar_film)
    public RadioButton mRadioFilm = null;
    @Bind(R.id.main_footbar_cinema)
    public RadioButton mRadioCinema = null;
    @Bind(R.id.main_footbar_show)
    public RadioButton mRadioShow = null;
    @Bind(R.id.main_footbar_discovery)
    public RadioButton mRadioDiscovery = null;
    @Bind(R.id.main_footbar_mine)
    public RadioButton mRadioMine = null;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;
    public static final int PAGE_FIVE = 4;

    private static int currSel = 0;

    private Fragment mFilmFragment = new FilmFragment();
    private Fragment mcinemaFragment = new CinemaFragment();
    private Fragment mShowFragment = new ShowFragment();
    private Fragment mDiscoverFragment = new DiscoveryFragment();
    private Fragment mMineFragment = new MineFragment();
    private List<Fragment> fragmentList = Arrays.asList(mFilmFragment, mcinemaFragment, mShowFragment, mDiscoverFragment, mMineFragment);

    private FragmentManager fragmentManager;
    public static boolean isForeground = false;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        initFootBar();
    }

    @Override
    protected void onResume() {
        isForeground = true;
        super.onResume();
    }

    @Override
    protected void onPause() {
        isForeground = false;
        super.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragment = fragmentList.get(currSel);
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }

    }


    private void initFootBar() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main_footbar_film:
                        currSel = 0;
                        break;
                    case R.id.main_footbar_cinema:
                        currSel = 1;
                        break;
                    case R.id.main_footbar_show:
                        currSel = 2;
                        break;
                    case R.id.main_footbar_discovery:
                        currSel = 3;
                        break;
                    case R.id.main_footbar_mine:
                        currSel = 4;
                        break;
                }
                addFragmentToStack(currSel);
            }
        });
        addFragmentToStack(currSel);
    }

    private void addFragmentToStack(int cur) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentList.get(cur);
        if (!fragment.isAdded()) {
            fragmentTransaction.add(R.id.fragment_container, fragment);
        }
        for (int i = 0; i < fragmentList.size(); i++) {
            Fragment f = fragmentList.get(i);
            if (i == cur && f.isAdded()) {

                fragmentTransaction.show(f);

            } else if (f != null && f.isAdded() && f.isVisible()) {
                fragmentTransaction.hide(f);
            }
        }
        fragmentTransaction.commitAllowingStateLoss();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

