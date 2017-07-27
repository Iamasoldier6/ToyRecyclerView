package com.iamasoldier6.toyrecyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.iamasoldier6.toyrecyclerview.R;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 */
public class MarginDecoration extends RecyclerView.ItemDecoration {

    private int mMargin;

    public MarginDecoration(Context context) {
        mMargin = context.getResources().getDimensionPixelSize(R.dimen.toy_dimen_8);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(mMargin, mMargin, mMargin, mMargin);
    }

}
