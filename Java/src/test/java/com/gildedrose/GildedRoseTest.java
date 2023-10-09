package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GildedRoseTest {

    @Nested
    @DisplayName("기본 테스트")
    class FooTest {
        @Test
        @DisplayName("foo기간만료")
        void fooSellInZero() {
            List<Item> items = new ArrayList<Item>();
            items.add(new Item("foo", 0, 0));
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items.get(0).quality);
        }

        @Test
        @DisplayName("foo가치갱신")
        void fooUpdate() {
            List<Item> items = new ArrayList<Item>();
            items.add(new Item("foo", 1, 1));
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items.get(0).quality);
        }
    }

    @Nested
    @DisplayName("AgedBrie 테스트")
    class AgedBrieTest {
        @Test
        @DisplayName("AgedBrie 갱신")
        void agedBrieUpdate() {
            List<Item> items = new ArrayList<Item>();
            items.add(new Item("Aged Brie", 2, 0));
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(1, app.items.get(0).quality);
        }

        @Test
        @DisplayName("AgedBrie 가치 최대")
        void agedBrieMax() {
            List<Item> items = new ArrayList<Item>();
            items.add(new Item("Aged Brie", 2, 50));
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertNotEquals(51, app.items.get(0).quality);
        }
    }

    @Nested
    @DisplayName("BackstagePasses 테스트")
    class BackstagePasses {
        @Test
        @DisplayName("BackstagePasses 기본 갱신")
        void backstagePassesUpdate() {
            List<Item> items = new ArrayList<Item>();
            items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(21, app.items.get(0).quality);
        }

        @Test
        @DisplayName("BackstagePasses 10일전 갱신")
        void backstagePassesUpdate2() {
            List<Item> items = new ArrayList<Item>();
            items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(22, app.items.get(0).quality);
        }

        @Test
        @DisplayName("BackstagePasses 5일전 갱신")
        void backstagePassesUpdate3() {
            List<Item> items = new ArrayList<Item>();
            items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(23, app.items.get(0).quality);
        }

        @Test
        @DisplayName("BackstagePasses 공연 종료")
        void backstagePassesUpdateZero() {
            List<Item> items = new ArrayList<Item>();
            items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items.get(0).quality);
        }
    }

    @Test
    @DisplayName("전설템 가치 고정")
    void sulfurasUpdate() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items.get(0).quality);
    }

    @Nested
    @DisplayName("Conjured 테스트")
    class ConjuredTest {
        @Test
        @DisplayName("Conjured 갱신")
        void conjuredUpdate() {
            List<Item> items = new ArrayList<Item>();
            items.add(new Item("Conjured Mana Cake", 3, 6));
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(4, app.items.get(0).quality);
        }

        @Test
        @DisplayName("Conjured 갱신2")
        void conjuredUpdate2() {
            List<Item> items = new ArrayList<Item>();
            items.add(new Item("Conjured Mana Cake", 0, 6));
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(2, app.items.get(0).quality);
        }

        @Test
        @DisplayName("Conjured 갱신3")
        void conjuredUpdate3() {
            List<Item> items = new ArrayList<Item>();
            items.add(new Item("Conjured Mana Cake", 0, 1));
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items.get(0).quality);
        }
    }

}
