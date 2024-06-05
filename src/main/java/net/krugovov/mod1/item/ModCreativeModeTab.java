package net.krugovov.mod1.item;


import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {

    public static final CreativeModeTab KAM_TAB = new CreativeModeTab("Kamen Vek") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.HUMAN.get());

        }
    };
}
