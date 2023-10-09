package com.gildedrose;

import java.util.List;
import java.util.stream.Collectors;

class GildedRose {
    List<Item> items;

    ItemUpdate itemUpdate;

    public GildedRose(List<Item> items) {
        this.items = items;
        this.itemUpdate = new ItemUpdate();
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
        itemUpdate.IncreasedQuality(item);
        itemUpdate.declineSellIn(item);
        if (item.sellIn < 0) {
            itemUpdate.IncreasedQuality(item);
        }
        return item;
    }

    public Item BackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
            if (item.sellIn < 11) {
                itemUpdate.IncreasedQuality(item);
            }
            if (item.sellIn < 6) {
                itemUpdate.IncreasedQuality(item);
            }
        }
        itemUpdate.declineSellIn(item);
        if (item.sellIn < 0) {
            item.quality = 0;
        }
        return item;
    }

    public Item Sulfuras(Item item) {
        return item;
    }

    public Item updateDefault(Item item) {
        itemUpdate.declineQuality(item);
        itemUpdate.declineSellIn(item);
        if (item.sellIn < 0) {
            itemUpdate.declineQuality(item);
        }
        return item;
    }

    public Item Conjured(Item item) {
        itemUpdate.declineQuality(item);
        itemUpdate.declineQuality(item);
        itemUpdate.declineSellIn(item);
        if (item.sellIn < 0) {
            itemUpdate.declineQuality(item);
            itemUpdate.declineQuality(item);
        }
        return item;
    }


}
