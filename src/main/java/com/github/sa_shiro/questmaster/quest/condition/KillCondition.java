package com.github.sa_shiro.questmaster.quest.condition;

import com.github.sa_shiro.questmaster.QuestMaster;
import com.github.sa_shiro.questmaster.quest.Quest;
import com.github.sa_shiro.questmaster.quest.QuestNames;
import net.minecraft.entity.EntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = QuestMaster.MOD_ID)
public class KillCondition implements ICondition {

    public EntityType<?> entity;
    private final int targetCount;
    private int count = 0;
    private boolean state = false;

    public KillCondition(EntityType<?> entityIn, int countIn) {
        targetCount = countIn;
        entity = entityIn;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void monsterDeathEvent(final LivingDeathEvent e) {
        if (e.getEntity().getName() == entity.getName()) {
            count += 1;

            System.out.println("\n\nZombie " + count + " has ben killed!\n\n");

            if (getCount() == getTargetCount()) {
                state = true;
            }
        }
    }

    @Override
    public boolean isFinished() {
        return state;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public int getTargetCount() {
        return targetCount;
    }
}
