package com.zhixing.staffid.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhixing.staffid.R;
import com.zhixing.staffid.adapter.OnedayAdapter;
import com.zhixing.staffid.ui.IBaseFragment;
import com.zhixing.staffid.ui.pojo.DayList;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * created by zhaobiying
 * on 2018/4/28
 */
public class DateListFragmnet extends IBaseFragment {


    private static DateListFragmnet instance;
    @Bind(R.id.reyc_selectdate)
    RecyclerView reycSelectdate;


    private List<DayList> dayLists;


    public static synchronized DateListFragmnet getInstance() {
        if (instance == null) {
            instance = new DateListFragmnet();
        }
        return instance;
    }

    public void setDayLists(List<DayList> dayLists) {
        this.dayLists = dayLists;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_selectdate;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        OnedayAdapter adapter = new OnedayAdapter(getParentFragment().getActivity(), dayLists);
        reycSelectdate.setAdapter(adapter);        //和gridview一样直接setAdapter
        reycSelectdate.setLayoutManager(new GridLayoutManager(getParentFragment().getActivity(), 2,LinearLayoutManager.VERTICAL,false)); //这里是设置为网格布局
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
