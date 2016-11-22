package com.dadaabs.mhealth;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.dadaabs.mhealth.Fragments.GeneralHealth;
import com.dadaabs.mhealth.Fragments.HygeneTips;
import com.dadaabs.mhealth.Fragments.MotherCare;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final String[] TITLES = {"General Health", "Mother Care", "General Hygiene"};
    private final Resources resources;
    SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();


    //Constructor class
    public ViewPagerAdapter(final Resources resources, FragmentManager fm) {
        super(fm);
        this.resources = resources;
    }



    //get card fragment to display the cards(items) when different tabs are swipped
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return GeneralHealth.newInstance(position);

            case 1:

                //return RepatriationRootFrag.newInstance(position);
                return MotherCare.newInstance(position);

            case 2:
                return HygeneTips.newInstance(position);

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    /**
     * Remove the saved reference from our Map on the Fragment destroy
     *
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }


    /**
     * Get the Fragment by position
     *
     * @param position tab position of the fragment
     * @return
     */
    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }
}//End ClassPagerAdapter class