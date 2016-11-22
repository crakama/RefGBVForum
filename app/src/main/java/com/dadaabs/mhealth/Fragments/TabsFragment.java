package com.dadaabs.mhealth.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.dadaabs.mhealth.OnBackPressListener;
import com.dadaabs.mhealth.R;
import com.dadaabs.mhealth.ViewPagerAdapter;

public class TabsFragment extends RootFragment {
    protected ViewPager viewPager;
    private PagerSlidingTabStrip tabs;
    private ViewPagerAdapter viewPagerAdapter;
    private static final String ARG_POSITION = "position";
    private int position;

    private OnFragmentInteractionListener mListener;

    public TabsFragment() {
        // Required empty public constructor
    }

    public static TabsFragment newInstance(int position) {
        TabsFragment fragment = new TabsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION,position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_root_tabs, container, false);


        tabs = (PagerSlidingTabStrip) rootView.findViewById(R.id.tabs);
        viewPager = (ViewPager) rootView.findViewById(R.id.pager);


        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Note that we are passing childFragmentManager, not FragmentManager
        viewPagerAdapter = new ViewPagerAdapter(getResources(), getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        final int pageMargin = (int)
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4,
                        getResources().getDisplayMetrics());
        viewPager.setPageMargin(pageMargin);
        tabs.setViewPager(viewPager);
        tabs.setIndicatorColor(Color.parseColor("#2196F3"));

    }

    /**
     * Retrieve the currently visible Tab Fragment and propagate the onBackPressed callback
     *
     * @return true = if this fragment and/or one of its associates Fragment can handle the backPress
     */
    public boolean onBackPressed() {
        // currently visible tab Fragment
        OnBackPressListener currentFragment = (OnBackPressListener) viewPagerAdapter.getRegisteredFragment(viewPager.getCurrentItem());

        if (currentFragment != null) {
            // lets see if the currentFragment or any of its childFragment can handle onBackPressed
            return currentFragment.onBackPressed();
        }

        // this Fragment couldn't handle the onBackPressed call
        return false;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
