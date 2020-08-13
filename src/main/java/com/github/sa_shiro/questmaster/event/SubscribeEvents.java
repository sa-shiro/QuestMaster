package com.github.sa_shiro.questmaster.event;

import com.github.sa_shiro.questmaster.QuestMaster;
import com.github.sa_shiro.questmaster.commands.CommandRegister;
import com.github.sa_shiro.questmaster.quest.QuestList;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;

@Mod.EventBusSubscriber(modid = QuestMaster.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SubscribeEvents {

    @SubscribeEvent
    public static void registerCommands(FMLServerStartedEvent e) {
        CommandRegister.register(e.getServer().getCommandManager().getDispatcher());
    }
}
