package electrodynamics.core.common.blockprefab.state;

import electrodynamics.core.common.blockprefab.BlockRotatable;
import electrodynamics.core.common.blockprefab.property.PropertySingle;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.EnumFacing;

public class BlockStateFacing extends BlockStateContainer {
	public static final PropertySingle<EnumFacing> FACING = PropertySingle.createProperty("facing",
			EnumFacing.Plane.HORIZONTAL, EnumFacing.class);

	public BlockStateFacing(BlockRotatable<?> block) {
		super(block, FACING);
	}

	public BlockStateFacing(BlockRotatable<?> block, PropertyEnum<?> typeProperty) {
		super(block, FACING, typeProperty);
	}
}