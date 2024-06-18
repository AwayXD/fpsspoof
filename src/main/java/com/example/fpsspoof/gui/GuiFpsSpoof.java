package com.example.fpsspoof.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class GuiFpsSpoof extends GuiScreen {

    public static final int GUI_ID = 1;

    @Override
    public void initGui() {
        buttonList.add(new GuiButton(0, width / 2 - 50, height / 2 - 10, 100, 20, "Click Me!"));
    }

    @Override
    public void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0:
                // Handle button click event here
                EntityPlayer player = mc.thePlayer; // Get the player
                player.addChatMessage(new ChatComponentText("Button clicked!"));
                break;
            default:
                break;
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
