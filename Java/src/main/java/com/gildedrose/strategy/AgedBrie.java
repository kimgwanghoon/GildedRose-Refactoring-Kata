package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedBrie implements ItemUpdate {
    private static final Integer UPDATE_QUALITY_VALUE = 1;

    @Override
    public void update(Item item) {
        int quality = UPDATE_QUALITY_VALUE;
        declineSellIn(item);
        if (item.sellIn < 0) {
            quality += UPDATE_QUALITY_VALUE;
        }
        increaseQuality(item, quality);
    }
}
