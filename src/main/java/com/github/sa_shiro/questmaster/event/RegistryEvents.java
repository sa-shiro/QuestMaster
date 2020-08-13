package com.github.sa_shiro.questmaster.event;

import com.github.sa_shiro.questmaster.QuestMaster;
import com.github.sa_shiro.questmaster.util.CreativeItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryEvents {

    private static final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    private static final Item.Properties props = new Item.Properties().group(CreativeItemGroup.customItemGroup);
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, QuestMaster.MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, QuestMaster.MOD_ID);

    public static void register() {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}