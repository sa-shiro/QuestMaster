package com.github.sa_shiro.questmaster;

import com.github.sa_shiro.questmaster.client.screen.QuestScreen;
import com.github.sa_shiro.questmaster.event.RegistryEvents;
import com.github.sa_shiro.questmaster.quest.QuestList;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(QuestMaster.MOD_ID)
public class QuestMaster {
    public static final String MOD_ID = "questmaster";
    public static final Logger logger = LogManager.getLogger();

    private static final QuestList q = new QuestList();


    public QuestMaster() {
        RegistryEvents.register();
        q.registerQuests();
    }
}