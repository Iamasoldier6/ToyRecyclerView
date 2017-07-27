package com.iamasoldier6.toyrecyclerview.decoration;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.iamasoldier6.toyrecyclerview.R;
import com.iamasoldier6.toyrecyclerview.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 */
public class DecorationActivity extends BaseActivity {

    @NonNull
    @Bind(R.id.btn_recycler_decoration_standard)
    Button mBtnRecyclerDecorationStandard;
    @NonNull
    @Bind(R.id.btn_recycler_decoration_overdraw)
    Button mBtnRecyclerDecorationOverdraw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoration);
    }

    @NonNull
    @OnClick(R.id.btn_recycler_decoration_standard)
    public void onStandardClicked() {
        startActivity(new Intent(this, StandardDecorationActivity.class));
    }

    @NonNull
    @OnClick(R.id.btn_recycler_decoration_overdraw)
    public void onOverdrawClicked() {
        startActivity(new Intent(this, OverdrawDecorationActivity.class));
    }

    @Override
    public void setupToolbar() {
        getSupportActionBar().setTitle(getString(R.string.toy_recycler_view_decoration));
        setGuideIcon(mToolbar, R.drawable.ic_arrow_left);
        tintDrawable(mToolbar.getNavigationIcon(), android.R.color.white);
    }

}

