package com.zhixing.staffid.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.zhixing.staffid.R;
import com.zhixing.staffid.network.bean.IdList;
import com.zhixing.staffid.network.callback.IdListCallback;
import com.zhixing.staffid.ui.BaseMvpActivity;
import com.zhixing.staffid.ui.presenter.MainPresenter;
import com.zhixing.staffid.ui.fragment.AllFragment;
import com.zhixing.staffid.ui.fragment.MeFragment;
import com.zhixing.staffid.ui.fragment.OneFragment;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseMvpActivity<MainPresenter> {
    private MainPresenter mainPresenter = new MainPresenter(this);
    private String channel = "mi";
    private String version = "4.0.2";
    private String uuid = "ffffffff-a90e-706a-63f7-ccf973aae5ee";
    private String platform = "android";


    @Bind(R.id.home_container)
    FrameLayout homeContainer;
    @Bind(R.id.bottom_tab_layout)
    BottomNavigationView bottomTabLayout;

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

        bottomTabLayout.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                onTabItemSelected(item.getItemId());
                return true;
            }
        });
    }

    private void onTabItemSelected(int id) {
        Fragment fragment = null;
        switch (id) {
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

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, fragment).commit();
        }
    }

    @Override
    public void showdata (String string){
        Toast.makeText(this, "查询全部数据==>" + string, Toast.LENGTH_SHORT).show();
    }

//    @OnClick(R.id.tx_test)
//    public void onViewClicked () {
//        mainPresenter.attachCallback(responseCallback); //先注册回调，再请求网络
//        mainPresenter.getIdList(channel, version, uuid, platform);
//    }

    private IdListCallback responseCallback = new IdListCallback() {
        @Override
        public void onSuccess(String msg) {

        }

        @Override
        public void onSuccess(IdList idList) {

        }

        @Override
        public void onFailure(String msg) {

        }

        @Override
        public void onError(String errorMsg) {

        }

        @Override
        public void onComplete() {

        }
    };

    @Override
    public void showLoading () {
        super.showLoading();
    }

    @Override
    public void hideLoading () {
        super.hideLoading();
    }


    @Override
    protected void onDestroy () {
        super.onDestroy();
        mainPresenter.destroy();
        presenter.destroy();
    }

}
