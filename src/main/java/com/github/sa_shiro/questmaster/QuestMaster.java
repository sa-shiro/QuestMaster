package com.github.sa_shiro.questmaster;

import com.github.sa_shiro.questmaster.event.ForgeEventHandlers;
import com.github.sa_shiro.questmaster.event.RegistryEvents;
import com.github.sa_shiro.questmaster.quest.QuestList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(QuestMaster.MOD_ID)
public class QuestMaster {
    public static final String MOD_ID = "questmaster";
    public static final Logger logger = LogManager.getLogger();

    public QuestMaster() {
        RegistryEvents.register();
        QuestList.registerQuests();
    }
}
