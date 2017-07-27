package com.iamasoldier6.toyrecyclerview.decoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.iamasoldier6.toyrecyclerview.R;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 */
public class StandardDecoration extends RecyclerView.ItemDecoration {

    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};

    private Context mContext;
    private Drawable mDivider;

    public StandardDecoration(Context context) {
        mContext = context;
        TypedArray typedArray = null;

        try {
            typedArray = context.getTheme().obtainStyledAttributes(ATTRS);
            mDivider = typedArray.getDrawable(0);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft() + mContext.getResources().getDimensionPixelOffset(R.dimen.toy_dimen_24);
        int right = parent.getWidth() - parent.getPaddingRight() - mContext.getResources().getDimensionPixelOffset(R.dimen.toy_dimen_24);

        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount - 1; i++) {
            View child = parent.getChildAt(i);

            if (child.getLayoutParams() instanceof RecyclerView.LayoutParams) {
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();

                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, 0);
    }

}

