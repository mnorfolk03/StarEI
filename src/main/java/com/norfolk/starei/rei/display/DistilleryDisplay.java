package com.norfolk.starei.rei.display;


import com.norfolk.starei.rei.StarEICategories;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.InputIngredient;
import me.shedaniel.rei.api.common.transfer.info.MenuInfo;
import me.shedaniel.rei.api.common.transfer.info.MenuSerializationContext;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DistilleryDisplay extends BasicDisplay {
    public DistilleryDisplay(EntryStack<?> in, EntryStack<?> in2, EntryStack<?> out, long time, double energy, boolean superheated) {
        super(Arrays.asList(EntryIngredient.of(in), EntryIngredient.of(in2)),
                Collections.singletonList(EntryIngredient.of(out)));
        this.time = time;
        this.energy = energy;
        this.super_heated = superheated;
    }


    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return StarEICategories.DISTILLERY;
    }

    @Override
    public List<InputIngredient<EntryStack<?>>> getInputIngredients(MenuSerializationContext<?, ?, ?> context, MenuInfo<?, ?> info, boolean fill) {
        return super.getInputIngredients(context, info, fill);
    }

    public long getTime() {
        return time;
    }

    public double getEnergy() {
        return energy;
    }

    public boolean isSuperheated() {
        return super_heated;
    }

    private final long time;
    private final double energy;

    private final boolean super_heated;
}
