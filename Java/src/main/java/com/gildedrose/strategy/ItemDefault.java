package com.gildedrose.strategy;

import com.gildedrose.Item;

import static com.gildedrose.ItemUpdateUtil.*;

public class ItemDefault implements ItemUpdate {
    public Item update(Item item) {
        int quality = 1;
        declineSellIn(item);
        if (item.sellIn < 0) {
            quality += 1;
        }
        declineQuality(item, quality);
        return item;
    }
}
