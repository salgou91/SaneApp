package com.example.choits.saneapp.report;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.choits.saneapp.R;

/**
 * Created by choits on 2015. 11. 13..
 */
public class Fragment_C extends Fragment {
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    public static final Fragment_C newInstance(String message)
    {
        Fragment_C f = new Fragment_C();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        String message = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.rep3, container, false);

        return v;    }

}
