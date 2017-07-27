package com.iamasoldier6.toyrecyclerview.util;

import com.iamasoldier6.toyrecyclerview.R;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author: Iamasoldier6
 * @date: 2017/07/26
 */
public class IconHelper {

    public static List<Integer> VARIETY_ICONS =
            Arrays.asList(R.drawable.icon_item_1, R.drawable.icon_item_2, R.drawable.icon_item_3
                    , R.drawable.icon_item_4, R.drawable.icon_item_5, R.drawable.icon_item_6
                    , R.drawable.icon_item_7, R.drawable.icon_item_8, R.drawable.icon_item_9
                    , R.drawable.icon_item_10, R.drawable.icon_item_11, R.drawable.icon_item_12
                    , R.drawable.icon_item_13, R.drawable.icon_item_14, R.drawable.icon_item_15
                    , R.drawable.icon_item_16, R.drawable.icon_item_17, R.drawable.icon_item_18
                    , R.drawable.icon_item_19, R.drawable.icon_item_20);

    public static List<Integer> STAGGERED_ICONS =
            Arrays.asList(R.drawable.icon_item_1, R.drawable.icon_item_2, R.drawable.icon_item_3
                    , R.drawable.icon_item_4, R.drawable.icon_item_5, R.drawable.icon_item_6
                    , R.drawable.icon_item_7, R.drawable.icon_item_8, R.drawable.icon_item_9
                    , R.drawable.icon_item_10, R.drawable.bird_01, R.drawable.bird_02
                    , R.drawable.bird_03, R.drawable.icon_item_11, R.drawable.icon_item_12
                    , R.drawable.icon_item_13, R.drawable.icon_item_14, R.drawable.icon_item_15);

    public static int[] COLORS = new int[]{R.color.toy_google_blue, R.color.toy_google_green
            , R.color.toy_google_yellow, R.color.toy_google_red};

    public static Integer getRandomVarietyIcon() {
        return VARIETY_ICONS.get(new Random().nextInt(VARIETY_ICONS.size()));
    }

    public static Integer getRandomStaggeredIcon() {
        return STAGGERED_ICONS.get(new Random().nextInt(STAGGERED_ICONS.size()));
    }

}

