package com.iamasoldier6.toyrecyclerview.grid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.iamasoldier6.toyrecyclerview.R;
import com.iamasoldier6.toyrecyclerview.adapter.BackgroundAdapter;
import com.iamasoldier6.toyrecyclerview.base.BaseActivity;
import com.iamasoldier6.toyrecyclerview.util.IconHelper;
import com.iamasoldier6.toyrecyclerview.widget.MarginDecoration;

import butterknife.Bind;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 */
public class GridStandardActivity extends BaseActivity {

    @NonNull
    @Bind(R.id.rv_common)
    RecyclerView mRvCommon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_main);
        initView();
    }

    @Override
    public void setupToolbar() {
        getSupportActionBar().setTitle(getString(R.string.toy_recycler_view_grid_standard));
        setGuideIcon(mToolbar, R.drawable.ic_arrow_left);
        tintDrawable(mToolbar.getNavigationIcon(), android.R.color.white);
    }

    private void initView() {
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setSmoothScrollbarEnabled(true);

        mRvCommon.addItemDecoration(new MarginDecoration(this));
        mRvCommon.setHasFixedSize(true);
        mRvCommon.setLayoutManager(layoutManager);
        mRvCommon.setAdapter(BackgroundAdapter.createBackgroundAdapter(this, IconHelper.VARIETY_ICONS, BackgroundAdapter.GREEN));
    }

}

