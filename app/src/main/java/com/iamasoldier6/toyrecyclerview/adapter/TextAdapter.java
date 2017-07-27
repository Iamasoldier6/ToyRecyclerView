package com.iamasoldier6.toyrecyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iamasoldier6.toyrecyclerview.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 */
public class TextAdapter extends RecyclerView.Adapter<TextAdapter.TextViewHolder> {

    private Context mContext;
    private List<String> mItemList;

    private TextAdapter(Context context, List<String> itemList) {
        mContext = context;
        mItemList = itemList;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TextViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        holder.mTextView.setText(mItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    public static TextAdapter createTextAdapter(Context context, List<String> itemList) {
        return new TextAdapter(context, itemList);
    }

    public static final class TextViewHolder extends RecyclerView.ViewHolder {

        @NonNull
        @Bind(R.id.tv_item)
        TextView mTextView;

        public TextViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(TextViewHolder.this, itemView);
        }
    }

}

