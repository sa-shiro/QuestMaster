package com.github.sa_shiro.questmaster.client.screen;

import com.github.sa_shiro.questmaster.client.screen.components.ButtonExit;
import com.github.sa_shiro.questmaster.client.screen.components.ButtonText;
import com.github.sa_shiro.questmaster.util.ResourceLocations;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QuestScreen extends Screen {

    private static final int TEXTURE_WIDTH = 255;
    private static final int TEXTURE_HEIGHT = 182;

    public QuestScreen() {
        super(new StringTextComponent("Quest Screen"));
    }

    @Override
    public void render(final int mouseX, final int mouseZ, final float particleTicks) {
        int relX = (this.width - TEXTURE_WIDTH) / 2;
        int relY = (this.height - TEXTURE_HEIGHT) / 2;

        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(ResourceLocations.QUEST_GUI);
        // windowSizeX, windowSizeY, imagePosX, imagePosY, imageSizeX, imageSizeY |&| textureWidth, textureHeight (default: 256, 256)
        this.blit(relX, relY - 25, 0, 0, TEXTURE_WIDTH, TEXTURE_HEIGHT);

        buttons();
        this.addButton(new ButtonExit(relX + 226, relY - 14, buttons -> this.onClose()));

        super.render(mouseX, mouseZ, particleTicks);
    }

    public void buttons() {
        int relX = (this.width - TEXTURE_WIDTH) / 2;
        int relY = (this.height - TEXTURE_HEIGHT) / 2;

        this.addButton(new ButtonText(relX + 10, relY - 10, "Test", action -> {
        }));
    }


    @Override
    public boolean isPauseScreen() {
        return true;
    }

    public static void openGui() {
        Minecraft.getInstance().displayGuiScreen(new QuestScreen());
        System.out.println("Quest Gui Loaded!!");
    }
}
