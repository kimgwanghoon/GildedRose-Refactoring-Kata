package com.gildedrose;

import com.gildedrose.strategy.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemFactory.getItemInstance(item).update(item);
        }
    }
}
