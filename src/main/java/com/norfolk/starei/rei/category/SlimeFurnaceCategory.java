package com.norfolk.starei.rei.category;

import com.norfolk.starei.rei.StarEICategories;
import com.norfolk.starei.rei.display.SlimeFurnaceDisplay;
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

import java.util.ArrayList;
import java.util.List;

public class SlimeFurnaceCategory implements DisplayCategory<SlimeFurnaceDisplay> {
    @Override
    public CategoryIdentifier<? extends SlimeFurnaceDisplay> getCategoryIdentifier() {
        return StarEICategories.SLIME_FURNACE;
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("category.starei.slime_furnace");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(CustomMachinery.SLIME_FURNACE);
    }

    @Override
    public List<Widget> setupDisplay(SlimeFurnaceDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 41, bounds.getCenterY() - 13);

        List<Widget> widgets = new ArrayList<>();
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createSlot(new Point(startPoint.x - 24, startPoint.y + 5)).entries(display.getInputEntries().get(0)).markInput());

        widgets.add(Widgets.createLabel(new Point(startPoint.x + 61, startPoint.y + 5), display.firstLine()));
        widgets.add(Widgets.createLabel(new Point(startPoint.x + 61, startPoint.y + 15), display.secondLine()));
        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 36;
    }
}
