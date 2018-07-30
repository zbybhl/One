package com.zhixing.staffid.ui.fragment;

import android.Manifest;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.zhixing.staffid.R;
import com.zhixing.staffid.app.StaffIDApplication;
import com.zhixing.staffid.constants.Constants;
import com.zhixing.staffid.constants.NumberToMonth;
import com.zhixing.staffid.dao.ContentDao;
import com.zhixing.staffid.entity.Content;
import com.zhixing.staffid.network.bean.IdList;
import com.zhixing.staffid.network.bean.OneList;
import com.zhixing.staffid.ui.MvpFragment;
import com.zhixing.staffid.ui.pojo.DayList;
import com.zhixing.staffid.ui.pojo.PhotographInfo;
import com.zhixing.staffid.ui.presenter.OnePresenter;
import com.zhixing.staffid.util.DateUtil;
import com.zhixing.staffid.util.PermissionsActivity;
import com.zhixing.staffid.util.PermissionsChecker;
import com.zhixing.staffid.util.SystemUtil;
import com.zhixing.staffid.widget.SmallCornerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * created by zhaobiying
 * on 2018/4/12
 */
public class OneFragment extends MvpFragment<OnePresenter> {

    private static final int REQUEST_CODE = 0; // 请求码
//
//    // 所需的全部权限
//    static final String[] PERMISSIONS = new String[]{
//            Manifest.permission.READ_PHONE_STATE
//    };
    @Bind(R.id.dayTextView)
    TextView dayTextView;
    @Bind(R.id.cityAndWeather)
    TextView cityAndWeather;
    @Bind(R.id.one_toolbar)
    Toolbar oneToolbar;
    @Bind(R.id.monthAndYearTextView)
    SmallCornerView monthAndYearTextView;
    @Bind(R.id.photographImageView)
    ImageView photographImageView;
    @Bind(R.id.pic_infoTextView)
    TextView pic_infoTextView;
    @Bind(R.id.contentTextView)
    TextView contentTextView;
    @Bind(R.id.words_infoTextView)
    TextView words_infoTextView;
    @Bind(R.id.main_ptfv)
    PullToRefreshScrollView pullToRefreshScrollView;
    @Bind(R.id.tv_thumnail_list)
    TextView tvThumnailList;
    @Bind(R.id.iv_archor)
    ImageView ivArchor;
    @Bind(R.id.llyt_thumnail_list)
    LinearLayout llytThumnailList;
    @Bind(R.id.llyt_thumnail_content)
    LinearLayout llytThumnailContent;

    private PermissionsChecker mPermissionsChecker; // 权限检测器


    private String oneListID;
    private IdList idList;
    private List<DayList> dayList = new ArrayList<>();
    private Boolean isBottomShow = true;
    private HideFooterCallBack footerCallback;
    private volatile Boolean isShow = false;
    private List<OneList.Data.Content_list> contentLists = new ArrayList<>();//TODO 应该先都先在数据库里

    private  Boolean isAddFragmnet=false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPermissionsChecker = new PermissionsChecker(mvpActivity);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpActivity.setSupportActionBar(oneToolbar);
        //上拉、下拉设定
        pullToRefreshScrollView.setMode(Mode.PULL_FROM_START);

        //上拉监听函数
        pullToRefreshScrollView.getRefreshableView().setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                //下滑,显示
                if (i1 - i3 < 0 && i1 <= 0 && !isBottomShow) {

                    footerCallback.show();
                    isBottomShow = true;


                }
                //上滑,隐藏
                else if (i1 - i3 > 0 && isBottomShow) {

                    footerCallback.hide();
                    isBottomShow = false;
                }
            }
        });
        pullToRefreshScrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                //执行刷新函数
                new GetDataTask().execute();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {

            }

        });

    }

    public void updateView(String id){
        this.oneListID=id;
        this.onResume();
    }

    @Override
    public void onResume() {
        super.onResume();
        monthAndYearTextView.setOrientation(0);
        dayList.clear();
        isShow = false;
        isBottomShow = true;
        idList=null;

//        // 缺少权限时, 进入权限配置页面
//        if (mPermissionsChecker.lacksPermissions(PERMISSIONS)) {
//            startPermissionsActivity();
//        }
        presenter.getIdList(StaffIDApplication.channel, StaffIDApplication.version, StaffIDApplication.uuid, StaffIDApplication.platform);

    }

    @OnClick(R.id.one_toolbar)
    public void onViewClicked() {
        FragmentTransaction transaction= getChildFragmentManager().beginTransaction();
        if(!isAddFragmnet) {
            transaction.add(R.id.fragment_select_date, DateListFragment.getInstance());
            isAddFragmnet=true;
        }
        if (monthAndYearTextView.getOrientation() == 0) {
            transaction.show(DateListFragment.getInstance());
            monthAndYearTextView.setOrientation(1);
            Collections.sort(dayList);
            DateListFragment.getInstance().setDayLists(dayList);
            footerCallback.hide();
        }
        else {
            monthAndYearTextView.setOrientation(0);
            transaction.hide(DateListFragment.getInstance());
            footerCallback.show();
        }
        transaction.commitAllowingStateLoss();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.llyt_thumnail_list)
    public void onThumnailClicked() {
        if (!isShow) {
            ivArchor.setImageResource(R.drawable.arrow_up_black_18);
            LayoutInflater inflater = getActivity().getLayoutInflater();
            for(int i=1;i<contentLists.size();i++){
                View view = inflater.inflate(R.layout.item_onelist_thumnail, null);
                TextView textTitle=(TextView)view.findViewById(R.id.tv_title);
                TextView textTitleContent=(TextView)view.findViewById(R.id.tv_title_content);
                textTitle.setText(Constants.titleList[Integer.parseInt(contentLists.get(i).getCategory())-1].toString());
                textTitleContent.setText(contentLists.get(i).getTitle());
                llytThumnailContent.addView(view);
                //TODO 复用view未写
            }
            isShow = true;
        } else {
            ivArchor.setImageResource(R.drawable.arrow_down_black_18);
            llytThumnailContent.removeAllViews();
            isShow = false;
        }
    }

    private class GetDataTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            try {
                Thread.sleep(2000);
                presenter.getIdList(StaffIDApplication.channel, StaffIDApplication.version, StaffIDApplication.uuid, StaffIDApplication.platform);
                return " ";
            } catch (InterruptedException e) {
                Log.e("msg", "GetDataTask:" + e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            pullToRefreshScrollView.setMode(Mode.PULL_FROM_START);
            pullToRefreshScrollView.onRefreshComplete();
            super.onPostExecute(s);
        }
    }
