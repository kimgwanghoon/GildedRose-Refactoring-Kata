package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GildedRoseTest {

    private Item[] items;
    private GildedRose app;
    private static final String FOO = "foo";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";

    public void gildedRoseTestSet(Item item) {
        this.items = new Item[]{item};
        this.app = new GildedRose(items);
    }

    @Nested
    @DisplayName("기본 아이템")
    class FooTest {
        @Test
        @DisplayName("foo기간만료")
        void fooSellInZero() {
            gildedRoseTestSet(new Item(FOO, 0, 1));
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }

        @Test
        @DisplayName("foo가치갱신")
        void fooUpdate() {
            gildedRoseTestSet(new Item(FOO, 1, 1));
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }

        @Test
        @DisplayName("foo가치0")
        void fooUpdate마이너스() {
            gildedRoseTestSet(new Item(FOO, 0, 0));
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
            gildedRoseTestSet(new Item(AGED_BRIE, 2, 0));
            app.updateQuality();
            assertEquals(1, app.items[0].quality);
        }

        @Test
        @DisplayName("가치 최대")
        void agedBrieMax() {
            gildedRoseTestSet(new Item(AGED_BRIE, 2, 50));
            app.updateQuality();
            assertNotEquals(51, app.items[0].quality);
        }

        @Test
        @DisplayName("sellin 0일때 AgedBrie 2배증가")
        void agedBrie() {
            gildedRoseTestSet(new Item(AGED_BRIE, 0, 20));
            app.updateQuality();
            assertEquals(22, app.items[0].quality);
        }
    }

    @Nested
    @DisplayName("BackstagePasses 테스트")
    class BackstagePasses {
        @Test
        @DisplayName("기본갱신")
        void backstagePassesUpdate() {
            gildedRoseTestSet(new Item(BACKSTAGE_PASSES, 15, 20));
            app.updateQuality();
            assertEquals(21, app.items[0].quality);
        }

        @Test
        @DisplayName("10일전 갱신")
        void backstagePassesUpdate2() {
            gildedRoseTestSet(new Item(BACKSTAGE_PASSES, 10, 20));
            app.updateQuality();
            assertEquals(22, app.items[0].quality);
        }

        @Test
        @DisplayName("5일전 갱신")
        void backstagePassesUpdate3() {
            gildedRoseTestSet(new Item(BACKSTAGE_PASSES, 5, 20));
            app.updateQuality();
            assertEquals(23, app.items[0].quality);
        }

        @Test
        @DisplayName("5일전 갱신 최대초과")
        void backstagePassesUpdate4() {
            gildedRoseTestSet(new Item(BACKSTAGE_PASSES, 5, 49));
            app.updateQuality();
            assertNotEquals(52, app.items[0].quality);
            assertEquals(50, app.items[0].quality);
        }

        @Test
        @DisplayName("종료")
        void backstagePassesUpdateZero() {
            gildedRoseTestSet(new Item(BACKSTAGE_PASSES, 0, 20));
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }
    }

    @Test
    @DisplayName("전설탬 고정")
    void sulfurasUpdate() {
        gildedRoseTestSet(new Item(SULFURAS, 0, 80));
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Nested
    @DisplayName("Conjured 테스트")
    class ConjuredTest {
        @Test
        @DisplayName("갱신")
        void conjuredUpdate() {
            gildedRoseTestSet(new Item(CONJURED, 3, 6));
            app.updateQuality();
            assertEquals(4, app.items[0].quality);
        }

        @Test
        @DisplayName("sellin 0 갱신")
        void conjuredUpdate2() {
            gildedRoseTestSet(new Item(CONJURED, 0, 6));
            app.updateQuality();
            assertEquals(2, app.items[0].quality);
        }

        @Test
        @DisplayName("sellin 0, quality 1일때 갱신")
        void conjuredUpdate3() {
            gildedRoseTestSet(new Item(CONJURED, 0, 1));
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }
    }

}
