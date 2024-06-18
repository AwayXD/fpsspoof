package com.example.fpsspoof;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class FpsSpoofHandler {
    private int spoofedFps = 0;
    private int actualFps = 0;
    private int targetFps = 0;

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Minecraft mc = Minecraft.getMinecraft();
            actualFps = mc.getDebugFPS();
            // Set a target FPS that is three times the actual FPS
            targetFps = actualFps * 3;
        }
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        if (event.type != RenderGameOverlayEvent.ElementType.TEXT) return;

        // Adjust spoofedFps gradually towards targetFps
        if (spoofedFps < targetFps) {
            spoofedFps = Math.min(spoofedFps + 1, targetFps);
        } else if (spoofedFps > targetFps) {
            spoofedFps = Math.max(spoofedFps - 1, targetFps);
        }

        Minecraft mc = Minecraft.getMinecraft();
        String fpsText = "[FPS] " + spoofedFps;
        int x = 5; // X position
        int y = 5; // Y position
        int textColor = 0xFFFFFF; // White color for text
        int shadowColor = 0x000000; // Light gray color for shadow (adjust transparency)

        // Draw shadow on the left side with transparency
        mc.fontRendererObj.drawStringWithShadow(fpsText, x - 1, y, shadowColor);

        // Draw text
        mc.fontRendererObj.drawString(fpsText, x, y, textColor);
    }
}
