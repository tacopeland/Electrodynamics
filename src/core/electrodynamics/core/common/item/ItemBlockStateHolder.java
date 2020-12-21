package electrodynamics.core.common.item;

import electrodynamics.core.common.blockprefab.BlockStateHolder;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockStateHolder extends ItemBlock {
	public ItemBlockStateHolder(BlockStateHolder<?> block) {
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public String getTranslationKey(ItemStack stack) {
		return super.getTranslationKey() + "." + stack.getMetadata();
	}
}