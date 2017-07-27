package com.iamasoldier6.toyrecyclerview.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import com.iamasoldier6.toyrecyclerview.R;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 */
public class OverdrawDecoration extends RecyclerView.ItemDecoration {

    private Context mContext;
    private Drawable mDivider;

    public OverdrawDecoration(Context context) {
        mContext = context;
        TypedValue typedValue = new TypedValue();

        if (context.getTheme()
                .resolveAttribute(android.R.attr.listDivider, typedValue, true) && typedValue.data != 0) {
            mDivider = context.getResources().getDrawable(typedValue.resourceId);
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {

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

}

