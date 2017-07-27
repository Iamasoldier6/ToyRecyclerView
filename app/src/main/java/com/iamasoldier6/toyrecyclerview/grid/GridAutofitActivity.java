package com.iamasoldier6.toyrecyclerview.grid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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
public class GridAutofitActivity extends BaseActivity {

    @NonNull
    @Bind(R.id.rv_auto_fit)
    AutofitRecyclerView mRvAutoFit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_auto_fit);
        initView();
    }

    @Override
    public void setupToolbar() {
        getSupportActionBar().setTitle(getString(R.string.toy_recycler_view_grid_auto_fit));
        setGuideIcon(mToolbar, R.drawable.ic_arrow_left);
        tintDrawable(mToolbar.getNavigationIcon(), android.R.color.white);
    }

    private void initView() {
        mRvAutoFit.addItemDecoration(new MarginDecoration(this));
        mRvAutoFit.setHasFixedSize(true);
        mRvAutoFit.setAdapter(BackgroundAdapter.createBackgroundAdapter(this, IconHelper.VARIETY_ICONS, BackgroundAdapter.GREEN));
    }

}

