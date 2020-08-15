/*
(c) sa-shiro
All Rights Reserved.
 */

package com.github.sa_shiro.questmaster;

import com.github.sa_shiro.questmaster.client.screen.QuestScreen;
import com.github.sa_shiro.questmaster.event.ForgeEventHandlers;
import com.github.sa_shiro.questmaster.event.RegistryEvents;
import com.github.sa_shiro.questmaster.quest.Quest;
import com.github.sa_shiro.questmaster.quest.QuestList;
import com.github.sa_shiro.questmaster.quest.condition.ICondition;
import com.github.sa_shiro.questmaster.world.WorldSavedQuestData;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** TODO <br>
    -   Fix / Implement {@link WorldSavedQuestData} to save {@link Quest} data to world.<br>
    -   Implement the feature to read {@link Quest} from <b>json</b> files<br>
    -   Add features to {@link QuestScreen}:<br>
    -    -   Load {@link Quest} data from <b>json</b><br>
    -    -   Display & load Chapters, Title & Lore Text<br>
    -    -   Display <b>Reward</b> as {@link ItemStack} with <b>ToolTip on hover</b><br>
    -   Implement new {@link ICondition} such as <b>MiningCondition</b>, <b>TravelCondition</b> <b>ItemUseCondition</b>...
 */

@Mod(QuestMaster.MOD_ID)
public class QuestMaster {
    public static final String MOD_ID = "questmaster";
    public static final Logger logger = LogManager.getLogger();

    public QuestMaster() {
        RegistryEvents.register();
        QuestList.registerQuests();

        MinecraftForge.EVENT_BUS.addListener(ForgeEventHandlers::serverStartingEvent);
    }
}
