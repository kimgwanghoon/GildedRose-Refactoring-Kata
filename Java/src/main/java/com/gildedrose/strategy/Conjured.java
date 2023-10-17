package com.gildedrose.strategy;

import com.gildedrose.Item;

public class Conjured implements ItemUpdate {
    private static final Integer UPDATE_QUALITY_VALUE = 2;

    @Override
    public void update(Item item) {
        int quality = UPDATE_QUALITY_VALUE;
        declineSellIn(item);
        if (item.sellIn < 0) {
            quality += UPDATE_QUALITY_VALUE;
        }
        declineQuality(item, quality);
    }
}
