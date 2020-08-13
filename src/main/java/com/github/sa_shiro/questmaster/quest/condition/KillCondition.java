package com.github.sa_shiro.questmaster.quest.condition;

import com.github.sa_shiro.questmaster.QuestMaster;
import com.github.sa_shiro.questmaster.quest.Quest;
import com.github.sa_shiro.questmaster.quest.QuestNames;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = QuestMaster.MOD_ID)
public class KillCondition extends Quest implements ICondition {

    private static EntityType<?>  entity;
    private static int targetCount;
    private static int count;

    public KillCondition(EntityType<?> entityIn, int countIn) {
        super(questName, questState, XP, condition, itemReward);
        targetCount = countIn;
        entity = entityIn;
    }


    @SubscribeEvent
    public static void monsterDeathEvent(LivingDeathEvent e) {
        if (e.getEntity().getName() == entity.getName() && !Quest.getQuestByName((QuestNames.valueOf(questName).getName())).getQuestSate()) {
            count++;

            QuestMaster.logger.info("\n\nZombie has ben killed!\n\n");

            if(count == targetCount) {
                Quest.getQuestByName(QuestNames.valueOf(questName).getName()).giveReward();
            }
        }
    }

    @Override
    public void completeQuest(Quest quest) {
        if(count >= targetCount) {
            quest.giveReward();
        }
    }


    @Override
    public boolean isFinished() {
        return getCount() == getTargetCount();
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
