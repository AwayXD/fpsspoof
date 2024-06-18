package com.example.fpsspoof;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = FpsSpoofMod.MODID, version = FpsSpoofMod.VERSION)
public class FpsSpoofMod {
    public static final String MODID = "fpsspoof";
    public static final String VERSION = "1.0";
    // Instance of your mod
    @Mod.Instance(MODID)
    public static FpsSpoofMod instance;


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new FpsSpoofHandler());
    }
}
