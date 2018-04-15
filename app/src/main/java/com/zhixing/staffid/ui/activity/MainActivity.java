package com.zhixing.staffid.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.zhixing.staffid.R;
import com.zhixing.staffid.ui.fragment.AllFragment;
import com.zhixing.staffid.ui.fragment.MeFragment;
import com.zhixing.staffid.ui.fragment.OneFragment;
import com.zhixing.staffid.ui.presenter.ResponsePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends MvpActivity {


    @Bind(R.id.home_container)
    FrameLayout homeContainer;
    @Bind(R.id.bottom_tab_layout)
    BottomNavigationView bottomTabLayout;

    ResponsePresenter presenter= new  ResponsePresenter(this);
    private Fragment mOneFragment = new OneFragment();
    private Fragment mAllFragment = new AllFragment();
    private Fragment mMeFragment = new MeFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        getSupportFragmentManager().beginTransaction().replace(R.id.home_container,mOneFragment).commit();

        bottomTabLayout.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                onTabItemSelected(item.getItemId());
                return true;
            }
        });

    }

    private void onTabItemSelected(int id){
        Fragment fragment = null;
        switch (id){
            case R.id.item_one:
                fragment = mOneFragment;
                break;
            case R.id.item_all:
                fragment = mAllFragment;
                break;

            case R.id.item_me:
                fragment = mMeFragment;
                break;

        }
        if(fragment!=null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container,fragment).commit();
        }
    }


    @Override
    public void showLoading() {
        super.showLoading();
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

}
