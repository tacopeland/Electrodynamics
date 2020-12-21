package electrodynamics.core.common.component;

import electrodynamics.core.common.block.state.EnumOreState;
import electrodynamics.core.common.item.subtypes.EnumBlend;
import electrodynamics.core.common.item.subtypes.EnumImpureBlend;
import electrodynamics.core.common.item.subtypes.EnumIngot;
import electrodynamics.core.common.item.subtypes.EnumPlate;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ComponentDictionary {
	public static void initOreDictionary() {
		for (EnumIngot ingot : EnumIngot.values()) {
			OreDictionary.registerOre(ingot.getOre(), ComponentItems.ingotBase.createStackFromSubtype(ingot.ordinal()));
		}
		for (EnumBlend blend : EnumBlend.values()) {
			OreDictionary.registerOre(blend.getOre(), ComponentItems.blendBase.createStackFromSubtype(blend.ordinal()));
		}
		for (EnumImpureBlend blend : EnumImpureBlend.values()) {
			OreDictionary.registerOre(blend.getOre(), ComponentItems.blendBase.createStackFromSubtype(blend.ordinal()));
		}
		for (EnumPlate plate : EnumPlate.values()) {
			OreDictionary.registerOre(plate.getOre(), ComponentItems.plateBase.createStackFromSubtype(plate.ordinal()));
		}
		for (EnumOreState ore : EnumOreState.values()) {
			OreDictionary.registerOre(ore.getName(), new ItemStack(ComponentBlocks.blockOre, 1, ore.ordinal()));
		}
	}
}
