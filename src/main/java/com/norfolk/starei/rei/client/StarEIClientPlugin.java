package com.norfolk.starei.rei.client;

import com.github.alexnijjar.ad_astra.registry.ModFluids;
import com.github.alexnijjar.ad_astra.registry.ModItems;
import com.norfolk.starei.rei.category.*;
import com.norfolk.starei.rei.display.*;
import com.norfolk.starei.rei.misc.CustomMachinery;
import com.norfolk.starei.rei.StarEICategories;
import com.norfolk.starei.rei.misc.Planet;
import com.simibubi.create.AllTags;
import dev.architectury.fluid.FluidStack;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import techreborn.init.TRContent;

import static com.norfolk.starei.rei.misc.CustomMachinery.CUSTOM_MACHINE;
import static com.norfolk.starei.rei.misc.CustomMachinery.SHIMMER_REFINERY;


public class StarEIClientPlugin implements REIClientPlugin {
    EntryStack<ItemStack> entryItem(String namespace, String item) {
        return EntryStacks.of(Registry.ITEM.get(new Identifier(namespace, item)));
    }

    EntryStack<FluidStack> entryFluid(String namespace, String item, long amt) {
        return EntryStacks.of(Registry.FLUID.get(new Identifier(namespace, item)),amt);
    }

