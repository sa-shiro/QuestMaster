package com.github.sa_shiro.questmaster.util;

import com.github.sa_shiro.questmaster.QuestMaster;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.Tags;

public class CreativeItemGroup {
    public static net.minecraft.item.ItemGroup customItemGroup = new net.minecraft.item.ItemGroup(QuestMaster.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack((Items.STONE)); // fixme: change icon
        }

        @Override
        public boolean hasScrollbar() {
            return true;
        }
    };
}
