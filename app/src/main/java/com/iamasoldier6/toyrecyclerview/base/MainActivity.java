package com.iamasoldier6.toyrecyclerview.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.iamasoldier6.toyrecyclerview.R;
import com.iamasoldier6.toyrecyclerview.animator.ItemAnimatorActivity;
import com.iamasoldier6.toyrecyclerview.decoration.DecorationActivity;
import com.iamasoldier6.toyrecyclerview.grid.GridActivity;
import com.iamasoldier6.toyrecyclerview.linear.LinearActivity;
import com.iamasoldier6.toyrecyclerview.refresh.SwipeRefreshActivity;
import com.iamasoldier6.toyrecyclerview.staggered.StaggeredActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 */
public class MainActivity extends BaseActivity {

    @NonNull
    @Bind(R.id.btn_recycler_linear)
    Button mBtnRecyclerLinear;
    @NonNull
    @Bind(R.id.btn_recycler_grid)
    Button mBtnRecyclerGrid;
    @NonNull
    @Bind(R.id.btn_recycler_staggered)
    Button mBtnRecyclerStaggered;
    @NonNull
    @Bind(R.id.btn_recycler_decoration)
    Button mBtnRecyclerDecoration;
    @NonNull
    @Bind(R.id.btn_recycler_animator)
    Button mBtnRecyclerAnimator;
    @NonNull
    @Bind(R.id.btn_recycler_refresh)
    Button mBtnRecyclerRefresh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @NonNull
    @OnClick(R.id.btn_recycler_linear)
    public void onLinearClicked() {
        startActivity(new Intent(this, LinearActivity.class));
    }

    @NonNull
    @OnClick(R.id.btn_recycler_grid)
    public void onGridClicked() {
        startActivity(new Intent(this, GridActivity.class));
    }

    @NonNull
    @OnClick(R.id.btn_recycler_staggered)
    public void onStaggeredClicked() {
        startActivity(new Intent(this, StaggeredActivity.class));
    }

    @NonNull
    @OnClick(R.id.btn_recycler_decoration)
    public void onDecorationClicked() {
        startActivity(new Intent(this, DecorationActivity.class));
    }

    @NonNull
    @OnClick(R.id.btn_recycler_animator)
    public void onAnimatorClicked() {
        startActivity(new Intent(this, ItemAnimatorActivity.class));
    }

    @NonNull
    @OnClick(R.id.btn_recycler_refresh)
    public void onRefreshClicked() {
        startActivity(new Intent(this, SwipeRefreshActivity.class));
    }

    @Override
    public void setupToolbar() {
        getSupportActionBar().setTitle(getString(R.string.app_name));
    }

}

