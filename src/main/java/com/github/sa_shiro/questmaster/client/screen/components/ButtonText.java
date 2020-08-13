package com.github.sa_shiro.questmaster.client.screen.components;

import com.github.sa_shiro.questmaster.util.ResourceLocations;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.Button;

public class ButtonText extends Button {

    String label;
    int posX, posY;

    private static int componentPosX = 0;
    private static int componentPosY = 210;
    private static int componentWidth = 100;
    private static int componentHeight = 16;

    public ButtonText(int posX, int posY, String textIn, IPressable onPress) {
        super(posX, posY, componentWidth, componentHeight, textIn, onPress);
        label = textIn;
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public void renderButton(int mouseX, int mouseZ, float particleTicks) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getInstance().getTextureManager().bindTexture(ResourceLocations.QUEST_GUI);
        FontRenderer fontRenderer = Minecraft.getInstance().fontRenderer;

        int color = 16777215; // white

        if (this.isHovered) {
            color = 10526880; // gray
        }

        // windowSizeX, windowSizeY, imagePosX, imagePosY, imageSizeX, imageSizeY
        this.blit(this.x, this.y, componentPosX, componentPosY, componentWidth, componentHeight);
        fontRenderer.drawString(this.label, this.posX, this.posY, color);
    }
}

