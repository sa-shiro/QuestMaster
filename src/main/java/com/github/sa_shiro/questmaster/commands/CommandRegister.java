package com.github.sa_shiro.questmaster.commands;

import com.github.sa_shiro.questmaster.client.screen.QuestScreen;
import com.github.sa_shiro.questmaster.quest.Quest;
import com.github.sa_shiro.questmaster.quest.QuestList;
import com.github.sa_shiro.questmaster.world.WorldSavedQuestData;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.StringTextComponent;

public class CommandRegister {

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("qm")
                .then(Commands.literal("open")
                        .executes(context -> {
                            QuestScreen.openGui();
                            return 0;
                        })
                        .requires(context -> context.hasPermissionLevel(2))
                )

                .then(Commands.literal("complete")
                        .executes(context -> {
                            for (Quest quest : QuestList.QUESTS) {
                                System.out.println("QuestState: " + quest.getQuestName() + " - " + quest.getQuestSate());
                                if (quest.getQuestSate()) {
                                    quest.giveReward();
                                } else
                                    context.getSource().sendFeedback(new StringTextComponent("Quests " + quest.getQuestName() + "is not finished!"), false);
                            }
                            return 0;
                        })
                )
        );
    }
}
