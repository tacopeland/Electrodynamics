package electrodynamics.core;

import org.apache.logging.log4j.Logger;

import electrodynamics.core.common.component.ComponentBlocks;
import electrodynamics.core.common.component.ComponentDictionary;
import electrodynamics.core.common.component.ComponentItems;
import electrodynamics.core.common.component.ComponentRecipes;
import electrodynamics.core.common.network.PacketHandler;
import electrodynamics.core.common.network.PacketTileEntity;
import electrodynamics.core.common.network.PacketTileEntity.PacketTileEntityMessage;
import electrodynamics.core.common.proxy.CommonProxy;
import electrodynamics.core.common.world.ComponentWorldGen;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = References.DOMAIN, name = References.NAME, version = References.VERSION)
public class Electrodynamics {
	@SidedProxy(serverSide = "electrodynamics.core.common.proxy.CommonProxy", clientSide = "electrodynamics.core.common.proxy.ClientProxy")
	public static CommonProxy proxy;

	public static Logger logger;
	public static PacketHandler packetsystem = new PacketHandler();

	@Instance(References.DOMAIN)
	public static Electrodynamics instance;

	private static int messageId;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		GameRegistry.registerWorldGenerator(new ComponentWorldGen(), 1);
		registerMessage(PacketTileEntityMessage.class, PacketTileEntity.class, Side.CLIENT);
	}

	private static <REQ extends IMessage, REPLY extends IMessage> void registerMessage(
			final Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, final Class<REQ> requestMessageType,
			final Side receivingSide) {
		PacketHandler.networkWrapper.registerMessage(messageHandler, requestMessageType, messageId++, receivingSide);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		ComponentDictionary.initOreDictionary();
		ComponentRecipes.init();
	}

	@EventBusSubscriber
	public static class RegistrationHandler {
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			ComponentItems.register(event.getRegistry());
			ComponentBlocks.registerItemBlocks(event.getRegistry());
		}

		@SubscribeEvent
		public static void registerItems(ModelRegistryEvent event) {
			ComponentItems.registerModels();
			ComponentBlocks.registerModels();
		}

		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			ComponentBlocks.register(event.getRegistry());
		}

	}

}
