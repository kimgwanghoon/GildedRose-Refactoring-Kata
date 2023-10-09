package com.gildedrose;

public class ItemUpdate {
    public void IncreasedQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    public void declineQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    public void declineSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}
