//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\utente\Desktop\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package me.earth.phobos.mixin.mixins.accessors;

import org.spongepowered.asm.mixin.*;
import net.minecraft.inventory.*;
import org.spongepowered.asm.mixin.gen.*;

@Mixin({ Container.class })
public interface IContainer
{
    @Accessor("transactionID")
    void setTransactionID(final short p0);
}
