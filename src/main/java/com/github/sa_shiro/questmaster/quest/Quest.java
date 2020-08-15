package com.github.sa_shiro.questmaster.quest;

import com.github.sa_shiro.questmaster.quest.condition.ICondition;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class Quest {

    final String questName;
    boolean hasClaimedReward;
    int XP;
    ItemStack[] itemReward;
    ICondition condition;

    /*
        public Quest(String questNameIn, boolean isFinished, ItemStack... rewardItem) {
            this(questNameIn, isFinished, 0, rewardItem);
        }

        public Quest(String questNameIn, boolean isFinished, int rewardXP) {
            this(questNameIn, isFinished, rewardXP, (ItemStack) null);
        }
    */
    public Quest(String questNameIn, int rewardXP, ICondition conditionIn, ItemStack... rewardItem) {
        questName = questNameIn;
        itemReward = rewardItem;
        XP = rewardXP;
        condition = conditionIn;
        hasClaimedReward = false;
    }

    public void giveReward() {
        if (condition.getConditionState() && !hasClaimedReward) {
            assert Minecraft.getInstance().player != null;
            Minecraft.getInstance().player.giveExperiencePoints(XP);

            for (ItemStack item : itemReward) {
                Minecraft.getInstance().player.inventory.addItemStackToInventory(item.copy());
            }
            completeQuest();
        } else {
            System.out.println("Quest has already been completed!");
        }
    }

    public ItemStack[] getRewardItem() {
        return itemReward;
    }

    public int getRewardXP() {
        return XP;
    }

    public boolean getQuestSate() {
        return this.condition.getConditionState();
    }

    private void completeQuest() {
        this.hasClaimedReward = true;
    }

    public String getQuestName() {
        return questName;
    }

    public static Quest getQuestByName(String name) {
        Quest quest = null;

        for (Quest q : QuestList.QUESTS) {
            if (q.getQuestName().equals(name)) {
                quest = q;
            }
        }
        return quest;
    }
}
