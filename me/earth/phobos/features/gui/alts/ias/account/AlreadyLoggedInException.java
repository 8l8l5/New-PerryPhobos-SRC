//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\utente\Desktop\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package me.earth.phobos.features.gui.alts.ias.account;

import net.minecraft.client.resources.*;

public class AlreadyLoggedInException extends Exception
{
    private static final long serialVersionUID = -7572892045698003265L;
    
    @Override
    public String getLocalizedMessage() {
        return I18n.format("ias.alreadyloggedin", new Object[0]);
    }
}
