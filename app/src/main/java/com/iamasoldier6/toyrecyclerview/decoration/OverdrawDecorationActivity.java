package com.iamasoldier6.toyrecyclerview.decoration;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.iamasoldier6.toyrecyclerview.R;
import com.iamasoldier6.toyrecyclerview.adapter.TextAdapter;
import com.iamasoldier6.toyrecyclerview.base.BaseActivity;

import java.util.Arrays;

import butterknife.Bind;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 */
public class OverdrawDecorationActivity extends BaseActivity {

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
        getSupportActionBar().setTitle(getString(R.string.toy_recycler_view_decoration_overdraw));
        setGuideIcon(mToolbar, R.drawable.ic_arrow_left);
        tintDrawable(mToolbar.getNavigationIcon(), android.R.color.white);
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setSmoothScrollbarEnabled(true);

        mRvCommon.addItemDecoration(new OverdrawDecoration(this));
        mRvCommon.setHasFixedSize(true);
        mRvCommon.setLayoutManager(layoutManager);
        mRvCommon.setAdapter(TextAdapter.createTextAdapter(this, Arrays.asList(
                getResources().getStringArray(R.array.toy_poetry))));
    }

}
