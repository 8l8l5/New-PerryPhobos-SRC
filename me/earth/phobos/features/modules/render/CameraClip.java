//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\utente\Desktop\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package me.earth.phobos.features.modules.render;

import me.earth.phobos.features.modules.*;
import me.earth.phobos.features.setting.*;

public class CameraClip extends Module
{
    private static CameraClip INSTANCE;
    public Setting<Boolean> extend;
    public Setting<Double> distance;
    
    public CameraClip() {
        super("CameraClip", "Makes your Camera clip.", Module.Category.RENDER, false, false, false);
        this.extend = (Setting<Boolean>)this.register(new Setting("Extend", (T)false));
        this.distance = (Setting<Double>)this.register(new Setting("Distance", (T)10.0, (T)0.0, (T)50.0, v -> this.extend.getValue(), "By how much you want to extend the distance."));
        this.setInstance();
    }
    
    public static CameraClip getInstance() {
        if (CameraClip.INSTANCE == null) {
            CameraClip.INSTANCE = new CameraClip();
        }
        return CameraClip.INSTANCE;
    }
    
    private void setInstance() {
        CameraClip.INSTANCE = this;
    }
    
    static {
        CameraClip.INSTANCE = new CameraClip();
    }
}
