package com.iamasoldier6.toyrecyclerview.refresh;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.iamasoldier6.toyrecyclerview.R;
import com.iamasoldier6.toyrecyclerview.adapter.BackgroundAdapter;
import com.iamasoldier6.toyrecyclerview.base.BaseActivity;
import com.iamasoldier6.toyrecyclerview.util.IconHelper;
import com.iamasoldier6.toyrecyclerview.widget.MarginDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 */
public class SwipeRefreshActivity extends BaseActivity {

    private static final int VARIETY_ICONS = 1;
    private static final int STAGGERED_ICONS = 2;

    @NonNull
    @Bind(R.id.rv_common)
    RecyclerView mRvCommon;
    @NonNull
    @Bind(R.id.sr_swipe_layout)
    SwipeRefreshLayout mSrSwipeLayout;

    private BackgroundAdapter mBackgroundAdapter;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    private static final Integer[] ICONS = {IconHelper.getRandomVarietyIcon(), IconHelper.getRandomStaggeredIcon()};

    private SwipeRefreshLayout.OnRefreshListener mRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            if (mSrSwipeLayout.isRefreshing()) {
                postItems();
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);
        initView();
    }

    @Override
    public void setupToolbar() {
        getSupportActionBar().setTitle(getResources().getString(R.string.toy_recycler_view_swipe_refresh));
        setGuideIcon(mToolbar, R.drawable.ic_arrow_left);
        tintDrawable(mToolbar.getNavigationIcon(), android.R.color.white);
    }

    @Override
    protected void onDestroy() {
        mSrSwipeLayout.setOnRefreshListener(null);
        mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    private void initView() {
        mSrSwipeLayout.setColorSchemeResources(IconHelper.COLORS);
        mSrSwipeLayout.setOnRefreshListener(mRefreshListener);
        mSrSwipeLayout.post(new Runnable() {
            @Override
            public void run() {
                mSrSwipeLayout.setRefreshing(true);
            }
        });

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2
                , StaggeredGridLayoutManager.VERTICAL);

        mRvCommon.addItemDecoration(new MarginDecoration(this));
        mRvCommon.setHasFixedSize(true);
        mRvCommon.setLayoutManager(layoutManager);

        postItems();
    }

    @CheckResult
    @NonNull
    private List<Integer> addItemList() {

        List<Integer> itemList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            switch (new Random().nextInt(ICONS.length)) {
                case VARIETY_ICONS:
                    itemList.add(IconHelper.getRandomVarietyIcon());
                    break;
                case STAGGERED_ICONS:
                    itemList.add(IconHelper.getRandomStaggeredIcon());
                    break;
                default:
                    break;
            }
        }

        return itemList;
    }

    private void postItems() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSrSwipeLayout.setRefreshing(false);

                if (mBackgroundAdapter == null) {
                    mBackgroundAdapter = BackgroundAdapter.createBackgroundAdapter(SwipeRefreshActivity.this
                            , addItemList(), BackgroundAdapter.GREEN);
                    mRvCommon.setAdapter(mBackgroundAdapter);
                } else {
                    mBackgroundAdapter.updateItems(addItemList());
                }

                mRvCommon.scrollToPosition(0);
            }
        }, 4 * 1000);
    }

}

