package com.norfolk.starei.rei.misc;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtString;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Misc static variables that are useful
 */
public class CustomMachinery {
    public static final Item CUSTOM_MACHINE = Registry.ITEM.get(new Identifier("custommachinery", "custom_machine_item"));


    /**
     * Returns an Item Stack for the customMachine
     *
     * @param name the name of the custom machine. For example: "createastral:electrolyser"
     * @return the Item Stack
     */
    public static ItemStack customMachine(String name) {
        var ret = new ItemStack(CUSTOM_MACHINE);
        NbtCompound tag = new NbtCompound();
        tag.put("machine", NbtString.of(name));
        ret.setNbt(tag);
        return ret;
    }

    public static final ItemStack ELECTROLYZER = customMachine("createastral:electrolyser");
    public static final ItemStack STONE_GROWTH = customMachine("createastral:stone_growth_chamber");
    public static final ItemStack SLIME_FURNACE = customMachine("createastral:slime_furnace");
    public static final ItemStack CHANNELING_TRANSFORMER = customMachine("createastral:channeling_transformer");
    public static final ItemStack GAS_MIXER = customMachine("createastral:gas_mixer");
    public static final ItemStack DISTILLATION_TOWER = customMachine("createastral:distillery");
    public static final ItemStack SHIMMER_REFINERY = customMachine("createastral:shimmer_refinery");
}
