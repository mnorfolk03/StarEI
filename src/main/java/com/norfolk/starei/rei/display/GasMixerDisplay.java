package com.norfolk.starei.rei.display;


import com.norfolk.starei.rei.StarEICategories;
import dev.architectury.fluid.FluidStack;
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

public class GasMixerDisplay extends BasicDisplay {
    public GasMixerDisplay(EntryStack<?> fluid, EntryStack<?> in1, EntryStack<?> in2, EntryStack<?> out) {
        super(Arrays.asList(EntryIngredient.of(fluid), EntryIngredient.of(in1), EntryIngredient.of(in2)), Collections.singletonList(EntryIngredient.of(out)));
    }

    public GasMixerDisplay(EntryStack<?> fluid, EntryStack<?> in1, EntryStack<?> out) {
        super(Arrays.asList(EntryIngredient.of(fluid), EntryIngredient.of(in1)), Collections.singletonList(EntryIngredient.of(out)));
    }


    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return StarEICategories.GAS_MIXER;
    }

    public int itemCount() {
        return super.inputs.size() - 1;
    }
}
