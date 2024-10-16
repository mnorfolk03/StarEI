package com.norfolk.starei.rei.display;


import com.norfolk.starei.rei.StarEICategories;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.InputIngredient;
import me.shedaniel.rei.api.common.transfer.info.MenuInfo;
import me.shedaniel.rei.api.common.transfer.info.MenuSerializationContext;

import java.util.Collections;
import java.util.List;

public class ChannelingTransformerDisplay extends BasicDisplay {
    public ChannelingTransformerDisplay(EntryStack<?> in, double energy) {
        super(Collections.singletonList(EntryIngredient.of(in)), Collections.emptyList());
        this.energy = energy;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return StarEICategories.CHANNELING_TRANSFORMER;
    }

    @Override
    public List<InputIngredient<EntryStack<?>>> getInputIngredients(MenuSerializationContext<?, ?, ?> context, MenuInfo<?, ?> info, boolean fill) {
        return super.getInputIngredients(context, info, fill);
    }

    public double getTotalEnergy() {
        return energy;
    }

    private final double energy;
}

