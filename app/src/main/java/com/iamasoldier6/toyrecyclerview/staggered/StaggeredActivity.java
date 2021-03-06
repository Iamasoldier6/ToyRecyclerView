package com.iamasoldier6.toyrecyclerview.staggered;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

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
public class StaggeredActivity extends BaseActivity {

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
        getSupportActionBar().setTitle(getString(R.string.toy_recycler_view_staggered));
        setGuideIcon(mToolbar, R.drawable.ic_arrow_left);
        tintDrawable(mToolbar.getNavigationIcon(), android.R.color.white);
    }

    private void initView() {
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2
                , StaggeredGridLayoutManager.VERTICAL);

        mRvCommon.addItemDecoration(new MarginDecoration(this));
        mRvCommon.setHasFixedSize(true);
        mRvCommon.setLayoutManager(layoutManager);
        mRvCommon.setAdapter(
                BackgroundAdapter.createBackgroundAdapter(this, IconHelper.STAGGERED_ICONS, BackgroundAdapter.YELLOW));
    }

}

