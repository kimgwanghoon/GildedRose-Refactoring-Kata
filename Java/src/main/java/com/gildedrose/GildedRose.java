package com.gildedrose;

import com.gildedrose.strategy.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items) {
            itemUpdate(item);
        }
    }

    public Item itemUpdate(Item item) {
        if (item.name.equals("Aged Brie")) {
            return new AgedBrie().update(item);
        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePasses().update(item);
        }
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new Sulfuras().update(item);
        }
        if (item.name.equals("Conjured Mana Cake")) {
            return new Conjured().update(item);
        }
        return new ItemDefault().update(item);
    }

}
