package com.iamasoldier6.toyrecyclerview.linear;

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
public class LinearActivity extends BaseActivity {

    @NonNull
    @Bind(R.id.btn_recycler_horizontal)
    Button mBtnRecyclerHorizontal;
    @NonNull
    @Bind(R.id.btn_recycler_vertical)
    Button mBtnRecyclerVertical;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
    }

    @NonNull
    @OnClick(R.id.btn_recycler_horizontal)
    public void onHorizontalClicked() {
        startActivity(new Intent(this, HorizontalActivity.class));
    }

    @NonNull
    @OnClick(R.id.btn_recycler_vertical)
    public void onVerticalClicked() {
        startActivity(new Intent(this, VerticalActivity.class));
    }

    @Override
    public void setupToolbar() {
        getSupportActionBar().setTitle(getString(R.string.toy_recycler_view_linear));
        setGuideIcon(mToolbar, R.drawable.ic_arrow_left);
        tintDrawable(mToolbar.getNavigationIcon(), android.R.color.white);
    }

}
