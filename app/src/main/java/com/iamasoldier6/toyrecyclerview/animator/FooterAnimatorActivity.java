package com.iamasoldier6.toyrecyclerview.animator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.iamasoldier6.toyrecyclerview.R;
import com.iamasoldier6.toyrecyclerview.adapter.AnimatorAdapter;
import com.iamasoldier6.toyrecyclerview.base.BaseActivity;
import com.iamasoldier6.toyrecyclerview.util.IconHelper;
import com.iamasoldier6.toyrecyclerview.widget.MarginDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 */
public class FooterAnimatorActivity extends BaseActivity {

    @NonNull
    @Bind(R.id.rv_common)
    RecyclerView mRvCommon;

    private AnimatorAdapter mAnimatorAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_main);
        initView();
    }

    @Override
    public void setupToolbar() {
        getSupportActionBar().setTitle(getResources().getString(R.string.toy_recycler_view_footer_animator));
        setGuideIcon(mToolbar, R.drawable.ic_arrow_left);
        tintDrawable(mToolbar.getNavigationIcon(), android.R.color.white);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.item_menu, menu);

        MenuItem addItem = menu.findItem(R.id.item_action_add);
        addItem.setActionView(R.layout.toolbar_menu_button);
        ImageButton btnAdd = (ImageButton) addItem.getActionView().findViewById(R.id.ib_btn_action);
        btnAdd.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_add));
        addItem.getActionView().setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mAnimatorAdapter != null) {
                    mAnimatorAdapter.addItem();
                    mRvCommon.scrollToPosition(mAnimatorAdapter.getItemCount() - 1);
                }
            }
        });

        MenuItem removeItem = menu.findItem(R.id.item_action_remove);
        removeItem.setActionView(R.layout.toolbar_menu_button);
        ImageButton btnRemove = (ImageButton) removeItem.getActionView().findViewById(R.id.ib_btn_action);
        btnRemove.setImageDrawable(getResources().getDrawable(R.drawable.ic_menu_minus));
        removeItem.getActionView().setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mAnimatorAdapter != null) {
                    mAnimatorAdapter.removeItem();
                    mRvCommon.scrollToPosition(mAnimatorAdapter.getItemCount() == 0 ? 0 : mAnimatorAdapter.getItemCount() - 1);
                }
            }
        });

        return true;
    }

    private void initView() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setSmoothScrollbarEnabled(true);

        mRvCommon.addItemDecoration(new MarginDecoration(this));
        mRvCommon.setHasFixedSize(true);
        mRvCommon.setLayoutManager(layoutManager);
        mRvCommon.setItemAnimator(new DefaultItemAnimator());

        List<Integer> itemList = new ArrayList<>();
        itemList.addAll(IconHelper.VARIETY_ICONS);
        mAnimatorAdapter = AnimatorAdapter.createAnimatorAdapter(this, itemList, AnimatorAdapter.FOOTER);

        mRvCommon.setAdapter(mAnimatorAdapter);
    }

}

