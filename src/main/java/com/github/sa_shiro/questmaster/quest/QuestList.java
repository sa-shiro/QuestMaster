package com.github.sa_shiro.questmaster.quest;

import com.github.sa_shiro.questmaster.quest.condition.KillCondition;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.ArrayList;

public class QuestList {

    public static ArrayList<Quest> QUESTS = new ArrayList<>();

    public void registerQuests() {
        QUESTS.add(0, new Quest(QuestNames.ZOMBIE.getName(),false, 15, new KillCondition(EntityType.ZOMBIE, 3), new ItemStack(Items.APPLE, 3), new ItemStack(Items.WATER_BUCKET, 3)));
    }

}
