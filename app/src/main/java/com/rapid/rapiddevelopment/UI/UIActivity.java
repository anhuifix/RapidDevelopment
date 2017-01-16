package com.rapid.rapiddevelopment.UI;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.rapid.rapiddevelopment.R;
import com.rapid.rapiddevelopment.UI.base.BaseActivity;
import com.rapid.rapiddevelopment.UI.home.view.NoScrollViewPager;
import com.rapid.rapiddevelopment.adapter.UiPagerAdapter;

import butterknife.Bind;


public class UIActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @Bind(R.id.viewPager)
    public NoScrollViewPager noViewPager = null;
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

    private UiPagerAdapter uiAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noViewPager.setCurrentItem(0);
        initView();
    }

    private void initView() {
        uiAdapter = new UiPagerAdapter(getSupportFragmentManager());
        noViewPager.setAdapter(uiAdapter);
        noViewPager.setCurrentItem(2);
        noViewPager.addOnPageChangeListener(this);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main_footbar_film:
                        noViewPager.setCurrentItem(PAGE_ONE);
                        break;
                    case R.id.main_footbar_cinema:
                        noViewPager.setCurrentItem(PAGE_TWO);
                        break;
                    case R.id.main_footbar_show:
                        noViewPager.setCurrentItem(PAGE_THREE);
                        break;
                    case R.id.main_footbar_discovery:
                        noViewPager.setCurrentItem(PAGE_FOUR);
                        break;
                    case R.id.main_footbar_mine:
                        noViewPager.setCurrentItem(PAGE_FIVE);
                        break;
                    default:
                        break;
                }
            }
        });
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (noViewPager.getCurrentItem()) {
                case PAGE_ONE:
                    mRadioFilm.setChecked(true);
                    break;
                case PAGE_TWO:
                    mRadioCinema.setChecked(true);
                    break;
                case PAGE_THREE:
                    mRadioShow.setChecked(true);
                    break;
                case PAGE_FOUR:
                    mRadioDiscovery.setChecked(true);
                    break;
                case PAGE_FIVE:
                    mRadioDiscovery.setChecked(true);
                    break;
            }
        }
    }
}

