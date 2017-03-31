package com.example.goodgoodman.constellationdating;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserProfileFragment extends Fragment {

    ImageButton backBtn;
    ImageView constellation;
    //===================================스크롤뷰 test이미지
    ImageView imgView1,imgView2,imgView3,imgView4,imgView5;

    public UserProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_profile, container, false);

        backBtn = (ImageButton)v.findViewById(R.id.backBtn);
        constellation = (ImageView)v.findViewById(R.id.constellation);
        Glide.with(this).load(R.drawable.my_chart).into(constellation);


        //====================================스크롤뷰 test이미지
        imgView1 = (ImageView)v.findViewById(R.id.imgView1);
        imgView2 = (ImageView)v.findViewById(R.id.imgView2);
        imgView3 = (ImageView)v.findViewById(R.id.imgView3);
        imgView4 = (ImageView)v.findViewById(R.id.imgView4);
        imgView5 = (ImageView)v.findViewById(R.id.imgView5);
        Glide.with(this).load(R.drawable.test_one).into(imgView1);
        Glide.with(this).load(R.drawable.test_two).into(imgView2);
        Glide.with(this).load(R.drawable.test_three).into(imgView3);
        Glide.with(this).load(R.drawable.test_four).into(imgView4);
        Glide.with(this).load(R.drawable.test_five).into(imgView5);
        //=====================================================

        return v;
    }

}
