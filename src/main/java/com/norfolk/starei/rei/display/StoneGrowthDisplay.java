package com.norfolk.starei.rei.display;

import com.norfolk.starei.rei.StarEICategories;
import com.norfolk.starei.rei.misc.Planet;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.InputIngredient;
import me.shedaniel.rei.api.common.transfer.info.MenuInfo;
import me.shedaniel.rei.api.common.transfer.info.MenuSerializationContext;

import java.util.Collections;
import java.util.List;

public class StoneGrowthDisplay extends BasicDisplay {
    public StoneGrowthDisplay(Planet planet, EntryStack<?> out) {
        super(Collections.emptyList(), Collections.singletonList(EntryIngredient.of(out)));
        this.planet = planet;
    }

    public StoneGrowthDisplay(EntryIngredient in, EntryStack<?> out) {
        super(Collections.singletonList(in), Collections.singletonList(EntryIngredient.of(out)));
        this.planet = null;
    }

    private final Planet planet;

    public Planet getPlanet() {
        return planet;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return StarEICategories.STONE_GROWTH;
    }

    @Override
    public List<InputIngredient<EntryStack<?>>> getInputIngredients(MenuSerializationContext<?, ?, ?> context, MenuInfo<?, ?> info, boolean fill) {
        return super.getInputIngredients(context, info, fill);
    }

}

