package com.norfolk.starei.rei;

import com.norfolk.starei.rei.display.*;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;

public interface StarEICategories {
    CategoryIdentifier<ElectrolyzerDisplay> ELECTROLYZER = CategoryIdentifier.of("starei","plugins/electrolyzer");
    CategoryIdentifier<StoneGrowthDisplay> STONE_GROWTH = CategoryIdentifier.of("starei","plugins/stone_growth");
    CategoryIdentifier<SlimeFurnaceDisplay> SLIME_FURNACE = CategoryIdentifier.of("starei","plugins/slime_furnace");
    CategoryIdentifier<ChannelingTransformerDisplay> CHANNELING_TRANSFORMER = CategoryIdentifier.of("starei","plugins/channeling_transformer");
    CategoryIdentifier<GasMixerDisplay> GAS_MIXER = CategoryIdentifier.of("starei","plugins/gas_mixer");
    CategoryIdentifier<ShimmerRefineryDisplay> SHIMMER_REFINERY = CategoryIdentifier.of("starei","plugins/shimmer_refinery");
    CategoryIdentifier<DistilleryDisplay> DISTILLERY = CategoryIdentifier.of("starei","plugins/distillery");
}
