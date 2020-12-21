package electrodynamics.core.common.blockprefab;

import electrodynamics.core.common.blockprefab.state.IBlockStateInfo;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public abstract class BlockContainerBase<T extends Enum<T> & IBlockStateInfo> extends BlockStateHolder<T> {
	public BlockContainerBase(Material material, String name) {
		super(material, name);
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
}