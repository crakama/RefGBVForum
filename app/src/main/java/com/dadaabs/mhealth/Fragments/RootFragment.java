package com.dadaabs.mhealth.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dadaabs.mhealth.BackPressImpl;
import com.dadaabs.mhealth.OnBackPressListener;
import com.dadaabs.mhealth.R;

public class RootFragment extends Fragment implements OnBackPressListener {


    public RootFragment() {
        // Required empty public constructor
    }


    @Override
    public boolean onBackPressed() {
        return new BackPressImpl(this).onBackPressed();
    }

}
