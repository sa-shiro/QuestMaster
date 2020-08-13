package com.github.sa_shiro.questmaster.commands;

import com.github.sa_shiro.questmaster.client.screen.QuestScreen;
import com.github.sa_shiro.questmaster.quest.Quest;
import com.github.sa_shiro.questmaster.quest.QuestList;
import com.github.sa_shiro.questmaster.quest.QuestNames;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

import java.util.Arrays;

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
        );
    }
}
