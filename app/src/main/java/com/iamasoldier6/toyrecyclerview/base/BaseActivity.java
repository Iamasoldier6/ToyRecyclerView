package com.iamasoldier6.toyrecyclerview.base;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.iamasoldier6.toyrecyclerview.R;
import com.iamasoldier6.toyrecyclerview.util.CompatUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 */
public abstract class BaseActivity extends AppCompatActivity {

    @NonNull
    @Bind(R.id.tl_bar)
    protected Toolbar mToolbar;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        bindToolbar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 设置导航 Icon
     *
     * @param toolbar
     * @param drawableId
     */
    protected void setGuideIcon(@NonNull Toolbar toolbar, @DrawableRes int drawableId) {
        CompatUtil.setGuideIcon(toolbar, this, drawableId);
    }

    /**
     * 给 Drawable 染色
     *
     * @param drawable
     * @param color
     */
    protected void tintDrawable(@NonNull Drawable drawable, @ColorRes int color) {
        CompatUtil.tintDrawable(this, drawable, color);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    private void bindToolbar() {
        setSupportActionBar(mToolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setElevation(0.0F);
        }
        setupToolbar();
    }

    public abstract void setupToolbar();

}

