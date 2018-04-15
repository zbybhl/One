package com.zhixing.staffid.util;


import android.app.ProgressDialog;
import android.content.Context;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;


import com.zhixing.staffid.R;


/**
 * Created by zhaobiying
 * 2018/4/2.
 */

public final class WidgetUtil {

    private static final String TAG = "CommonUtils";


    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.dialog_progress);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }






}
