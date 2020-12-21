package electrodynamics.core.common.item.tool;

import electrodynamics.core.Electrodynamics;
import electrodynamics.core.common.component.ComponentsTab;
import net.minecraft.item.ItemAxe;

public class ItemAxeTool extends ItemAxe {
	public final String baseName;

	public void registerItemModel(String folder) {
		String prefix = folder.isEmpty() ? folder : folder + "/";
		Electrodynamics.proxy.registerItemRenderer(this, 0, prefix + baseName);
	}

	public ItemAxeTool(String name, ToolMaterial material) {
		super(material, material == ToolMaterialPhysica.LEAD ? 16 : 8,
				material == ToolMaterialPhysica.LEAD ? -3.6f : -3.1f);
		baseName = name;
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(ComponentsTab.BASICCOMPONENTS);
	}
}
