package com.github.sa_shiro.questmaster.event;

import com.github.sa_shiro.questmaster.QuestMaster;
import com.github.sa_shiro.questmaster.quest.QuestList;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = QuestMaster.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class QuestEvent {

    @SubscribeEvent
    public static void checkForKilledEntity(LivingDeathEvent e) {
        if (e.getEntity() instanceof ZombieEntity) {

        }
    }
}
