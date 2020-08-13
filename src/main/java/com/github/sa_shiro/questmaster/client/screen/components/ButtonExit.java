package com.github.sa_shiro.questmaster.client.screen.components;

import com.github.sa_shiro.questmaster.util.ResourceLocations;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ButtonExit extends Button {

    public ButtonExit(int widthIn, int heightIn, IPressable onPress) {
        super(widthIn, heightIn, 18, 20, "", onPress);
    }

    @Override
    public void renderButton(int mouseX, int mouseZ, float particleTicks) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getInstance().getTextureManager().bindTexture(ResourceLocations.QUEST_GUI);

        int posX = 0;

        if (this.isHovered) {
            posX += 19;
        }

        // windowSizeX, windowSizeY, imagePosX, imagePosY, imageSizeX, imageSizeY
        this.blit(this.x, this.y, posX, 184, 18, 20);
    }
}
