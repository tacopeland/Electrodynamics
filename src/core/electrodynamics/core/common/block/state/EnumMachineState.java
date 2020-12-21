package electrodynamics.core.common.block.state;

import electrodynamics.core.common.blockprefab.state.IBlockStateInfo;
import electrodynamics.core.common.tile.TileCoalGenerator;
import electrodynamics.core.common.tile.TileElectricFurnace;
import electrodynamics.core.common.tile.TileMineralCrusher;
import electrodynamics.core.common.tile.TileMineralGrinder;
import net.minecraft.tileentity.TileEntity;

public enum EnumMachineState implements IBlockStateInfo {
	electricfurnace(TileElectricFurnace.class, "pickaxe", 1, 3f, 5f),
	electricfurnacerunning(TileElectricFurnace.class, "pickaxe", 1, 3f, 5f),
	coalgenerator(TileCoalGenerator.class, "pickaxe", 1, 3f, 5f),
	coalgeneratorrunning(TileCoalGenerator.class, "pickaxe", 1, 3f, 5f),
	mineralcrusher(TileMineralCrusher.class, "pickaxe", 1, 3f, 5f),
	mineralgrinder(TileMineralGrinder.class, "pickaxe", 1, 3f, 5f);

	private Class<? extends TileEntity> classType;
	private String harvestTool;
	private int harvestLevel;
	private float hardness;
	private float resistance;

	private EnumMachineState(Class<? extends TileEntity> classType, String harvestTool, int harvestLevel,
			float hardness, float resistance) {
		this.classType = classType;
		this.harvestTool = harvestTool;
		this.harvestLevel = harvestLevel;
		this.hardness = hardness;
		this.resistance = resistance;
	}

	@Override
	public String getName() {
		return name();
	}

	@Override
	public int getHarvestLevel() {
		return harvestLevel;
	}

	@Override
	public String getHarvestTool() {
		return harvestTool;
	}

	@Override
	public float getHardness() {
		return hardness;
	}

	@Override
	public float getResistance() {
		return resistance;
	}

	public TileEntity createTileInstance() {
		try {
			return classType.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