    @Override
    public void registerCategories(CategoryRegistry registry) {
        REIClientPlugin.super.registerCategories(registry);
        registry.add(new ElectrolyzerCategory());
        registry.addWorkstations(StarEICategories.ELECTROLYZER, EntryStacks.of(CustomMachinery.ELECTROLYZER));


        registry.add(new StoneGrowthCategory());
        registry.addWorkstations(StarEICategories.STONE_GROWTH, EntryStacks.of(CustomMachinery.STONE_GROWTH));

        registry.add(new ChannelingTransformerCategory());
        registry.addWorkstations(StarEICategories.CHANNELING_TRANSFORMER, EntryStacks.of(CustomMachinery.CHANNELING_TRANSFORMER));

        registry.add(new ShimmerRefineryCategory());
        registry.addWorkstations(StarEICategories.SHIMMER_REFINERY, EntryStacks.of(SHIMMER_REFINERY));

        registry.add(new DistilleryCategory());
        registry.addWorkstations(StarEICategories.DISTILLERY, EntryStacks.of(CustomMachinery.DISTILLATION_TOWER));

        registry.add(new GasMixerCategory());
        registry.addWorkstations(StarEICategories.GAS_MIXER, EntryStacks.of(CustomMachinery.GAS_MIXER));

        registry.add(new SlimeFurnaceCategory());
        registry.addWorkstations(StarEICategories.SLIME_FURNACE, EntryStacks.of(CustomMachinery.SLIME_FURNACE));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        REIClientPlugin.super.registerDisplays(registry);

        registry.add(new ElectrolyzerDisplay(EntryStacks.of(Fluids.WATER,8100), EntryStacks.of(ModFluids.OXYGEN_STILL,860)));
        registry.add(new ElectrolyzerDisplay(entryFluid("kubejs", "hellfire",810), entryFluid("kubejs", "smite",8100)));

        for (Planet planet : Planet.values()) {
            registry.add(new StoneGrowthDisplay(planet, EntryStacks.of(planet.getItem())));
        }

        registry.add(new ChannelingTransformerDisplay(entryFluid("kubejs", "smite",81000), 720000));
        registry.add(new ShimmerRefineryDisplay(entryItem("createastral", "refining_agent"), entryFluid("kubejs", "shimmer",81000),
                EntryStacks.of(TRContent.Parts.UU_MATTER), 125, 20000));

        registry.add(new DistilleryDisplay(entryItem("createastral", "pure_biomatter"), EntryStacks.of(Fluids.WATER,81000),
                entryFluid("techreborn", "biofuel",324000), 100, 10000, false));
        registry.add(new DistilleryDisplay(entryItem("createastral", "refining_agent"), entryFluid("techreborn", "oil",81000),
                entryFluid("kubejs", "hellfire",81000), 100, 10000, false));
        registry.add(new DistilleryDisplay(entryItem("createastral", "refining_agent"), entryFluid("techreborn", "oil",81000),
                entryFluid("kubejs", "hellfire",81000), 100, 2500, true));
        registry.add(new DistilleryDisplay(entryItem("createastral", "uranium_residue"), entryFluid("techreborn", "mercury",81000),
                entryFluid("tconstruct", "molten_uranium",81000), 200, 10000, true));


        registry.add(new GasMixerDisplay(entryFluid("techreborn", "methane",81000/4),
                EntryStacks.of(Items.OXEYE_DAISY), EntryStacks.of(Items.GHAST_TEAR)));
        registry.add(new GasMixerDisplay(EntryStacks.of(ModFluids.OXYGEN_STILL), EntryStacks.of(Items.WITHER_ROSE),
                EntryStacks.of(new ItemStack(Items.GLASS_BOTTLE, 3)),
                EntryStacks.of(new ItemStack(Items.DRAGON_BREATH, 3))));

        registry.add(new GasMixerDisplay(entryFluid("techreborn", "mercury",81000/81),
                EntryStacks.of(new ItemStack(Items.LILY_OF_THE_VALLEY, 2)),
                EntryStacks.of(Items.SPIDER_EYE, 3)));


        var slimeballs = EntryIngredient.builder();
        var slimeblocks = EntryIngredient.builder();

        slimeballs.add(entryItem("minecraft", "slime_ball"));
        slimeblocks.add(entryItem("minecraft", "slime_block"));
        for (String name : new String[]{"sky", "ichor", "ender", "blood"}) {
            slimeballs.add(entryItem("tconstruct", name + "_slime_ball"));
            slimeblocks.add(entryItem("tconstruct", name + "_slime"));
        }

        slimeballs.add(entryItem("createastral", "synthetic_slime"));
        slimeblocks.add(entryItem("createastral", "synthetic_slime_block"));


        registry.add(new SlimeFurnaceDisplay(slimeballs.build(), 2048, 2, 600));
        registry.add(new SlimeFurnaceDisplay(slimeblocks.build(), 2048, 2, 5400));


        registry.add(new StoneGrowthDisplay(
                EntryIngredients.ofItemTag(TagKey.of(Registry.BLOCK_KEY, new Identifier("createastral:stone_growth_chamber/building_blocks/andesite"))),
                EntryStacks.of(Items.ANDESITE)));

        registry.add(new StoneGrowthDisplay(
                EntryIngredients.ofItemTag(TagKey.of(Registry.BLOCK_KEY, new Identifier("createastral:stone_growth_chamber/building_blocks/cobblestone"))),
                EntryStacks.of(Items.COBBLESTONE)));

        registry.add(new StoneGrowthDisplay(
                EntryIngredients.ofItemTag(TagKey.of(Registry.BLOCK_KEY, new Identifier("createastral:stone_growth_chamber/building_blocks/glacio_cobblestone"))),
                EntryStacks.of(ModItems.GLACIO_COBBLESTONE)));

        registry.add(new StoneGrowthDisplay(
                EntryIngredients.ofItemTag(TagKey.of(Registry.BLOCK_KEY, new Identifier("createastral:stone_growth_chamber/building_blocks/mars_cobblestone"))),
                EntryStacks.of(ModItems.MARS_COBBLESTONE)));


        registry.add(new StoneGrowthDisplay(
                EntryIngredients.ofItemTag(TagKey.of(Registry.BLOCK_KEY, new Identifier("createastral:stone_growth_chamber/building_blocks/mercury_cobblestone"))),
                EntryStacks.of(ModItems.MERCURY_COBBLESTONE)));


        registry.add(new StoneGrowthDisplay(
                EntryIngredients.ofItemTag(TagKey.of(Registry.BLOCK_KEY, new Identifier("createastral:stone_growth_chamber/building_blocks/moon_cobblestone"))),
                EntryStacks.of(ModItems.MOON_COBBLESTONE)));


        registry.add(new StoneGrowthDisplay(
                EntryIngredients.ofItemTag(TagKey.of(Registry.BLOCK_KEY, new Identifier("createastral:stone_growth_chamber/building_blocks/venus_cobblestone"))),
                EntryStacks.of(ModItems.VENUS_COBBLESTONE)));
    }
}
