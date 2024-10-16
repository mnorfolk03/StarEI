package com.norfolk.starei.rei.category;

import com.norfolk.starei.rei.misc.CustomMachinery;
import com.norfolk.starei.rei.StarEICategories;
import com.norfolk.starei.rei.display.ElectrolyzerDisplay;
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

public class ElectrolyzerCategory implements DisplayCategory<ElectrolyzerDisplay> {
    @Override
    public CategoryIdentifier<? extends ElectrolyzerDisplay> getCategoryIdentifier() {
        return StarEICategories.ELECTROLYZER;
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("category.starei.electrolyzer");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(CustomMachinery.ELECTROLYZER);
    }

    @Override
    public List<Widget> setupDisplay(ElectrolyzerDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 41, bounds.getCenterY() - 13);
        List<Widget> widgets = new ArrayList<>();
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createArrow(new Point(startPoint.x + 27, startPoint.y + 4)));
        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 61, startPoint.y + 5)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 4, startPoint.y + 5))
                .entries(display.getInputEntries().get(0)).markInput());

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 61, startPoint.y + 5))
                .entries(display.getOutputEntries().get(0)).disableBackground().markOutput());
        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 36;
    }
}
