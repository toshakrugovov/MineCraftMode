package net.krugovov.mod1.item;

import net.krugovov.mod1.Mod1;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.Tiers.STONE;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister. create(ForgeRegistries. ITEMS, Mod1.MOD_ID);


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> KOST = ITEMS.register("kost",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                .nutrition(6)
                .saturationMod(0.8F)
                .meat()
                .effect(() -> new MobEffectInstance(MobEffects.POISON, 100), 0.3F)
                .build()
            )
            .tab(ModCreativeModeTab.KAM_TAB)
        )
    );

    public  static final RegistryObject<Item> HUMAN = ITEMS.register("human",
        () -> new Item(new Item.Properties().tab(ModCreativeModeTab.KAM_TAB)));





    public static final RegistryObject<Item> NAM = ITEMS.register("nam",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                .nutrition(5) // Питательность
                .saturationMod(0.5f) // Насыщенность
                .build()
            )

            .rarity(Rarity.UNCOMMON)
            .tab(ModCreativeModeTab.KAM_TAB)
        )
    );


    public static final RegistryObject<Item> KOP = ITEMS.register("kop",
        () -> new SwordItem(STONE, 3, -2.4F, new Item.Properties()
            .tab(ModCreativeModeTab.KAM_TAB)
            .setNoRepair()
            .defaultDurability(200)
            .rarity(Rarity.RARE)
        )
    );


}
