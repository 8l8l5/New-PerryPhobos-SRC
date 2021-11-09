//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\utente\Desktop\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package me.earth.phobos.features.modules.movement;

import me.earth.phobos.features.modules.*;
import me.earth.phobos.features.setting.*;
import me.earth.phobos.event.events.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class FastSwim extends Module
{
    public Setting<Double> waterHorizontal;
    public Setting<Double> waterVertical;
    public Setting<Double> lavaHorizontal;
    public Setting<Double> lavaVertical;
    
    public FastSwim() {
        super("FastSwim", "Swim faster.", Module.Category.MOVEMENT, true, false, false);
        this.waterHorizontal = (Setting<Double>)this.register(new Setting("WaterHorizontal", (T)3.0, (T)1.0, (T)20.0));
        this.waterVertical = (Setting<Double>)this.register(new Setting("WaterVertical", (T)3.0, (T)1.0, (T)20.0));
        this.lavaHorizontal = (Setting<Double>)this.register(new Setting("LavaHorizontal", (T)4.0, (T)1.0, (T)20.0));
        this.lavaVertical = (Setting<Double>)this.register(new Setting("LavaVertical", (T)4.0, (T)1.0, (T)20.0));
    }
    
    @SubscribeEvent
    public void onMove(final MoveEvent event) {
        if (FastSwim.mc.player.onGround || FastSwim.mc.player.isElytraFlying()) {
            return;
        }
        if (FastSwim.mc.player.isInLava()) {
            event.setX(event.getX() * this.lavaHorizontal.getValue());
            event.setZ(event.getZ() * this.lavaHorizontal.getValue());
            event.setY(event.getY() * this.lavaVertical.getValue());
        }
        else if (FastSwim.mc.player.isInWater()) {
            event.setX(event.getX() * this.waterHorizontal.getValue());
            event.setZ(event.getZ() * this.waterHorizontal.getValue());
            event.setY(event.getY() * this.waterVertical.getValue());
        }
    }
}
