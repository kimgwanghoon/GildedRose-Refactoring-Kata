package com.gildedrose.strategy;

import com.gildedrose.Item;

public class BackstagePasses implements ItemUpdate {
    private static final Integer UPDATE_QUALITY_VALUE = 1;
    private static final Integer FIRST_QUALITY_IMPROVEMENT = 10;
    private static final Integer SECOND_QUALITY_IMPROVEMENT = 5;

    @Override
    public Item update(Item item) {
        int quality = UPDATE_QUALITY_VALUE;
        if (item.sellIn <= FIRST_QUALITY_IMPROVEMENT) {
            quality += UPDATE_QUALITY_VALUE;
        }
        if (item.sellIn <= SECOND_QUALITY_IMPROVEMENT) {
            quality += UPDATE_QUALITY_VALUE;
        }
        declineSellIn(item);
        if (item.sellIn < 0) {
            quality = -item.quality;
        }
        updateQuality(item, quality);
        return item;
    }
}
