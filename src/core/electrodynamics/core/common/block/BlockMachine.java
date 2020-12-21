package electrodynamics.core.common.block;

import electrodynamics.core.Electrodynamics;
import electrodynamics.core.common.block.state.EnumMachineState;
import electrodynamics.core.common.blockprefab.BlockRotatable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class BlockMachine extends BlockRotatable<EnumMachineState> {

	protected BlockMachine(String name, Material material) {
		super(name, material);
	}

	public BlockMachine(String name) {
		this(name, Material.IRON);
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (EnumMachineState ems : getEnumValuesByMeta()) {
			if (!ems.name().contains("running")) {
				items.add(new ItemStack(this, 1, ems.ordinal()));
			}
		}
	}

	@Override
	public void registerItemModel(Item itemBlock) {
		for (EnumMachineState ems : getEnumValuesByMeta()) {
			Electrodynamics.proxy.registerBlockItemRenderer(itemBlock, ems.ordinal(), name,
					"facing=north,state=" + ems.getName());
		}
	}

	@Override
	public Class<EnumMachineState> getStateEnumClass() {
		return EnumMachineState.class;
	}

	@Override
	public EnumMachineState getDefaultStateEnum() {
		return EnumMachineState.electricfurnace;
	}

	@Override
	public EnumMachineState[] getEnumValuesByMeta() {
		return EnumMachineState.values();
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		EnumMachineState machineState = state.getValue(getStateProperty());
		return machineState.createTileInstance();
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isTranslucent(IBlockState state) {
		return true;
	}

	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}

}
