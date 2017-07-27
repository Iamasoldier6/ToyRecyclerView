package com.iamasoldier6.toyrecyclerview.grid;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 * 适用于窗口宽高发生变化的情况，根据当前的宽度和列的宽度动态计算布局的实现
 */
public class AutofitRecyclerView extends RecyclerView {

    private int mColumnWidth = -1;
    private GridLayoutManager mLayoutManager;

    public AutofitRecyclerView(Context context) {
        super(context);
        init(context, null);
    }

    public AutofitRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AutofitRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        if (mColumnWidth > 0) {
            // Auto Fit RecyclerView 的核心处理
            int spanCount = Math.max(1, getMeasuredWidth() / mColumnWidth);
            mLayoutManager.setSpanCount(spanCount);
        }
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] attrsArray = {android.R.attr.columnWidth};
            TypedArray array = context.obtainStyledAttributes(attrs, attrsArray);
            mColumnWidth = array.getDimensionPixelSize(0, -1);
            array.recycle();
        }

        mLayoutManager = new GridLayoutManager(getContext(), 1);
        setLayoutManager(mLayoutManager);
    }

}

