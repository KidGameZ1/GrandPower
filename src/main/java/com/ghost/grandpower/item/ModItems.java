package com.ghost.grandpower.item;

import com.ghost.grandpower.GrandPower;
import com.ghost.grandpower.item.custom.ReversedClockItem;
import com.ghost.grandpower.item.custom.TimeSwordItem;
import io.netty.util.Attribute;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS,  GrandPower.MOD_ID);
    


    public static RegistryObject<Item> TIME_CHUNK = ITEMS.register("time_chunk",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LOST_POWER)));


    public static RegistryObject<Item> TIME_GEM = ITEMS.register("time_gem",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LOST_POWER)));

    public static RegistryObject<Item> DARK_CLOCK = ITEMS.register("dark_clock",
            () -> new ReversedClockItem(new Item.Properties().tab(ModCreativeModeTab.LOST_POWER).stacksTo(1)));


    public static final RegistryObject<Item> CITRINE_HELMET = ITEMS.register("citrine_helmet",
            () -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.LOST_POWER)));
    public static final RegistryObject<Item> CITRINE_CHESTPLATE = ITEMS.register("citrine_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.LOST_POWER)));
    public static final RegistryObject<Item> CITRINE_LEGGING = ITEMS.register("citrine_leggings",
            () -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.LOST_POWER)));
    public static final RegistryObject<Item> CITRINE_BOOTS = ITEMS.register("citrine_boots",
            () -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.LOST_POWER)));





    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);

    }


}
