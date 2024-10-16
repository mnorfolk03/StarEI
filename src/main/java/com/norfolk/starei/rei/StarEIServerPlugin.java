package com.norfolk.starei.rei;

import com.norfolk.starei.rei.misc.CustomMachinery;
import me.shedaniel.rei.api.common.entry.comparison.FluidComparatorRegistry;
import me.shedaniel.rei.api.common.entry.comparison.ItemComparatorRegistry;
import me.shedaniel.rei.api.common.plugins.REIServerPlugin;

public class StarEIServerPlugin implements REIServerPlugin {

    @Override
    public void registerFluidComparators(FluidComparatorRegistry registry) {
        REIServerPlugin.super.registerFluidComparators(registry);
    }

    @Override
    public void registerItemComparators(ItemComparatorRegistry registry) {
        REIServerPlugin.super.registerItemComparators(registry);
        registry.registerNbt(CustomMachinery.CUSTOM_MACHINE);
    }
}
