package net.krugovov.mod1;

import com.mojang.logging.LogUtils;
import net.krugovov.mod1.block.ModBlocks;
import net.krugovov.mod1.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.Random;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Mod1.MOD_ID)


public class Mod1
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "mod1";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public Mod1()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            event.enqueueWork(() -> {
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ACACIA_LEAVES.get(), RenderType.cutout());
            });
            event.enqueueWork(() -> {
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.BEACON_BLOCK.get(), RenderType.cutout());
            });
        }
    }

    @Mod.EventBusSubscriber(modid = Mod1.MOD_ID)
    public static class ModEventHandlers {

        private static final Random RANDOM = new Random();

        @SubscribeEvent
        public static void onBlockBreak(BlockEvent.BreakEvent event) {
            BlockState state = event.getState();
            Block block = state.getBlock();
            ItemStack heldItem = event.getPlayer().getMainHandItem();
            BlockPos pos = event.getPos();
            ServerLevel world = (ServerLevel) event.getLevel();

            if (block == ModBlocks.KAMEN_BLOCK.get() && heldItem.getItem() == ModItems.KOP.get()) {
                int seedCount = 1 + RANDOM.nextInt(5);
                ItemStack seeds = new ItemStack(ModBlocks.KAMEN_BLOCK.get(), seedCount);
                Block.popResource(world, pos, seeds);
            }
            if (block == ModBlocks.ACACIA.get() && heldItem.getItem() == ModItems.KOP.get()) {
                int seedCount = 1 + RANDOM.nextInt(3);
                ItemStack seeds = new ItemStack(ModBlocks.ACACIA.get(), seedCount);
                Block.popResource(world, pos, seeds);
            }
            if (block == ModBlocks.ACACIA_LEAVES.get() && heldItem.getItem() == ModItems.KOP.get()) {
                int seedCount = 1 + RANDOM.nextInt(1);
                ItemStack seeds = new ItemStack(ModBlocks.ACACIA_LEAVES.get(), seedCount);
                Block.popResource(world, pos, seeds);
            }
            if (block == ModBlocks.KAMEN_ZAROSH.get() && heldItem.getItem() == ModItems.KOP.get()) {
                int seedCount = 1 + RANDOM.nextInt(1);
                ItemStack seeds = new ItemStack(ModBlocks.KAMEN_ZAROSH.get(), seedCount);
                Block.popResource(world, pos, seeds);
            }
            if (block == ModBlocks.BEACON_BLOCK.get() && heldItem.getItem() == ModItems.KOP.get()) {
                int seedCount = 1 + RANDOM.nextInt(1);
                ItemStack seeds = new ItemStack(ModBlocks.BEACON_BLOCK.get(), seedCount);
                Block.popResource(world, pos, seeds);
            }
        }

    }



}
