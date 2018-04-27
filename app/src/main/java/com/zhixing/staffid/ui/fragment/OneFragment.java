package com.zhixing.staffid.ui.fragment;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhixing.staffid.R;
import com.zhixing.staffid.constants.NumberToMonth;
import com.zhixing.staffid.network.bean.IdList;
import com.zhixing.staffid.network.bean.OneList;
import com.zhixing.staffid.ui.MvpFragment;
import com.zhixing.staffid.ui.presenter.OnePresenter;
import com.zhixing.staffid.util.PermissionsActivity;
import com.zhixing.staffid.util.PermissionsChecker;
import com.zhixing.staffid.util.SystemUtil;
import com.zhixing.staffid.widget.SmallCornerView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * created by zhaobiying
 * on 2018/4/12
 */
public class OneFragment extends MvpFragment<OnePresenter> {

    private static final int REQUEST_CODE = 0; // 请求码

    // 所需的全部权限
    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.READ_PHONE_STATE
    };
    @Bind(R.id.dayTextView)
    TextView dayTextView;
    @Bind(R.id.cityAndWeather)
    TextView cityAndWeather;
    @Bind(R.id.one_toolbar)
    Toolbar oneToolbar;
    @Bind(R.id.monthAndYearTextView)
    SmallCornerView monthAndYearTextView;


    private PermissionsChecker mPermissionsChecker; // 权限检测器


    private String channel;
    private String version;
    private String uuid;
    private String platform = "android";

    private String oneListID;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPermissionsChecker = new PermissionsChecker(mvpActivity);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpActivity.setSupportActionBar(oneToolbar);
    }


    @Override
    public void onResume() {
        super.onResume();
        // 缺少权限时, 进入权限配置页面
        if (mPermissionsChecker.lacksPermissions(PERMISSIONS)) {
            startPermissionsActivity();
        }
        setSystemParameter();
        presenter.getIdList(channel, version, uuid, platform);
    }

    @OnClick(R.id.monthAndYearTextView)
    public void onViewClicked() {
        if(monthAndYearTextView.getOrientation()==0)
           monthAndYearTextView.setOrientation(1);
        else
            monthAndYearTextView.setOrientation(0);
    }

    private void startPermissionsActivity() {
        PermissionsActivity.startActivityForResult(mvpActivity, REQUEST_CODE, PERMISSIONS);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 拒绝时, 关闭页面, 缺少主要权限, 无法运行
        if (requestCode == REQUEST_CODE && resultCode == PermissionsActivity.PERMISSIONS_DENIED) {
            mvpActivity.finish();
        }
    }

    public void selectId(IdList idList) {
        oneListID = idList.getData().get(0);
        presenter.getOneList(oneListID, channel, version, uuid, platform);
    }

    public void showOneList(OneList oneList) {
        Date date = oneList.getData().getWeather().getDate();
        SimpleDateFormat ftDay = new SimpleDateFormat("dd");
        dayTextView.setText(ftDay.format(date));
        SimpleDateFormat ftMonth = new SimpleDateFormat("MM");
        SimpleDateFormat ftYear = new SimpleDateFormat("yyyy");
        monthAndYearTextView.setText(NumberToMonth.numberAndMonth.get(ftMonth.format(date)) + ftYear.format(date));
        cityAndWeather.setText(oneList.getData().getWeather().getCity_name() + "·" +
                oneList.getData().getWeather().getClimate() +
                oneList.getData().getWeather().getTemperature() + "℃");
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_one;
    }

    private void setSystemParameter() {
        String TAG = "系统参数：";
        channel = SystemUtil.getDeviceBrand().substring(4, 6);
        Log.e(TAG, "手机厂商：" + channel);
        version = SystemUtil.getSystemVersion();
        Log.e(TAG, "Android系统版本号：" + version);
        uuid = SystemUtil.getUUID(mvpActivity.getApplicationContext());
        Log.e(TAG, "手机uuid：" + uuid);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
