package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ItemDefault implements ItemUpdate {
    private static final Integer UPDATE_QUALITY_VALUE = -1;

    public Item update(Item item) {
        int quality = UPDATE_QUALITY_VALUE;
        declineSellIn(item);
        if (item.sellIn < 0) {
            quality += UPDATE_QUALITY_VALUE;
        }
        updateQuality(item, quality);
        return item;
    }
}
