package com.ghost.grandpower.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab LOST_POWER = new CreativeModeTab("lost_power") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.TIME_GEM.get());
        }
    };
}
