package com.gildedrose.strategy;

import com.gildedrose.Item;

import static com.gildedrose.ItemUpdateUtil.*;

public class Conjured implements ItemUpdate {

    @Override
    public Item update(Item item) {
        int quality = 2;
        declineSellIn(item);
        if (item.sellIn < 0) {
            quality += 2;
        }
        declineQuality(item, quality);
        return item;
    }
}
