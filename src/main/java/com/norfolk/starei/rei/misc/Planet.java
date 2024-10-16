package com.norfolk.starei.rei.misc;

import com.github.alexnijjar.ad_astra.registry.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public enum Planet {
    EARTH("earth", Items.ANDESITE),
    MOON("moon", ModItems.MOON_COBBLESTONE),
    MARS("mars", ModItems.MARS_COBBLESTONE),
    MERCURY("mercury", ModItems.MERCURY_COBBLESTONE),
    VENUS("venus", ModItems.VENUS_COBBLESTONE),
    GLACIO("glacio", ModItems.GLACIO_COBBLESTONE);

    Planet(String name, Item item) {
        this.name = name;
        this.item = item;
    }

    private final String name;
    private final Item item;

    public Item getItem() {
        return item;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return "ad_astra:textures/sky/" + name + ".png";
    }

    public Identifier getIdentifier() {
        return new Identifier(this.getPath());
    }
}
