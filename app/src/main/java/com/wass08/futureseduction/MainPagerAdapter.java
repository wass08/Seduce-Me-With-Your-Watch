package com.wass08.futureseduction;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.wass08.futureseduction.fragments.CustomFragment;
import com.wass08.futureseduction.fragments.SamplesFragment;
import com.wass08.futureseduction.fragments.TutorialFragment;

import java.util.ArrayList;

/**
 * Created by wassimsamad on 07/12/14.
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> fragments;

    public MainPagerAdapter(FragmentManager fm, Context c) {
        super(fm);
        fragments = new ArrayList<Fragment>();

        TutorialFragment tutorialFragment = new TutorialFragment();
        SamplesFragment samplesFragment = new SamplesFragment();
        CustomFragment customFragment = new CustomFragment();
        fragments.add(tutorialFragment);
        fragments.add(samplesFragment);
        fragments.add(customFragment);
    }
    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
