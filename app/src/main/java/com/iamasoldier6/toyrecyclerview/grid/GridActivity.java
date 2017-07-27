package com.iamasoldier6.toyrecyclerview.grid;

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
public class GridActivity extends BaseActivity {

    @NonNull
    @Bind(R.id.btn_grid_standard)
    Button mBtnGridStandard;
    @NonNull
    @Bind(R.id.btn_grid_has_header)
    Button mBtnGridHasHeader;
    @NonNull
    @Bind(R.id.btn_grid_auto_fit)
    Button mBtnGridAutoFit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
    }

    @NonNull
    @OnClick(R.id.btn_grid_standard)
    public void onStandardClicked() {
        startActivity(new Intent(this, GridStandardActivity.class));
    }

    @NonNull
    @OnClick(R.id.btn_grid_has_header)
    public void onHasHeaderClicked() {
        startActivity(new Intent(this, GridHeaderActivity.class));
    }

    @NonNull
    @OnClick(R.id.btn_grid_auto_fit)
    public void onAutoFitClicked() {
        startActivity(new Intent(this, GridAutofitActivity.class));
    }

    @Override
    public void setupToolbar() {
        getSupportActionBar().setTitle(getString(R.string.toy_recycler_view_grid));
        setGuideIcon(mToolbar, R.drawable.ic_arrow_left);
        tintDrawable(mToolbar.getNavigationIcon(), android.R.color.white);
    }

}

