package com.norfolk.starei.rei.category;

import com.norfolk.starei.rei.StarEICategories;
import com.norfolk.starei.rei.display.GasMixerDisplay;
import com.norfolk.starei.rei.display.StoneGrowthDisplay;
import com.norfolk.starei.rei.misc.CustomMachinery;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import techreborn.compat.rei.ReiPlugin;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GasMixerCategory implements DisplayCategory<GasMixerDisplay> {
    @Override
    public CategoryIdentifier<? extends GasMixerDisplay> getCategoryIdentifier() {
        return StarEICategories.GAS_MIXER;
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("category.starei.gas_mixer");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(CustomMachinery.GAS_MIXER);
    }

    @Override
    public List<Widget> setupDisplay(GasMixerDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 41, bounds.getCenterY() - 13);

        List<Widget> widgets = new ArrayList<>();
        widgets.add(Widgets.createRecipeBase(bounds));

        widgets.add(ReiPlugin.createFluidDisplay(new Rectangle(bounds.x + 10, bounds.y + 8, 16, 50), display.getInputEntries().get(0).get(0).cast(), ReiPlugin.EntryAnimation.downwards(5000)));

        int offset = display.itemCount() == 1 ? 0 : -9;
        widgets.add(Widgets.createSlot(new Point(bounds.x + 34, bounds.y + 26 + offset)).entries(display.getInputEntries().get(1)).markInput());
        if (display.itemCount() >= 2)
            widgets.add(Widgets.createSlot(new Point(bounds.x + 34, bounds.y + 26 + 9)).entries(display.getInputEntries().get(2)).markInput());


        widgets.add(Widgets.createArrow(new Point(startPoint.x + 27, startPoint.y + 4)));

        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 61 + 16, startPoint.y + 5)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 61 + 16, startPoint.y + 5)).entries(display.getOutputEntries().get(0)).disableBackground().markOutput());

        return widgets;
    }

}
