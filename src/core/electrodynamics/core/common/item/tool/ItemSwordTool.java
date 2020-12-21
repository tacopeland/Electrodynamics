package electrodynamics.core.common.item.tool;

import electrodynamics.core.Electrodynamics;
import electrodynamics.core.common.component.ComponentsTab;
import net.minecraft.item.ItemSword;

public class ItemSwordTool extends ItemSword {
	public final String baseName;

	public void registerItemModel(String folder) {
		String prefix = folder.isEmpty() ? folder : folder + "/";
		Electrodynamics.proxy.registerItemRenderer(this, 0, prefix + baseName);
	}

	public ItemSwordTool(String name, ToolMaterial material) {
		super(material);
		baseName = name;
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(ComponentsTab.BASICCOMPONENTS);
	}

}
