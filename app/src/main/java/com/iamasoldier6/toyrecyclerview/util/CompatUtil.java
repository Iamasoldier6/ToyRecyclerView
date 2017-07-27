package com.iamasoldier6.toyrecyclerview.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.Toolbar;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 */
public class CompatUtil {

    private static final CompatImpl IMPL;

    static {
        final int version = Build.VERSION.SDK_INT;

        if (version >= Build.VERSION_CODES.M) {
            IMPL = new MarshmallowCompatImpl();
        } else if (version >= Build.VERSION_CODES.LOLLIPOP) {
            IMPL = new LollipopCompatImpl();
        } else {
            IMPL = new BaseCompatImpl();
        }
    }

    public static void setGuideIcon(@NonNull Toolbar toolbar, @NonNull Context context, @DrawableRes int drawableId) {
        IMPL.setGuideIcon(toolbar, context, drawableId);
    }

    public static void tintDrawable(@NonNull Context context, @NonNull Drawable drawable, @ColorRes int colorId) {
        IMPL.tintDrawable(context, drawable, colorId);
    }

    /**
     * Base
     */
    private static class BaseCompatImpl implements CompatImpl {

        @Override
        public void setGuideIcon(@NonNull Toolbar toolbar, @NonNull Context context, @DrawableRes int drawableId) {
            toolbar.setNavigationIcon(context.getResources().getDrawable(drawableId));
        }

        @Override
        public void tintDrawable(@NonNull Context context, @NonNull Drawable drawable, @ColorRes int colorId) {
            DrawableCompat.setTint(DrawableCompat.wrap(drawable.mutate()), context.getResources().getColor(colorId));
        }

        @Override
        public Drawable getDrawable(@NonNull Context context, @DrawableRes int drawableId) {
            return context.getResources().getDrawable(drawableId);
        }
    }

    /**
     * Lollipop
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private static class LollipopCompatImpl extends BaseCompatImpl {

        @Override
        public void setGuideIcon(@NonNull Toolbar toolbar, @NonNull Context context, @DrawableRes int drawableId) {
            toolbar.setNavigationIcon(context.getResources().getDrawable(drawableId, context.getTheme()));
        }

        @Override
        public Drawable getDrawable(@NonNull Context context, @DrawableRes int drawableId) {
            return context.getResources().getDrawable(drawableId, context.getTheme());
        }
    }

    /**
     * Marshmallow
     */
    @TargetApi(Build.VERSION_CODES.M)
    private static class MarshmallowCompatImpl extends LollipopCompatImpl {

        @Override
        public void tintDrawable(@NonNull Context context, @NonNull Drawable drawable, @ColorRes int colorId) {
            DrawableCompat.setTint(DrawableCompat.wrap(drawable.mutate()), context.getResources().getColor(colorId, context.getTheme()));
        }
    }

    private interface CompatImpl {

        void setGuideIcon(@NonNull Toolbar toolbar, @NonNull Context context, @DrawableRes int drawableId);

        void tintDrawable(@NonNull Context context, @NonNull Drawable drawable, @ColorRes int colorId);

        Drawable getDrawable(@NonNull Context context, @DrawableRes int drawableId);
    }

}

