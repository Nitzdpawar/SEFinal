package com.example.nitin.sefinal;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
 * Created by Nitin on 11/28/2015.
 */
public class menu3_fragment extends Fragment {

    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.menu1_layout,container,false);
        return rootview;
    }
}
