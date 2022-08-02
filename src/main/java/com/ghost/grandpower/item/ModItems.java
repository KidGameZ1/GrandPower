package com.ghost.grandpower.item;

import com.ghost.grandpower.GrandPower;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS,  GrandPower.MOD_ID);



    public static RegistryObject<Item> TIME_CHUNK = ITEMS.register("time_chunk",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static RegistryObject<Item> TIME_GEM = ITEMS.register("time_gem",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));



    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);

    }


}
