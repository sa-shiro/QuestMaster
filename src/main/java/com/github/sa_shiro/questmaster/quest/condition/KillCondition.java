package com.github.sa_shiro.questmaster.quest.condition;

import com.github.sa_shiro.questmaster.world.WorldSavedQuestData;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KillCondition implements ICondition {

    public EntityType<?> entity;
    private final int targetCount;
    private int count = 0;
    private boolean state = false;
    WorldSavedQuestData questData;

    public KillCondition(EntityType<?> entityIn, int countIn) {
        targetCount = countIn;
        entity = entityIn;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void monsterDeathEvent(LivingDeathEvent e) {
        PlayerEntity playerEntity = Minecraft.getInstance().player;
        assert playerEntity != null;

        if (e.getEntity().getName() == entity.getName() && !state) {
            if (e.getSource().getDamageType().equals(DamageSource.causePlayerDamage(playerEntity).damageType)) {
                count++;
            }

            System.out.println("Zombie " + count + " has ben killed!");

            if (getCount() == getTargetCount()) {
                state = true;
            }
        }
    }

    @Override
    public boolean getConditionState() {
        return state;
    }

    @Override
    public void setConditionState(boolean isFinished) {
        state = isFinished;
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
