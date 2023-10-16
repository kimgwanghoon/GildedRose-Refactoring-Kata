package com.gildedrose;

import com.gildedrose.strategy.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ItemFactory {
    private static final String DEFAULT_ITEM = "default";
    private static final Map<String, Supplier<ItemUpdate>> itemUpdateMap = new HashMap<>();

    static {
        itemUpdateMap.put("Aged Brie", AgedBrie::new);
        itemUpdateMap.put("Backstage passes to a TAFKAL80ETC concert", BackstagePasses::new);
        itemUpdateMap.put("Sulfuras, Hand of Ragnaros", Sulfuras::new);
        itemUpdateMap.put("Conjured Mana Cake", Conjured::new);
        itemUpdateMap.put("default", ItemDefault::new);
    }

    public static ItemUpdate getItemInstance(Item item) {
        return itemUpdateMap.getOrDefault(item.name, itemUpdateMap.get(DEFAULT_ITEM)).get();
    }
}
