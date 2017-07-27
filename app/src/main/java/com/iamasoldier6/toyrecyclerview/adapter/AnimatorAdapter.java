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
import com.iamasoldier6.toyrecyclerview.util.IconHelper;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 */
public class AnimatorAdapter extends RecyclerView.Adapter<AnimatorAdapter.AnimatorViewHolder> {

    public static final int HEADER = 1;
    public static final int FOOTER = 2;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({HEADER, FOOTER})
    private @interface TYPE {

    }

    private int mType;
    private Context mContext;
    private List<Integer> mItemList;

    private AnimatorAdapter(Context context, List<Integer> itemList, int type) {
        mContext = context;
        mItemList = itemList;
        mType = type;
    }

    @Override
    public AnimatorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (mType == HEADER) {
            return new AnimatorViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_card_blue, parent, false));
        }
        return new AnimatorViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_card_green, parent, false));
    }

    @Override
    public void onBindViewHolder(AnimatorViewHolder holder, int position) {
        holder.mIvItem.setImageDrawable(mContext.getResources().getDrawable(mItemList.get(position)));
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    public void addItem() {
        if (mType == HEADER) {
            mItemList.add(0, IconHelper.getRandomVarietyIcon());
            notifyItemInserted(0);
        } else if (mType == FOOTER) {
            mItemList.add(mItemList.size(), IconHelper.getRandomVarietyIcon());
            notifyItemInserted(mItemList.size());
        }
    }

    public void removeItem() {
        if (!(mItemList.size() > 0)) {
            return;
        }

        if (mType == HEADER) {
            mItemList.remove(0);
            notifyItemRemoved(0);
        } else if (mType == FOOTER) {
            mItemList.remove(mItemList.size() - 1);
            notifyItemRemoved(mItemList.size());
        }
    }

    public static AnimatorAdapter createAnimatorAdapter(Context context, List<Integer> itemList, @TYPE int type) {
        return new AnimatorAdapter(context, itemList, type);
    }

    public static final class AnimatorViewHolder extends RecyclerView.ViewHolder {

        @NonNull
        @Bind(R.id.iv_card_item)
        ImageView mIvItem;

        public AnimatorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(AnimatorViewHolder.this, itemView);
        }
    }

}

