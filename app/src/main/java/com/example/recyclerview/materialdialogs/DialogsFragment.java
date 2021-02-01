package com.example.recyclerview.materialdialogs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.recyclerview.R;
import com.example.recyclerview.oep.DiscussionActivity;
import com.example.recyclerview.oep.SetActivity;


/**
 * @author Xiaozh
 * @data 2021/1/21
 * @email xiaozihuan994@qq.com
 * @description .
 */
public class DialogsFragment extends Fragment implements View.OnClickListener {

    private Button mBtn1, mBtn2, mBtn3, mBtn4, mBtn5, mBtn6, mBtn7, mBtn8;
    private int num = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_dialogs, container, false);
        mBtn1 = view.findViewById(R.id.btn_1);
        mBtn2 = view.findViewById(R.id.btn_2);
        mBtn3 = view.findViewById(R.id.btn_3);
        mBtn4 = view.findViewById(R.id.btn_4);
        mBtn5 = view.findViewById(R.id.btn_5);
        mBtn6 = view.findViewById(R.id.btn_6);
        mBtn7 = view.findViewById(R.id.btn_7);
        mBtn8 = view.findViewById(R.id.btn_8);

        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);
        mBtn5.setOnClickListener(this);
        mBtn6.setOnClickListener(this);
        mBtn7.setOnClickListener(this);
        mBtn8.setOnClickListener(this);

        return view;
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_1:
                mBtn1.setText("num: "+ num++);
//                MaterialDialog dialog = new MaterialDialog.Companion.Builder(getContext())
//                        .title("这是标题")
//                        .content("这是内容")
//                        .positiveText("同意")
//                        .negativeText("不同意")
//                        .neutralText("更多")
//                        .show();
//
                break;
//            case R.id.btn_2:
//                MaterialDialog.Builder builder1 = new MaterialDialog.Builder(getContext())
//                        .title("这是标题")
//                        .content("这是内容")
//                        .iconRes(R.drawable.icon_check)
//                        .positiveText("同意");
//                MaterialDialog dialog1 = builder1.build();
//                dialog1.show();
//                break;
//            case R.id.btn_3:
//                MaterialDialog dialog2 = new MaterialDialog.Builder(getContext())
//                        .title("这是标题")
//                        .content("这是内容")
//                        .positiveText("同意")
//                        .negativeText("不同意")
//                        .stackingBehavior(StackingBehavior.ADAPTIVE)
//                        .show();
//                break;
//            case R.id.btn_4:
//                MaterialDialog.Builder builder = new MaterialDialog.Builder(getContext())
//                        .title("这是标题")
//                        .content("这是内容")
//                        .positiveText("同意")
//                        .negativeText("不同意")
//                        .neutralText("更多")
//                        .onPositive((dialog14, which) -> {
//                            Toast.makeText(getContext(), "agree", Toast.LENGTH_SHORT).show();
//                            dialog14.dismiss();
//                        })
//                        .onNegative((dialog14, which) -> {
//                            Toast.makeText(getContext(), "disagree", Toast.LENGTH_SHORT).show();
//                            dialog14.dismiss();
//                        })
//                        .onNeutral((dialog14, which) -> {
//                            Toast.makeText(getContext(), "more", Toast.LENGTH_SHORT).show();
//                            dialog14.dismiss();
//                        })
//                        .onAny((dialog14, which) -> {
//                            Toast.makeText(getContext(), "nothing", Toast.LENGTH_SHORT).show();
//                            dialog14.dismiss();
//                        });
//                MaterialDialog dialog14 = builder.build();
//                dialog14.show();
//                break;
            case R.id.btn_5://设置页面
                Intent intent = new Intent(getContext(), SetActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_6:
                Intent intent1 = new Intent(getContext(), DiscussionActivity.class);
                startActivity(intent1);

                break;
            case R.id.btn_7:

                break;
            case R.id.btn_8:

                break;
        }
    }
}
