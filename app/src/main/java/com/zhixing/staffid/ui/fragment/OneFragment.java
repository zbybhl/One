package com.zhixing.staffid.ui.fragment;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.zhixing.staffid.R;
import com.zhixing.staffid.constants.NumberToMonth;
import com.zhixing.staffid.network.bean.IdList;
import com.zhixing.staffid.network.bean.OneList;
import com.zhixing.staffid.network.callback.IdListCallback;
import com.zhixing.staffid.network.callback.OneListCallback;
import com.zhixing.staffid.ui.activity.MainActivity;
import com.zhixing.staffid.ui.presenter.OnePresenter;
import com.zhixing.staffid.util.PermissionsActivity;
import com.zhixing.staffid.util.PermissionsChecker;
import com.zhixing.staffid.util.SystemUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created by zhaobiying
 * on 2018/4/12
 */
public class OneFragment extends MvpFragment {

    private static final int REQUEST_CODE = 0; // 请求码

    // 所需的全部权限
    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.READ_PHONE_STATE
    };
    private PermissionsChecker mPermissionsChecker; // 权限检测器

    private View mRootView;
    private Toolbar toolbar;
    private TextView dayTextView;
    private TextView monthAndYearTextView;
    private TextView cityAndWeatherTextView;
    private OnePresenter onePresenter;

    private String channel;
    private String version;
    private String uuid ;
    private String platform = "android";

    private String oneListID;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpActivity = (MainActivity)getActivity();
        onePresenter = new OnePresenter(mvpActivity);
        mPermissionsChecker = new PermissionsChecker(mvpActivity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutRes = getFragmentLayout();
        initToolbar();
        mRootView = inflater.inflate(layoutRes, container, false);
        dayTextView = (TextView)mRootView.findViewById(R.id.dayTextView);
        monthAndYearTextView = (TextView)mRootView.findViewById(R.id.monthAndYearTextView);
        cityAndWeatherTextView = (TextView)mRootView.findViewById(R.id.cityAndWeather);
        return mRootView;
    }

    public Toolbar initToolbar() {
        toolbar = (Toolbar) mvpActivity.findViewById(R.id.one_toolbar);
        mvpActivity.setSupportActionBar(toolbar);
        return toolbar;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (presenter != null) {
            //注册Fragment
            presenter.setView(mvpActivity);
            presenter.registerEventBusListener(this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // 缺少权限时, 进入权限配置页面
        if (mPermissionsChecker.lacksPermissions(PERMISSIONS)) {
            startPermissionsActivity();
        }
        setSystemParameter();
        onePresenter.attachIdListCallback(idListCallback);
        onePresenter.getIdList(channel, version, uuid, platform);
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

    @Override
    public void onDestroy() {
        if (presenter != null) {
            //反注册Fragment
            presenter.unregisterEventBusListener(this);
            presenter.destroy();
        }
        mvpActivity=null;
        presenter = null;
        super.onDestroy();
    }

    private IdListCallback idListCallback = new IdListCallback() {
        @Override
        public void onSuccess(String msg) {

        }

        @Override
        public void onSuccess(IdList idList) {
            oneListID = idList.getData().get(0);
            onePresenter.attachOneListCallback(oneListCallback);
            onePresenter.getOneList(oneListID, channel, version, uuid, platform);
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

    private OneListCallback oneListCallback = new OneListCallback() {
        @Override
        public void onSuccess(String msg) {

        }

        @Override
        public void onSuccess(OneList oneList) {
            Date date = oneList.getData().getWeather().getDate();
            SimpleDateFormat ftDay = new SimpleDateFormat("dd");
            dayTextView.setText(ftDay.format(date));
            SimpleDateFormat ftMonth = new SimpleDateFormat("MM");
            SimpleDateFormat ftYear = new SimpleDateFormat("yyyy");
            monthAndYearTextView.setText(NumberToMonth.numberAndMonth.get(ftMonth.format(date)) + ftYear.format(date));
            cityAndWeatherTextView.setText(oneList.getData().getWeather().getCity_name() + "·" +
                                           oneList.getData().getWeather().getClimate() +
                                           oneList.getData().getWeather().getTemperature() + "℃");
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
}
