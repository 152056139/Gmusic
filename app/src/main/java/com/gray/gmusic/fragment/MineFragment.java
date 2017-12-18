package com.gray.gmusic.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.gray.gmusic.fragment.mine.MusicListActivity;
import com.gray.gmusic.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {

    public MineFragment() {
        // Required empty public constructor
    }

    private RelativeLayout relativeLayout_one_one;


    private void setupView(View view) {
        relativeLayout_one_one = (RelativeLayout) view.findViewById(R.id.rl_one_one);

    }

    private void setOnClickListenerOnIcon() {
        relativeLayout_one_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MusicListActivity.class));
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mine, container, false);

        setupView(view);
        setOnClickListenerOnIcon();

        // Inflate the layout for this fragment
        return view;
    }

}
