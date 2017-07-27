package com.iamasoldier6.toyrecyclerview.animator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.iamasoldier6.toyrecyclerview.R;
import com.iamasoldier6.toyrecyclerview.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 */
public class ItemAnimatorActivity extends BaseActivity {

    @NonNull
    @Bind(R.id.btn_recycler_item_animator_header)
    Button mBtnRecyclerItemAnimatorHeader;
    @NonNull
    @Bind(R.id.btn_recycler_item_animator_footer)
    Button mBtnRecyclerItemAnimatorFooter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_animator);
        ButterKnife.bind(this);
    }

    @NonNull
    @OnClick(R.id.btn_recycler_item_animator_header)
    public void onHeaderClicked() {
        startActivity(new Intent(this, HeaderAnimatorActivity.class));
    }

    @NonNull
    @OnClick(R.id.btn_recycler_item_animator_footer)
    public void onFooterClicked() {
        startActivity(new Intent(this, FooterAnimatorActivity.class));
    }

    @Override
    public void setupToolbar() {
        getSupportActionBar().setTitle(getResources().getString(R.string.toy_recycler_view_item_animator));
        setGuideIcon(mToolbar, R.drawable.ic_arrow_left);
        tintDrawable(mToolbar.getNavigationIcon(), android.R.color.white);
    }

}

