package com.ghost.grandpower.block;

import com.ghost.grandpower.GrandPower;
import com.ghost.grandpower.item.ModCreativeModeTab;
import com.ghost.grandpower.item.ModItems;
import com.google.common.base.Supplier;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlock {
    public static final DeferredRegister<Block> BLOCK = 
            DeferredRegister.create(ForgeRegistries.BLOCKS, GrandPower.MOD_ID);
    
    public static final RegistryObject<Block> TIME_BLOCK = registerBlock("time_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.SAND)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.LOST_POWER);
            
    
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCK.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> toReturn, CreativeModeTab tab) {
    }

    private static <T extends Block> RegistryObject<Item> registryObject(String name, RegistryObject<T> block,
                                                                         CreativeModeTab Tab){
        CreativeModeTab tab = null;
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    
    public static void register(IEventBus eventBus){
        BLOCK.register(eventBus);
    }
}
