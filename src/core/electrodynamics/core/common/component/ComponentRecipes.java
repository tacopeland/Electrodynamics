package electrodynamics.core.common.component;

import electrodynamics.core.common.block.state.EnumOreState;
import electrodynamics.core.common.item.subtypes.EnumBlend;
import electrodynamics.core.common.item.subtypes.EnumIngot;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ComponentRecipes {// TODO: Remember tool recipes
	public static void init() {
		GameRegistry.addSmelting(Items.IRON_INGOT, new ItemStack(ComponentItems.ingotBase, 1, 3), 0.3f);

		GameRegistry.addSmelting(new ItemStack(ComponentBlocks.blockOre, 1, EnumOreState.copper.ordinal()),
				new ItemStack(ComponentItems.ingotBase, 1, EnumIngot.copper.ordinal()), 0.7f);
		GameRegistry.addSmelting(new ItemStack(ComponentBlocks.blockOre, 1, EnumOreState.tin.ordinal()),
				new ItemStack(ComponentItems.ingotBase, 1, EnumIngot.tin.ordinal()), 0.7f);
		GameRegistry.addSmelting(new ItemStack(ComponentBlocks.blockOre, 1, EnumOreState.silver.ordinal()),
				new ItemStack(ComponentItems.ingotBase, 1, EnumIngot.silver.ordinal()), 0.7f);
		GameRegistry.addSmelting(new ItemStack(ComponentBlocks.blockOre, 1, EnumOreState.lead.ordinal()),
				new ItemStack(ComponentItems.ingotBase, 1, EnumIngot.lead.ordinal()), 0.7f);
		GameRegistry.addSmelting(new ItemStack(ComponentBlocks.blockOre, 1, EnumOreState.vanadinite.ordinal()),
				new ItemStack(ComponentItems.ingotBase, 1, EnumIngot.vanadium.ordinal()), 0.7f);

		GameRegistry.addSmelting(new ItemStack(ComponentItems.blendBase, 1, EnumBlend.iron.ordinal()),
				new ItemStack(Items.IRON_INGOT), 0.3f);
		GameRegistry.addSmelting(new ItemStack(ComponentItems.blendBase, 1, EnumBlend.gold.ordinal()),
				new ItemStack(Items.GOLD_INGOT), 0.3f);
		GameRegistry.addSmelting(new ItemStack(ComponentItems.blendBase, 1, EnumBlend.copper.ordinal()),
				new ItemStack(ComponentItems.ingotBase, 1, EnumIngot.copper.ordinal()), 0.45f);
		GameRegistry.addSmelting(new ItemStack(ComponentItems.blendBase, 1, EnumBlend.tin.ordinal()),
				new ItemStack(ComponentItems.ingotBase, 1, EnumIngot.tin.ordinal()), 0.45f);
		GameRegistry.addSmelting(new ItemStack(ComponentItems.blendBase, 1, EnumBlend.silver.ordinal()),
				new ItemStack(ComponentItems.ingotBase, 1, EnumIngot.silver.ordinal()), 0.45f);
		GameRegistry.addSmelting(new ItemStack(ComponentItems.blendBase, 1, EnumBlend.steel.ordinal()),
				new ItemStack(ComponentItems.ingotBase, 1, EnumIngot.steel.ordinal()), 0.45f);
		GameRegistry.addSmelting(new ItemStack(ComponentItems.blendBase, 1, EnumBlend.lead.ordinal()),
				new ItemStack(ComponentItems.ingotBase, 1, EnumIngot.lead.ordinal()), 0.45f);
		GameRegistry.addSmelting(new ItemStack(ComponentItems.blendBase, 1, EnumBlend.bronze.ordinal()),
				new ItemStack(ComponentItems.ingotBase, 1, EnumIngot.bronze.ordinal()), 0.45f);
		GameRegistry.addSmelting(new ItemStack(ComponentItems.blendBase, 1, EnumBlend.superconductive.ordinal()),
				new ItemStack(ComponentItems.ingotBase, 1, EnumIngot.superconductive.ordinal()), 0.45f);
		GameRegistry.addSmelting(new ItemStack(ComponentItems.blendBase, 1, EnumBlend.vanadium.ordinal()),
				new ItemStack(ComponentItems.ingotBase, 1, EnumIngot.vanadium.ordinal()), 0.45f);
	}

}
