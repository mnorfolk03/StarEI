package com.norfolk.starei.rei.category;

import com.norfolk.starei.rei.StarEICategories;
import com.norfolk.starei.rei.display.DistilleryDisplay;
import com.norfolk.starei.rei.display.ShimmerRefineryDisplay;
import com.norfolk.starei.rei.misc.CustomMachinery;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.ClientHelper;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Tooltip;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import reborncore.client.gui.guibuilder.GuiBuilder;
import techreborn.compat.rei.ReiPlugin;
import techreborn.init.TRContent;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.simibubi.create.AllItems.BLAZE_CAKE;

public class DistilleryCategory implements DisplayCategory<DistilleryDisplay> {
    @Override
    public CategoryIdentifier<? extends DistilleryDisplay> getCategoryIdentifier() {
        return StarEICategories.DISTILLERY;
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("category.starei.distillery");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(CustomMachinery.DISTILLATION_TOWER);
    }

    @Override
    public List<Widget> setupDisplay(DistilleryDisplay display, Rectangle bounds) {
        List<Widget> widgets = new ArrayList<>();

        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(ReiPlugin.createEnergyDisplay(new Rectangle(bounds.x + 8, bounds.y + 8, 14, 50), display.getEnergy(), ReiPlugin.EntryAnimation.downwards(5000), point -> {
            List<Text> list = new ArrayList<>();
            list.add(Text.of("Energy"));
            list.add(new TranslatableText("techreborn.jei.recipe.start.cost", display.getEnergy()).formatted(Formatting.GRAY).append("E"));
            list.add(Text.of(""));
            list.add(ClientHelper.getInstance().getFormattedModFromIdentifier(new Identifier("techreborn", "")));
            return Tooltip.create(point, list);
        }));

        widgets.add(Widgets.createSlot(new Point(bounds.x + 46, bounds.y + 14)).entries(display.getInputEntries().get(0)).markInput());
        widgets.add(Widgets.createSlot(new Point(bounds.x + 46, bounds.y + 38)).entries(display.getInputEntries().get(1)).markInput());
        widgets.add(Widgets.createResultSlotBackground(new Point(bounds.x + 46 + 46, bounds.y + 26)));
        widgets.add(Widgets.createSlot(new Point(bounds.x + 46 + 46, bounds.y + 26)).entries(display.getOutputEntries().get(0)).disableBackground().markOutput());

        if (display.isSuperheated()) {
            widgets.add(Widgets.createSlot(new Point(bounds.x + 46 + 21, bounds.y + 46)).entries(Collections.singletonList(EntryStacks.of(BLAZE_CAKE.asStack()))).markInput());
        }
        widgets.add(ReiPlugin.createProgressBar(bounds.x + 46 + 21, bounds.y + 30, display.getTime() * 50, GuiBuilder.ProgressDirection.RIGHT));

        widgets.add(Widgets.createLabel(new Point(bounds.getMaxX() - 5, bounds.y + 5), new TranslatableText("techreborn.jei.recipe.processing.time.3", new DecimalFormat("###.##").format(display.getTime() / 20.0)))
                .shadow(false)
                .rightAligned()
                .color(0xFF404040, 0xFFBBBBBB)
        );
        return widgets;
    }
}