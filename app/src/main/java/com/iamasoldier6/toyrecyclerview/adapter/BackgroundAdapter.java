package com.iamasoldier6.toyrecyclerview.adapter;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.iamasoldier6.toyrecyclerview.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 */
public class BackgroundAdapter extends RecyclerView.Adapter<BackgroundAdapter.BackgroundViewHolder> {

    public static final int BLUE = 1;
    public static final int YELLOW = 2;
    public static final int GREEN = 3;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({BLUE, YELLOW, GREEN})
    private @interface COLOR {

    }

    private int mColor;
    private Context mContext;
    private List<Integer> mItemList;

    private BackgroundAdapter(Context context, List<Integer> itemList, @COLOR int color) {
        mContext = context;
        mItemList = itemList;
        mColor = color;
    }

    @Override
    public BackgroundViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (mColor) {
            case BLUE:
                return new BackgroundViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_card_blue, parent, false));
            case YELLOW:
                return new BackgroundViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_card_yellow, parent, false));
            default:
                return new BackgroundViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_card_green, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(BackgroundViewHolder holder, int position) {
        holder.mIvItem.setImageDrawable(mContext.getResources().getDrawable(mItemList.get(position)));
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    public boolean isHeader(int position) {
        return position == 0;
    }

    public void updateItems(List<Integer> itemList) {
        mItemList = itemList;
        notifyDataSetChanged();
    }

    public static BackgroundAdapter createBackgroundAdapter(Context context, List<Integer> itemList, @COLOR int color) {
        return new BackgroundAdapter(context, itemList, color);
    }

    public static final class BackgroundViewHolder extends RecyclerView.ViewHolder {

        @NonNull
        @Bind(R.id.iv_card_item)
        ImageView mIvItem;

        public BackgroundViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(BackgroundViewHolder.this, itemView);
        }
    }

}

