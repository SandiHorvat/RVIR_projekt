package com.rvir.projekt;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Lupusus on 15. 06. 2017.
 */

public class IskanjeFragment extends Fragment {

    ArrayList<Hrana> imageArry = new ArrayList<Hrana>();
    ContactImageAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.iskanje, container, false);


        return v;
    }
}