//    private void startPermissionsActivity() {
//        PermissionsActivity.startActivityForResult(mvpActivity, REQUEST_CODE, PERMISSIONS);
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 拒绝时, 关闭页面, 缺少主要权限, 无法运行
        if (requestCode == REQUEST_CODE && resultCode == PermissionsActivity.PERMISSIONS_DENIED) {
            mvpActivity.finish();
        }
    }

    /**
     * @param idList presenter返回的Idlist列表
     */
    public void selectId(IdList idList) {
        this.idList = idList;
        if(oneListID==null)
            oneListID = idList.getData().get(0);

        presenter.getOneList(oneListID, StaffIDApplication.channel, StaffIDApplication.version, StaffIDApplication.uuid, StaffIDApplication.platform);
        getOneList();
    }

    /**
     * @param oneList presenter返回的OneList列表
     */
    public void showOneList(OneList oneList) {
        //TODO 应该写到application做线程拉取
        contentLists=oneList.getData().getContent_list();
        Date date = DateUtil.StringToDate(oneList.getData().getDate());
        SimpleDateFormat ftDay = new SimpleDateFormat("dd");
        dayTextView.setText(ftDay.format(date));
        SimpleDateFormat ftMonth = new SimpleDateFormat("MM");
        SimpleDateFormat ftYear = new SimpleDateFormat("yyyy");

        monthAndYearTextView.setText(NumberToMonth.numberAndMonth.get(ftMonth.format(date)) + ftYear.format(date));
        cityAndWeather.setText(oneList.getData().getWeather().getCity_name() + "·" +
                oneList.getData().getWeather().getClimate() +
                oneList.getData().getWeather().getTemperature() + "℃");

        PhotographInfo photographInfo = new PhotographInfo();
        photographInfo.setId(contentLists.get(0).getId());
        photographInfo.setContent(contentLists.get(0).getShare_info().getContent());
        photographInfo.setPic_info(contentLists.get(0).getPic_info());
        photographInfo.setImg_url(contentLists.get(0).getImg_url());
        photographInfo.setWords_info(contentLists.get(0).getWords_info());

        Glide
                .with(mvpActivity)
                .load(photographInfo.getImg_url())
//                .placeholder(R.mipmap.ic_preloading)
                .crossFade()
                .into(photographImageView);

        pic_infoTextView.setText(" " + photographInfo.getPic_info());
        contentTextView.setText(photographInfo.getContent());
        words_infoTextView.setText(photographInfo.getWords_info());
        final ContentDao contentdao= StaffIDApplication.getDbInstance().getSession().getContentDao();
//
//        //TODO 存储contentlist到数据库，线程池中运行
//        Runnable saveContentlist= new Runnable(){
//            @Override
//            public void run() {
//                for(int i=0;i<contentLists.size();i++){
//                    Content content=new Content();
//                    content.setItem_id(contentLists.get(i).getItem_id());
//                    content.setCategory(Integer.parseInt(contentLists.get(i).getCategory()));
//                    content.setTitle(contentLists.get(i).getTitle());
//                    content.setImg_url(contentLists.get(i).getImg_url());
//                    content.setPic_info(contentLists.get(i).getPic_info());
//                    content.setWords_info(contentLists.get(i).getWords_info());
//                    content.setSubtitle(contentLists.get(i).getSubtitle());
//                    content.setPost_date(DateUtil.StringToDate(contentLists.get(i).getPost_date()));
////                    contentdao.insert(content);
//                }
//            }
//        };
//        ExecutorService fixThreadPool = Executors.newFixedThreadPool(2);
//        fixThreadPool.execute(saveContentlist);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_one;
    }



    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


    public void hideFooterCallBack(HideFooterCallBack hideFooterCallBack) {
        this.footerCallback = hideFooterCallBack;
    }

    /**
     * 获取所有的OneList列表,如果这块在之前加载好就好了
     */
    private void getOneList() {
        for (String id : idList.getData()) {
            presenter.getOneList(id, StaffIDApplication.channel, StaffIDApplication.version, StaffIDApplication.uuid, StaffIDApplication.platform, false); //这块如果是前面加载好的话就不用写这个重载了
        }
    }

    public void getDayList(OneList oneList) {
        DayList day = new DayList();
        day.setId(oneList.getData().getId());
        day.setDate(oneList.getData().getDate());
        day.setImg_url(oneList.getData().getContent_list().get(0).getImg_url());
        dayList.add(day);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public interface HideFooterCallBack {
        void hide();
        void show();

    }
}
