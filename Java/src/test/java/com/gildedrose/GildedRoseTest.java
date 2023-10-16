package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GildedRoseTest {

    @Nested
    @DisplayName("기본 아이템")
    class FooTest {
        @Test
        @DisplayName("foo기간만료")
        void fooSellInZero() {
            Item[] items = new Item[]{new Item("foo", 0, 1)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }

        @Test
        @DisplayName("foo가치갱신")
        void fooUpdate() {
            Item[] items = new Item[]{new Item("foo", 1, 1)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }
    }

    @Nested
    @DisplayName("AgedBrie 테스트")
    class AgedBrieTest {
        @Test
        @DisplayName("AgedBrie 갱신")
        void agedBrieUpdate() {
            Item[] items = new Item[]{new Item("Aged Brie", 2, 0)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(1, app.items[0].quality);
        }

        @Test
        @DisplayName("AgedBrie 가치 최대")
        void agedBrieMax() {
            Item[] items = new Item[]{new Item("Aged Brie", 2, 50)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertNotEquals(51, app.items[0].quality);
        }

        @Test
        @DisplayName("sellin 0일때 AgedBrie 갱신 증가")
        void agedBrie() {
            Item[] items = new Item[]{new Item("Aged Brie", 0, 20)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(22, app.items[0].quality);
        }
    }

    @Nested
    @DisplayName("BackstagePasses 테스트")
    class BackstagePasses {
        @Test
        @DisplayName("기본 갱신")
        void backstagePassesUpdate() {
            Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(21, app.items[0].quality);
        }

        @Test
        @DisplayName("10일전 갱신")
        void backstagePassesUpdate2() {
            Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(22, app.items[0].quality);
        }

        @Test
        @DisplayName("5일전 갱신")
        void backstagePassesUpdate3() {
            Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(23, app.items[0].quality);
        }

        @Test
        @DisplayName("5일전 갱신 최대값")
        void backstagePassesUpdate4() {
            Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertNotEquals(52, app.items[0].quality);
        }

        @Test
        @DisplayName("공연 종료")
        void backstagePassesUpdateZero() {
            Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }
    }

    @Test
    @DisplayName("전설템 가치 고정")
    void sulfurasUpdate() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Nested
    @DisplayName("Conjured 테스트")
    class ConjuredTest {
        @Test
        @DisplayName("갱신")
        void conjuredUpdate() {
            Item[] items = new Item[]{new Item("Conjured Mana Cake", 3, 6)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(4, app.items[0].quality);
        }

        @Test
        @DisplayName("sellin 0 갱신")
        void conjuredUpdate2() {
            Item[] items = new Item[]{new Item("Conjured Mana Cake", 0, 6)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(2, app.items[0].quality);
        }

        @Test
        @DisplayName("sellin 0, quality 1일때 갱신")
        void conjuredUpdate3() {
            Item[] items = new Item[]{new Item("Conjured Mana Cake", 0, 1)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }
    }

}
