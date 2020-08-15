package com.github.sa_shiro.questmaster.world;

import com.github.sa_shiro.questmaster.QuestMaster;
import com.github.sa_shiro.questmaster.quest.Quest;
import com.github.sa_shiro.questmaster.quest.QuestList;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class WorldSavedQuestData extends WorldSavedData {

    public static final String SAVE_NAME = "QuestData";

    public boolean isFinished;
    public String questName;

    private static WorldSavedQuestData INSTANCE = new WorldSavedQuestData();

    public WorldSavedQuestData(String questName, boolean isFinished) {
        this(SAVE_NAME);
        this.questName = questName;
        this.isFinished = isFinished;
    }

    public WorldSavedQuestData(String name) {
        super(name);
    }

    public WorldSavedQuestData() {
        this(SAVE_NAME);
    }


    @Override
    public void read(CompoundNBT nbt) {
        isFinished = nbt.getBoolean(questName);

        this.readQuests(nbt.getList("Quests", 1));
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("Quests", this.writeQuests());
        return compound;
    }

    private ListNBT writeQuests() {
        ListNBT list = new ListNBT();
        for (Quest questname : QuestList.QUESTS) {
            CompoundNBT compoundNBT = new CompoundNBT();
            String isFinished = null;

            if (questname.getQuestSate()) isFinished = "complete"; else isFinished = "incomplete";

            compoundNBT.putString(questname.getQuestName(), isFinished);
        }
        return list;
    }

    private void  readQuests(ListNBT nbt) {
        ListNBT list = new ListNBT();
        for (Quest quest : QuestList.QUESTS) {
            CompoundNBT compoundNBT = new CompoundNBT();

            compoundNBT.getString(quest.getQuestName());
        }
    }


    public static void setDirty() {
        if (INSTANCE != null) INSTANCE.markDirty();
    }

    public static void setInstance(WorldSavedQuestData instance) {
        INSTANCE = instance;
    }

    public static WorldSavedQuestData get() {
        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        if (server != null) {
            ServerWorld overworld = server.getWorld(DimensionType.OVERWORLD);
            DimensionSavedDataManager storage = overworld.getSavedData();
            return storage.getOrCreate(WorldSavedQuestData::new, SAVE_NAME);
        }

        return INSTANCE;
    }
}
