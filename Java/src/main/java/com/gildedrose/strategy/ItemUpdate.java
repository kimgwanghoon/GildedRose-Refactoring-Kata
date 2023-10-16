package com.gildedrose.strategy;

import com.gildedrose.Item;

public interface ItemUpdate {
    Integer QUALITY_MAX = 50;
    Integer QUALITY_MIN = 0;

    Item update(Item item);

    default void updateQuality(Item item, int value) {
        if (item.quality < QUALITY_MAX) {
            item.quality += value;
            validatedQuality(item);
        }
    }

    default void declineSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    default void validatedQuality(Item item) {
        if (item.quality > QUALITY_MAX) {
            item.quality = QUALITY_MAX;
        }
        if (item.quality < QUALITY_MIN) {
            item.quality = QUALITY_MIN;
        }
    }
}
