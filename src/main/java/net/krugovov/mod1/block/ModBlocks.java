package net.krugovov.mod1.block;

import net.krugovov.mod1.Mod1;
import net.krugovov.mod1.item.ModCreativeModeTab;
import net.krugovov.mod1.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.BeaconBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, Mod1.MOD_ID);

    public static <T extends Block>RegistryObject<T>registryBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturns = BLOCKS.register(name, block);
        registryBlockItem(name, toReturns, tab);
        return toReturns;
    }


    public static final RegistryObject<Block> KAMEN_BLOCK = registryBlock("kamen_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(3f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.STONE)),
        ModCreativeModeTab.KAM_TAB);

    public static final RegistryObject<Block> BEACON_BLOCK = registryBlock("beacon_block",
        () -> new Block(Block.Properties.of(Material.GLASS)
            .strength(1.0f)
            .lightLevel((state) -> 15)
            .noOcclusion()),
        ModCreativeModeTab.KAM_TAB);




    public static final RegistryObject<Block> KAMEN_ZAROSH = registryBlock("kamen_zarosh",
        ()-> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(3f).requiresCorrectToolForDrops(),
            UniformInt.of(3,7)), ModCreativeModeTab.KAM_TAB);

    public static final RegistryObject<Block> ACACIA = registryBlock("acacia",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.WOOD)
            .strength(2f)
            .requiresCorrectToolForDrops()

            .sound(SoundType.WOOD)),
        ModCreativeModeTab.KAM_TAB);



    public static final RegistryObject<Block> ACACIA_LEAVES = registryBlock("acacia_leaves",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.LEAVES)
            .strength(1f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.GRASS)
            .noOcclusion()
            .isViewBlocking((state, getter, pos) -> false)
            .isSuffocating((state, getter, pos) -> false)
            .dynamicShape(),
            UniformInt.of(3, 7)),
        ModCreativeModeTab.KAM_TAB);

    public static <T extends Block> RegistryObject<BlockItem> registryBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
