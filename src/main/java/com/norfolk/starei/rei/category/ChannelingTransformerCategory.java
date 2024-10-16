package com.norfolk.starei.rei.category;

import com.norfolk.starei.rei.StarEICategories;
import com.norfolk.starei.rei.display.ChannelingTransformerDisplay;
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

import java.util.ArrayList;
import java.util.List;

import static com.norfolk.starei.rei.misc.CustomMachinery.CHANNELING_TRANSFORMER;

public class ChannelingTransformerCategory implements DisplayCategory<ChannelingTransformerDisplay> {
    @Override
    public CategoryIdentifier<? extends ChannelingTransformerDisplay> getCategoryIdentifier() {
        return StarEICategories.CHANNELING_TRANSFORMER;
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("category.starei.channeling_transformer");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(CHANNELING_TRANSFORMER);
    }

    @Override
    public List<Widget> setupDisplay(ChannelingTransformerDisplay display, Rectangle bounds) {
        List<Widget> widgets = new ArrayList<>();
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(ReiPlugin.createEnergyDisplay(new Rectangle(bounds.x + 108, bounds.y + 8, 14, 50), display.getTotalEnergy(), ReiPlugin.EntryAnimation.upwards(5000), point -> {
            List<Text> list = new ArrayList<>();
            list.add(Text.of("Energy"));
            list.add(new TranslatableText("techreborn.jei.recipe.generator.total", display.getTotalEnergy()).formatted(Formatting.GRAY));
            list.add(Text.of(""));
            list.add(ClientHelper.getInstance().getFormattedModFromIdentifier(new Identifier("techreborn", "")));
            return Tooltip.create(point, list);
        }));
        widgets.add(ReiPlugin.createFluidDisplay(new Rectangle(bounds.x + 16, bounds.y + 8, 16, 50), display.getInputEntries().get(0).get(0).cast(), ReiPlugin.EntryAnimation.downwards(5000)));
        widgets.add(ReiPlugin.createProgressBar(bounds.x + 76 - 16, bounds.y + 48 - 19, 5000, GuiBuilder.ProgressDirection.RIGHT));
        return widgets;
    }
}