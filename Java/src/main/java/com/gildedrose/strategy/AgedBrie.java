package com.gildedrose.strategy;

import com.gildedrose.Item;

import static com.gildedrose.ItemUpdateUtil.*;

public class AgedBrie implements ItemUpdate {

    @Override
    public Item update(Item item) {
        int quality = 1;
        declineSellIn(item);
        if (item.sellIn < 0) {
            quality += 1;
        }
        IncreasedQuality(item, quality);
        return item;
    }
}
