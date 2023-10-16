package com.gildedrose;

public class ItemUpdateUtil {
    private static final Integer QUALITY_MAX = 50;
    private static final Integer QUALITY_MIN = 0;

    public static void IncreasedQuality(Item item, Integer value) {
        if (item.quality < QUALITY_MAX) {
            item.quality = item.quality + value;
            validatedQuality(item);
        }
    }

    public static void declineQuality(Item item, Integer value) {
        if (item.quality > QUALITY_MIN) {
            item.quality = item.quality - value;
            validatedQuality(item);
        }
    }

    public static void declineSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private static void validatedQuality(Item item) {
        if (item.quality > QUALITY_MAX) {
            item.quality = QUALITY_MAX;
        }
        if (item.quality < QUALITY_MIN) {
            item.quality = QUALITY_MIN;
        }
    }
}
