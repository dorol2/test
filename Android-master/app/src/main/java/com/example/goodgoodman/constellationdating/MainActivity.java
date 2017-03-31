package com.example.goodgoodman.constellationdating;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    // 탭 및 페이저 속성 정의
    final int TAB_COUNT = 4;
    // 현재 페이지
    private int page_position = 0;
    // 페이지 이동경로를 저장하는 stack 변수
    Stack<Integer> pageStack = new Stack<>();
    boolean backPress = false;

    ImageView backGround;
    ViewPager viewPager;
    MainFragment main;
    ChatinglistFragment chatingList;
    UserProfileFragment userProfile;
    SettingFragment option;

    //탭 레이아웃 이미지 추가
    private int[] tabIcons = {
            R.drawable.main,
            R.drawable.list,
            R.drawable.talk,
            R.drawable.option};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = new MainFragment();
        chatingList = ChatinglistFragment.newInstance(1);
        userProfile = new UserProfileFragment();
        option = new SettingFragment();

        //글라이드를 이용한 배경
        backGround = (ImageView)findViewById(R.id.backGround);
        Glide.with(this).load(R.drawable.background).into(backGround);

        // - 탭 Layout 정의
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        // 탭 생성 및 타이틀 입력
        tabLayout.addTab( tabLayout.newTab().setIcon(R.drawable.main));
        tabLayout.addTab( tabLayout.newTab().setIcon(R.drawable.list));
        tabLayout.addTab( tabLayout.newTab().setIcon(R.drawable.talk));
        tabLayout.addTab( tabLayout.newTab().setIcon(R.drawable.option));
        tabLayout.bringToFront();

        //배경이미지 크기 조절
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(tabIcons[i]);
            tabLayout.getTabAt(i).setCustomView(imageView);
        }


        // - 프래그먼트 페이저 작성
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        // 아답터 생성
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        // 1. 페이저 리스너 : 페이저가 변경되었을때 탭을 바꿔주는 리스너
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // 2. 페이지의 변경사항을 체크한다.
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 뒤로가기를 누르지 않았을때만 stack 에 포지션을 더한다
                if(!backPress){
                    pageStack.push(page_position);
                    // 뒤로가기를 눌렀으면 false로 다시 세팅해준다.
                }else{
                    backPress = false;
                }
                page_position = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // 3. 탭 리스너 : 탭이 변경되었을 때 페이지를 바꿔저는 리스너
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

    }

    class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position){
                case 0: fragment = main; break;
                case 1: fragment = userProfile; break;
                case 2: fragment = chatingList; break;
                case 3: fragment = option; break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return TAB_COUNT;
        }
    }

    @Override
    public void onBackPressed() {
        goBackStack();
    }

    // stack 뒤로가기
    private void goBackStack(){
        // stack 의 사이즈가 0이면 앱을 종료
        if(pageStack.size() < 1){
            super.onBackPressed();
            // stack 에 position 값이 있으면
        }else {
            // View Pager 리스너에서 stack에 더해지는 것을 방지하기 위해 backpress 상태값을 미리 세팅
            backPress = true;
            // 페이지를 stack의 가장 마지막에 있는 위치값으로 이동
            viewPager.setCurrentItem(pageStack.pop());
        }
    }
}

