package com.gildedrose;

import java.util.List;
import java.util.stream.Collectors;

import static com.gildedrose.ItemUpdate.*;

class GildedRose {
    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        items.stream().map(this::itemUpdate).collect(Collectors.toList());
    }

    public Item itemUpdate(Item item) {
        if (item.name.equals("Aged Brie")) {
            return AgedBrie(item);
        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return BackstagePasses(item);
        }
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return Sulfuras(item);
        }
        if (item.name.equals("Conjured Mana Cake")) {
            return Conjured(item);
        }
        return updateDefault(item);
    }

    public Item AgedBrie(Item item) {
        IncreasedQuality(item);
        declineSellIn(item);
        if (item.sellIn < 0) {
            IncreasedQuality(item);
        }
        return item;
    }

    public Item BackstagePasses(Item item) {
        IncreasedQuality(item);
        if (item.sellIn < 11) {
            IncreasedQuality(item);
        }
        if (item.sellIn < 6) {
            IncreasedQuality(item);
        }

        declineSellIn(item);
        if (item.sellIn < 0) {
            item.quality = 0;
        }
        return item;
    }

    public Item Sulfuras(Item item) {
        return item;
    }

    public Item updateDefault(Item item) {
        declineQuality(item);
        declineSellIn(item);
        if (item.sellIn < 0) {
            declineQuality(item);
        }
        return item;
    }

    public Item Conjured(Item item) {
        declineQuality(item);
        declineQuality(item);
        declineSellIn(item);
        if (item.sellIn < 0) {
            declineQuality(item);
            declineQuality(item);
        }
        return item;
    }
}
