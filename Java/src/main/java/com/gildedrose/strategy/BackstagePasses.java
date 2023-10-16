package com.gildedrose.strategy;

import com.gildedrose.Item;

import static com.gildedrose.ItemUpdateUtil.*;

public class BackstagePasses implements ItemUpdate {

    @Override
    public Item update(Item item) {
        int quality = 1;
        if (item.sellIn <= 10) {
            quality += 1;
        }
        if (item.sellIn <= 5) {
            quality += 1;
        }
        declineSellIn(item);
        IncreasedQuality(item, quality);
        if (item.sellIn < 0) {
            declineQuality(item, item.quality);
        }
        return item;
    }
}
