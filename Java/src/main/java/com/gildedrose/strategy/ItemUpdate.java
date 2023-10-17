package com.gildedrose.strategy;

import com.gildedrose.Item;

public interface ItemUpdate {
    Integer QUALITY_MAX = 50;
    Integer QUALITY_MIN = 0;

    void update(Item item);

    default void increaseQuality(Item item, int value) {
        if (item.quality < QUALITY_MAX) {
            item.quality += value;
            validatedQualityMax(item);
        }
    }

    default void declineQuality(Item item, int value) {
        if (item.quality > QUALITY_MIN) {
            item.quality -= value;
            validatedQualityMin(item);
        }
    }

    default void declineSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    default void validatedQualityMax(Item item) {
        if (item.quality > QUALITY_MAX) {
            item.quality = QUALITY_MAX;
        }
    }

    default void validatedQualityMin(Item item) {
        if (item.quality < QUALITY_MIN) {
            item.quality = QUALITY_MIN;
        }
    }
}
