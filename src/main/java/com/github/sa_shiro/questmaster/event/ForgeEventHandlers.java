package com.github.sa_shiro.questmaster.event;

import com.github.sa_shiro.questmaster.QuestMaster;
import com.github.sa_shiro.questmaster.commands.CommandRegister;
import com.github.sa_shiro.questmaster.quest.Quest;
import com.github.sa_shiro.questmaster.quest.condition.KillCondition;
import com.github.sa_shiro.questmaster.world.WorldSavedQuestData;
import net.minecraft.scoreboard.ScoreboardSaveData;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraft.world.storage.WorldSavedDataCallableSave;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;

@Mod.EventBusSubscriber(modid = QuestMaster.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventHandlers {

    public static void serverStartingEvent(FMLServerStartedEvent e) {
        CommandRegister.register(e.getServer().getCommandManager().getDispatcher());
    }
}
