package com.norfolk.starei.rei.category;

import com.norfolk.starei.rei.StarEICategories;
import com.norfolk.starei.rei.display.ElectrolyzerDisplay;
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
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class StoneGrowthCategory implements DisplayCategory<StoneGrowthDisplay> {
    @Override
    public CategoryIdentifier<? extends StoneGrowthDisplay> getCategoryIdentifier() {
        return StarEICategories.STONE_GROWTH;
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("category.starei.stone_growth");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(CustomMachinery.STONE_GROWTH);
    }

    @Override
    public List<Widget> setupDisplay(StoneGrowthDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 41, bounds.getCenterY() - 13);
        List<Widget> widgets = new ArrayList<>();
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createArrow(new Point(startPoint.x + 27, startPoint.y + 4)));
        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 61, startPoint.y + 5)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 4, startPoint.y + 5)));
        Rectangle planetBounds = new Rectangle(startPoint.x + 4, startPoint.y + 5, 16, 16);
        var planet = Widgets.createTexturedWidget(display.getPlanet().getIdentifier(), planetBounds, 0, 0, 16, 16);
        widgets.add(Widgets.withTooltip(Widgets.withBounds(planet, planetBounds),
                new TranslatableText("starei.planet." + display.getPlanet().getName())));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 61, startPoint.y + 5))
                .entries(display.getOutputEntries().get(0)).disableBackground().markOutput());
        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 36;
    }
}
