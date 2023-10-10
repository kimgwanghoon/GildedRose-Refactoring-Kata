package com.gildedrose;

public class ItemUpdate {
    private static final Integer qualityMax = 50;
    protected static void IncreasedQuality(Item item) {
        if (item.quality < qualityMax) {
            item.quality = item.quality + 1;
        }
    }

    protected static void declineQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected static void declineSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}
