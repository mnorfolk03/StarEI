package com.norfolk.starei.rei.display;


import com.norfolk.starei.rei.StarEICategories;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.InputIngredient;
import me.shedaniel.rei.api.common.transfer.info.MenuInfo;
import me.shedaniel.rei.api.common.transfer.info.MenuSerializationContext;
import net.minecraft.text.MutableText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

import java.util.Collections;
import java.util.List;

public class SlimeFurnaceDisplay extends BasicDisplay {
    public SlimeFurnaceDisplay(EntryIngredient in, double su, double speed, long duration) {
        super(Collections.singletonList(in), Collections.emptyList());
        this.su = su;
        this.speed = speed;
        this.duration = duration;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return StarEICategories.SLIME_FURNACE;
    }

    public MutableText firstLine() {
        return new TranslatableText("starei.slime_furnace.text1", (long) su, (long) speed).formatted(Formatting.GRAY);
    }

    public MutableText secondLine() {
        return new TranslatableText("starei.slime_furnace.text2", duration / 20).formatted(Formatting.GRAY);
    }

    private final double su;
    private final double speed;
    private final long duration;
}