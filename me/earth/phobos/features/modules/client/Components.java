//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\utente\Desktop\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package me.earth.phobos.features.modules.client;

import me.earth.phobos.features.modules.*;
import me.earth.phobos.features.setting.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import me.earth.phobos.*;
import org.lwjgl.opengl.*;
import me.earth.phobos.event.events.*;
import java.awt.*;
import me.earth.phobos.features.modules.combat.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.entity.*;
import java.text.*;
import net.minecraft.client.network.*;
import java.util.*;
import net.minecraft.client.gui.*;
import me.earth.phobos.util.*;
import java.util.function.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.inventory.*;

public class Components extends Module
{
    private static final ResourceLocation box;
    public static ResourceLocation logo;
    public Setting<Boolean> inventory;
    public Setting<Integer> invX;
    public Setting<Integer> invY;
    public Setting<Integer> fineinvX;
    public Setting<Integer> fineinvY;
    public Setting<Boolean> renderXCarry;
    public Setting<Integer> invH;
    public Setting<Boolean> pvpUtil;
    public Setting<Integer> pvpUtilX;
    public Setting<Integer> pvpUtilY;
    public Setting<Boolean> holeHud;
    public Setting<Integer> holeX;
    public Setting<Integer> holeY;
    public Setting<Compass> compass;
    public Setting<Integer> compassX;
    public Setting<Integer> compassY;
    public Setting<Integer> scale;
    public Setting<Boolean> playerViewer;
    public Setting<Integer> playerViewerX;
    public Setting<Integer> playerViewerY;
    public Setting<Float> playerScale;
    public Setting<Boolean> imageLogo;
    public Setting<Integer> imageX;
    public Setting<Integer> imageY;
    public Setting<Integer> imageWidth;
    public Setting<Integer> imageHeight;
    public Setting<Boolean> targetHud;
    public Setting<Boolean> targetHudBackground;
    public Setting<Integer> targetHudX;
    public Setting<Integer> targetHudY;
    public Setting<TargetHudDesign> design;
    public Setting<Boolean> targetHudColorSync;
    public Setting<Integer> targetHudBlue;
    public Setting<Integer> targetHudGreen;
    public Setting<Integer> targetHudRed;
    public Setting<Integer> targetHudAlpha;
    public Setting<Boolean> clock;
    public Setting<Boolean> clockFill;
    public Setting<Float> clockX;
    public Setting<Float> clockY;
    public Setting<Float> clockRadius;
    public Setting<Float> clockLineWidth;
    public Setting<Integer> clockSlices;
    public Setting<Integer> clockLoops;
    ItemStack crystal;
    ItemStack experience;
    ItemStack gapple;
    
    public Components() {
        super("Components", "Hud Components.", Category.CLIENT, false, false, true);
        this.inventory = (Setting<Boolean>)this.register(new Setting("Inventory", (T)false));
        this.invX = (Setting<Integer>)this.register(new Setting("InvX", (T)564, (T)0, (T)1000, v -> this.inventory.getValue()));
        this.invY = (Setting<Integer>)this.register(new Setting("InvY", (T)467, (T)0, (T)1000, v -> this.inventory.getValue()));
        this.fineinvX = (Setting<Integer>)this.register(new Setting("InvFineX", (T)0, v -> this.inventory.getValue()));
        this.fineinvY = (Setting<Integer>)this.register(new Setting("InvFineY", (T)0, v -> this.inventory.getValue()));
        this.renderXCarry = (Setting<Boolean>)this.register(new Setting("RenderXCarry", (T)false, v -> this.inventory.getValue()));
        this.invH = (Setting<Integer>)this.register(new Setting("InvH", (T)3, v -> this.inventory.getValue()));
        this.pvpUtil = (Setting<Boolean>)this.register(new Setting("Pvp Utils", (T)false));
        this.pvpUtilX = (Setting<Integer>)this.register(new Setting("PvpUtilX", (T)500, (T)0, (T)1000, n -> this.pvpUtil.getValue()));
        this.pvpUtilY = (Setting<Integer>)this.register(new Setting("PvpUtilY", (T)400, (T)0, (T)1000, n -> this.pvpUtil.getValue()));
        this.holeHud = (Setting<Boolean>)this.register(new Setting("HoleHUD", (T)false));
        this.holeX = (Setting<Integer>)this.register(new Setting("HoleX", (T)279, (T)0, (T)1000, v -> this.holeHud.getValue()));
        this.holeY = (Setting<Integer>)this.register(new Setting("HoleY", (T)485, (T)0, (T)1000, v -> this.holeHud.getValue()));
        this.compass = (Setting<Compass>)this.register(new Setting("Compass", (T)Compass.NONE));
        this.compassX = (Setting<Integer>)this.register(new Setting("CompX", (T)472, (T)0, (T)1000, v -> this.compass.getValue() != Compass.NONE));
        this.compassY = (Setting<Integer>)this.register(new Setting("CompY", (T)424, (T)0, (T)1000, v -> this.compass.getValue() != Compass.NONE));
        this.scale = (Setting<Integer>)this.register(new Setting("Scale", (T)3, (T)0, (T)10, v -> this.compass.getValue() != Compass.NONE));
        this.playerViewer = (Setting<Boolean>)this.register(new Setting("PlayerViewer", (T)false));
        this.playerViewerX = (Setting<Integer>)this.register(new Setting("PlayerX", (T)752, (T)0, (T)1000, v -> this.playerViewer.getValue()));
        this.playerViewerY = (Setting<Integer>)this.register(new Setting("PlayerY", (T)497, (T)0, (T)1000, v -> this.playerViewer.getValue()));
        this.playerScale = (Setting<Float>)this.register(new Setting("PlayerScale", (T)1.0f, (T)0.1f, (T)2.0f, v -> this.playerViewer.getValue()));
        this.imageLogo = (Setting<Boolean>)this.register(new Setting("ImageLogo", (T)false));
        this.imageX = (Setting<Integer>)this.register(new Setting("ImageX", (T)2, (T)0, (T)1000, v -> this.imageLogo.getValue()));
        this.imageY = (Setting<Integer>)this.register(new Setting("ImageY", (T)2, (T)0, (T)1000, v -> this.imageLogo.getValue()));
        this.imageWidth = (Setting<Integer>)this.register(new Setting("ImageWidth", (T)100, (T)0, (T)1000, v -> this.imageLogo.getValue()));
        this.imageHeight = (Setting<Integer>)this.register(new Setting("ImageHeight", (T)100, (T)0, (T)1000, v -> this.imageLogo.getValue()));
        this.targetHud = (Setting<Boolean>)this.register(new Setting("TargetHud", (T)false));
        this.targetHudBackground = (Setting<Boolean>)this.register(new Setting("TargetHudBackground", (T)true, v -> this.targetHud.getValue()));
        this.targetHudX = (Setting<Integer>)this.register(new Setting("TargetHudX", (T)2, (T)0, (T)1000, v -> this.targetHud.getValue()));
        this.targetHudY = (Setting<Integer>)this.register(new Setting("TargetHudY", (T)2, (T)0, (T)1000, v -> this.targetHud.getValue()));
        this.design = (Setting<TargetHudDesign>)this.register(new Setting("Design", (T)TargetHudDesign.NORMAL, v -> this.targetHud.getValue()));
        this.targetHudColorSync = (Setting<Boolean>)this.register(new Setting("TargetSync", (T)true, v -> this.targetHudBackground.getValue() && this.design.getValue() == TargetHudDesign.COOLER && this.targetHud.getValue()));
        this.targetHudBlue = (Setting<Integer>)this.register(new Setting("TargetHud Blue", (T)0, (T)0, (T)255, v -> this.targetHudBackground.getValue() && this.design.getValue() == TargetHudDesign.COOLER && this.targetHud.getValue()));
        this.targetHudGreen = (Setting<Integer>)this.register(new Setting("TargetHud Green", (T)0, (T)0, (T)255, v -> this.targetHudBackground.getValue() && this.design.getValue() == TargetHudDesign.COOLER && this.targetHud.getValue()));
        this.targetHudRed = (Setting<Integer>)this.register(new Setting("TargetHud Red", (T)0, (T)0, (T)255, v -> this.targetHudBackground.getValue() && this.design.getValue() == TargetHudDesign.COOLER && this.targetHud.getValue()));
        this.targetHudAlpha = (Setting<Integer>)this.register(new Setting("TargetHud Alpha", (T)0, (T)0, (T)255, v -> this.targetHudBackground.getValue() && this.design.getValue() == TargetHudDesign.COOLER && this.targetHud.getValue()));
        this.clock = (Setting<Boolean>)this.register(new Setting("Clock", (T)true));
        this.clockFill = (Setting<Boolean>)this.register(new Setting("ClockFill", (T)true));
        this.clockX = (Setting<Float>)this.register(new Setting("ClockX", (T)2.0f, (T)0.0f, (T)1000.0f, v -> this.clock.getValue()));
        this.clockY = (Setting<Float>)this.register(new Setting("ClockY", (T)2.0f, (T)0.0f, (T)1000.0f, v -> this.clock.getValue()));
        this.clockRadius = (Setting<Float>)this.register(new Setting("ClockRadius", (T)6.0f, (T)0.0f, (T)100.0f, v -> this.clock.getValue()));
        this.clockLineWidth = (Setting<Float>)this.register(new Setting("ClockLineWidth", (T)1.0f, (T)0.0f, (T)5.0f, v -> this.clock.getValue()));
        this.clockSlices = (Setting<Integer>)this.register(new Setting("ClockSlices", (T)360, (T)1, (T)720, v -> this.clock.getValue()));
        this.clockLoops = (Setting<Integer>)this.register(new Setting("ClockLoops", (T)1, (T)1, (T)720, v -> this.clock.getValue()));
        this.crystal = new ItemStack(Items.END_CRYSTAL);
        this.experience = new ItemStack(Items.EXPERIENCE_BOTTLE);
        this.gapple = new ItemStack(Items.GOLDEN_APPLE);
    }
    
    public static EntityPlayer getClosestEnemy() {
        EntityPlayer closestPlayer = null;
        for (final EntityPlayer player : Components.mc.world.playerEntities) {
            if (player != Components.mc.player) {
                if (Phobos.friendManager.isFriend(player)) {
                    continue;
                }
                if (closestPlayer == null) {
                    closestPlayer = player;
                }
                else {
                    if (Components.mc.player.getDistanceSq((Entity)player) >= Components.mc.player.getDistanceSq((Entity)closestPlayer)) {
                        continue;
                    }
                    closestPlayer = player;
                }
            }
        }
        return closestPlayer;
    }
    
    private static double getPosOnCompass(final Direction dir) {
        final double yaw = Math.toRadians(MathHelper.wrapDegrees(Components.mc.player.rotationYaw));
        final int index = dir.ordinal();
        return yaw + index * 1.5707963267948966;
    }
    
    private static void preboxrender() {
        GL11.glPushMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.disableAlpha();
        GlStateManager.clear(256);
        GlStateManager.enableBlend();
        GlStateManager.color(255.0f, 255.0f, 255.0f, 255.0f);
    }
    
    private static void postboxrender() {
        GlStateManager.disableBlend();
        GlStateManager.disableDepth();
        GlStateManager.disableLighting();
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.popMatrix();
        GL11.glPopMatrix();
    }
    
    private static void preitemrender() {
        GL11.glPushMatrix();
        GL11.glDepthMask(true);
        GlStateManager.clear(256);
        GlStateManager.disableDepth();
        GlStateManager.enableDepth();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.scale(1.0f, 1.0f, 0.01f);
    }
    
    private static void postitemrender() {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.enableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.disableLighting();
        GlStateManager.scale(0.5, 0.5, 0.5);
        GlStateManager.disableDepth();
        GlStateManager.enableDepth();
        GlStateManager.scale(2.0f, 2.0f, 2.0f);
        GL11.glPopMatrix();
    }
    
    public static void drawCompleteImage(final int posX, final int posY, final int width, final int height) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)posX, (float)posY, 0.0f);
        GL11.glBegin(7);
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex3f(0.0f, 0.0f, 0.0f);
        GL11.glTexCoord2f(0.0f, 1.0f);
        GL11.glVertex3f(0.0f, (float)height, 0.0f);
        GL11.glTexCoord2f(1.0f, 1.0f);
        GL11.glVertex3f((float)width, (float)height, 0.0f);
        GL11.glTexCoord2f(1.0f, 0.0f);
        GL11.glVertex3f((float)width, 0.0f, 0.0f);
        GL11.glEnd();
        GL11.glPopMatrix();
    }
    
    @Override
    public void onRender2D(final Render2DEvent event) {
        if (fullNullCheck()) {
            return;
        }
        if (this.playerViewer.getValue()) {
            this.drawPlayer();
        }
        if (this.compass.getValue() != Compass.NONE) {
            this.drawCompass();
        }
        if (this.holeHud.getValue()) {
            this.drawOverlay(event.partialTicks);
        }
        if (this.inventory.getValue()) {
            this.renderInventory();
        }
        if (this.imageLogo.getValue()) {
            this.drawImageLogo();
        }
        if (this.targetHud.getValue()) {
            this.drawTargetHud(event.partialTicks);
        }
        if (this.clock.getValue()) {
            RenderUtil.drawClock(this.clockX.getValue(), this.clockY.getValue(), this.clockRadius.getValue(), this.clockSlices.getValue(), this.clockLoops.getValue(), this.clockLineWidth.getValue(), this.clockFill.getValue(), new Color(255, 0, 0, 255));
        }
        if (this.pvpUtil.getValue()) {
            this.drawPvpUtils(this.pvpUtilX.getValue(), this.pvpUtilY.getValue());
        }
    }
    
    public void drawTargetHud(final float partialTicks) {
        if (this.design.getValue() == TargetHudDesign.NORMAL) {
            final EntityPlayer target = (AutoCrystal.target != null) ? AutoCrystal.target : ((Killaura.target instanceof EntityPlayer) ? Killaura.target : getClosestEnemy());
            if (target == null) {
                return;
            }
            if (this.targetHudBackground.getValue()) {
                RenderUtil.drawRectangleCorrectly(this.targetHudX.getValue(), this.targetHudY.getValue(), 210, 100, ColorUtil.toRGBA(20, 20, 20, 160));
            }
            GlStateManager.disableRescaleNormal();
            GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
            GlStateManager.disableTexture2D();
            GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            try {
                GuiInventory.drawEntityOnScreen(this.targetHudX.getValue() + 30, this.targetHudY.getValue() + 90, 45, 0.0f, 0.0f, (EntityLivingBase)target);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableTexture2D();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            this.renderer.drawStringWithShadow(target.getName(), (float)(this.targetHudX.getValue() + 60), (float)(this.targetHudY.getValue() + 10), ColorUtil.toRGBA(255, 0, 0, 255));
            final float health = target.getHealth() + target.getAbsorptionAmount();
            final int healthColor = (health >= 16.0f) ? ColorUtil.toRGBA(0, 255, 0, 255) : ((health >= 10.0f) ? ColorUtil.toRGBA(255, 255, 0, 255) : ColorUtil.toRGBA(255, 0, 0, 255));
            final DecimalFormat df = new DecimalFormat("##.#");
            this.renderer.drawStringWithShadow(df.format(target.getHealth() + target.getAbsorptionAmount()), (float)(this.targetHudX.getValue() + 60 + this.renderer.getStringWidth(target.getName() + "  ")), (float)(this.targetHudY.getValue() + 10), healthColor);
            int ping;
            if (EntityUtil.isFakePlayer(target)) {
                ping = 0;
            }
            else {
                Objects.requireNonNull(Components.mc.getConnection()).getPlayerInfo(target.getUniqueID());
                ping = Components.mc.getConnection().getPlayerInfo(target.getUniqueID()).getResponseTime();
            }
            final int color = (ping >= 100) ? ColorUtil.toRGBA(0, 255, 0, 255) : ((ping > 50) ? ColorUtil.toRGBA(255, 255, 0, 255) : ColorUtil.toRGBA(255, 0, 0, 255));
            this.renderer.drawStringWithShadow("Ping: " + ping, (float)(this.targetHudX.getValue() + 60), (float)(this.targetHudY.getValue() + this.renderer.getFontHeight() + 20), color);
            this.renderer.drawStringWithShadow("Pops: " + Phobos.totemPopManager.getTotemPops(target), (float)(this.targetHudX.getValue() + 60), (float)(this.targetHudY.getValue() + this.renderer.getFontHeight() * 2 + 30), ColorUtil.toRGBA(255, 0, 0, 255));
            GlStateManager.enableTexture2D();
            int iteration = 0;
            final int i = this.targetHudX.getValue() + 50;
            final int y = this.targetHudY.getValue() + this.renderer.getFontHeight() * 3 + 44;
            for (final ItemStack is : target.inventory.armorInventory) {
                ++iteration;
                if (is.isEmpty()) {
                    continue;
                }
                final int x = i - 90 + (9 - iteration) * 20 + 2;
                GlStateManager.enableDepth();
                RenderUtil.itemRender.zLevel = 200.0f;
                RenderUtil.itemRender.renderItemAndEffectIntoGUI(is, x, y);
                RenderUtil.itemRender.renderItemOverlayIntoGUI(Components.mc.fontRenderer, is, x, y, "");
                RenderUtil.itemRender.zLevel = 0.0f;
                GlStateManager.enableTexture2D();
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                final String s = (is.getCount() > 1) ? (is.getCount() + "") : "";
                this.renderer.drawStringWithShadow(s, (float)(x + 19 - 2 - this.renderer.getStringWidth(s)), (float)(y + 9), 16777215);
                final float green = (is.getMaxDamage() - (float)is.getItemDamage()) / is.getMaxDamage();
                final float red = 1.0f - green;
                final int dmg = 100 - (int)(red * 100.0f);
                this.renderer.drawStringWithShadow(dmg + "", x + 8 - this.renderer.getStringWidth(dmg + "") / 2.0f, (float)(y - 5), ColorUtil.toRGBA((int)(red * 255.0f), (int)(green * 255.0f), 0));
            }
            this.drawOverlay(partialTicks, (Entity)target, this.targetHudX.getValue() + 150, this.targetHudY.getValue() + 6);
            this.renderer.drawStringWithShadow("Strength", (float)(this.targetHudX.getValue() + 150), (float)(this.targetHudY.getValue() + 60), target.isPotionActive(MobEffects.STRENGTH) ? ColorUtil.toRGBA(0, 255, 0, 255) : ColorUtil.toRGBA(255, 0, 0, 255));
            this.renderer.drawStringWithShadow("Weakness", (float)(this.targetHudX.getValue() + 150), (float)(this.targetHudY.getValue() + this.renderer.getFontHeight() + 70), target.isPotionActive(MobEffects.WEAKNESS) ? ColorUtil.toRGBA(0, 255, 0, 255) : ColorUtil.toRGBA(255, 0, 0, 255));
        }
        else if (this.design.getValue() == TargetHudDesign.COOLER) {
            final EntityPlayer target = (AutoCrystal.target != null) ? AutoCrystal.target : ((Killaura.target instanceof EntityPlayer) ? Killaura.target : getClosestEnemy());
            if (target == null) {
                return;
            }
            if (target.isDead) {
                return;
            }
            if (this.targetHudBackground.getValue()) {
                if (this.targetHudColorSync.getValue()) {
                    RenderUtil.drawRectangleCorrectly(this.targetHudX.getValue(), this.targetHudY.getValue(), 210, 100, new Color(Colors.INSTANCE.getCurrentColor().getRed(), Colors.INSTANCE.getCurrentColor().getGreen(), Colors.INSTANCE.getCurrentColor().getBlue(), this.targetHudAlpha.getValue()).getRGB());
                }
                RenderUtil.drawRectangleCorrectly(this.targetHudX.getValue(), this.targetHudY.getValue(), 210, 100, ColorUtil.toRGBA(this.targetHudRed.getValue(), this.targetHudGreen.getValue(), this.targetHudBlue.getValue(), this.targetHudAlpha.getValue()));
            }
            GlStateManager.disableRescaleNormal();
            GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
            GlStateManager.disableTexture2D();
            GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            try {
                GuiInventory.drawEntityOnScreen(this.targetHudX.getValue() + 20, this.targetHudY.getValue() + 65, 30, 0.0f, 0.0f, (EntityLivingBase)target);
            }
            catch (Exception e) {
                e.printStackTrace();
                return;
            }
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableTexture2D();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            this.renderer.drawStringWithShadow(target.getName(), (float)(this.targetHudX.getValue() + 40), (float)(this.targetHudY.getValue() + 30), ColorUtil.toRGBA(255, 0, 0, 255));
            final float health = target.getHealth() + target.getAbsorptionAmount();
            final int healthColor = (health >= 16.0f) ? ColorUtil.toRGBA(0, 255, 0, 255) : ((health >= 10.0f) ? ColorUtil.toRGBA(255, 255, 0, 255) : ColorUtil.toRGBA(255, 0, 0, 255));
            final DecimalFormat df = new DecimalFormat("##.#");
            this.renderer.drawStringWithShadow(df.format(target.getHealth() + target.getAbsorptionAmount()), (float)(this.targetHudX.getValue() + 40 + this.renderer.getStringWidth(target.getName() + "  ")), (float)(this.targetHudY.getValue() + 30), healthColor);
            int ping;
            if (EntityUtil.isFakePlayer(target)) {
                ping = 0;
            }
            else {
                Objects.requireNonNull(Components.mc.getConnection()).getPlayerInfo(target.getUniqueID());
                ping = Components.mc.getConnection().getPlayerInfo(target.getUniqueID()).getResponseTime();
            }
            final int color = (ping >= 100) ? ColorUtil.toRGBA(0, 255, 0, 255) : ((ping > 50) ? ColorUtil.toRGBA(255, 255, 0, 255) : ColorUtil.toRGBA(255, 0, 0, 255));
            final int distance = (int)Components.mc.player.getDistance((Entity)target);
            final int color2 = (distance >= 40) ? ColorUtil.toRGBA(0, 255, 0, 255) : ((distance > 20) ? ColorUtil.toRGBA(255, 255, 0, 255) : ColorUtil.toRGBA(255, 0, 0, 255));
            this.renderer.drawStringWithShadow("Ping: " + ping, (float)(this.targetHudX.getValue() + 40), (float)(this.targetHudY.getValue() + this.renderer.getFontHeight() + 40), color);
            this.renderer.drawStringWithShadow("Pops: " + Phobos.totemPopManager.getTotemPops(target), (float)(this.targetHudX.getValue() + 40), (float)(this.targetHudY.getValue() + this.renderer.getFontHeight() * 2 + 50), ColorUtil.toRGBA(255, 0, 0, 255));
            this.renderer.drawStringWithShadow("Distance " + (int)Components.mc.player.getDistance((Entity)target), (float)(this.targetHudX.getValue() + 40), (float)(this.targetHudY.getValue() + this.renderer.getFontHeight() * 3 + 60), color2);
            GlStateManager.enableTexture2D();
            int iteration2 = 0;
            final int j = this.targetHudX.getValue() + 40;
            final int y2 = this.targetHudY.getValue() + 10;
            for (final ItemStack is2 : target.inventory.armorInventory) {
                ++iteration2;
                if (is2.isEmpty()) {
                    continue;
                }
                final int x2 = j - 90 + (9 - iteration2) * 20 + 2;
                GlStateManager.enableDepth();
                RenderUtil.itemRender.zLevel = 200.0f;
                RenderUtil.itemRender.renderItemAndEffectIntoGUI(is2, x2, y2);
                RenderUtil.itemRender.renderItemOverlayIntoGUI(Components.mc.fontRenderer, is2, x2, y2, "");
                RenderUtil.itemRender.zLevel = 0.0f;
                GlStateManager.enableTexture2D();
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                final String s2 = (is2.getCount() > 1) ? (is2.getCount() + "") : "";
                this.renderer.drawStringWithShadow(s2, (float)(x2 + 19 - 2 - this.renderer.getStringWidth(s2)), (float)(y2 + 9), 16777215);
                final float green2 = (is2.getMaxDamage() - (float)is2.getItemDamage()) / is2.getMaxDamage();
                final float red2 = 1.0f - green2;
                final int dmg2 = 100 - (int)(red2 * 100.0f);
                this.renderer.drawStringWithShadow(dmg2 + "", x2 + 8 - this.renderer.getStringWidth(dmg2 + "") / 2.0f, (float)(y2 - 5), ColorUtil.toRGBA((int)(red2 * 255.0f), (int)(green2 * 255.0f), 0));
            }
            this.renderer.drawStringWithShadow("Strength", (float)(this.targetHudX.getValue() + 150), (float)(this.targetHudY.getValue() + 60), target.isPotionActive(MobEffects.STRENGTH) ? ColorUtil.toRGBA(0, 255, 0, 255) : ColorUtil.toRGBA(255, 0, 0, 255));
            this.renderer.drawStringWithShadow("Weakness", (float)(this.targetHudX.getValue() + 150), (float)(this.targetHudY.getValue() + this.renderer.getFontHeight() + 70), target.isPotionActive(MobEffects.WEAKNESS) ? ColorUtil.toRGBA(0, 255, 0, 255) : ColorUtil.toRGBA(255, 0, 0, 255));
            this.drawOverlay(partialTicks, (Entity)target, this.targetHudX.getValue() + 140, this.targetHudY.getValue() + 20);
            RenderUtil.drawRectangleCorrectly(this.targetHudX.getValue() + 1, this.targetHudY.getValue() + 97, (int)(206.0f * (health / 36.0f)), 2, new Color(252, 186, 3, 255).getRGB());
        }
        else if (this.design.getValue() == TargetHudDesign.COMPACT) {
            final EntityPlayer target = (AutoCrystal.target != null) ? AutoCrystal.target : ((Killaura.target instanceof EntityPlayer) ? Killaura.target : getClosestEnemy());
            if (target == null) {
                return;
            }
            if (target.isDead) {
                return;
            }
            if (this.targetHudBackground.getValue()) {
                if (this.targetHudColorSync.getValue()) {
                    RenderUtil.drawRectangleCorrectly(this.targetHudX.getValue(), this.targetHudY.getValue(), 100, 30, new Color(Colors.INSTANCE.getCurrentColor().getRed(), Colors.INSTANCE.getCurrentColor().getGreen(), Colors.INSTANCE.getCurrentColor().getBlue(), this.targetHudAlpha.getValue()).getRGB());
                }
                RenderUtil.drawRectangleCorrectly(this.targetHudX.getValue(), this.targetHudY.getValue(), 100, 30, ColorUtil.toRGBA(this.targetHudRed.getValue(), this.targetHudGreen.getValue(), this.targetHudBlue.getValue(), this.targetHudAlpha.getValue()));
            }
            GlStateManager.disableRescaleNormal();
            GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
            GlStateManager.disableTexture2D();
            GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableTexture2D();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            this.renderer.drawStringWithShadow(target.getName(), (float)(this.targetHudX.getValue() + 5), (float)(this.targetHudY.getValue() + 1), ColorUtil.toRGBA(255, 0, 0, 255));
            final float health = target.getHealth() + target.getAbsorptionAmount();
            final int healthColor = (health >= 16.0f) ? ColorUtil.toRGBA(0, 255, 0, 255) : ((health >= 10.0f) ? ColorUtil.toRGBA(255, 255, 0, 255) : ColorUtil.toRGBA(255, 0, 0, 255));
            final DecimalFormat df = new DecimalFormat("##.#");
            this.renderer.drawStringWithShadow(df.format(target.getHealth() + target.getAbsorptionAmount()), (float)(this.targetHudX.getValue() + 5 + this.renderer.getStringWidth(target.getName() + "  ")), (float)(this.targetHudY.getValue() + 1), healthColor);
            RenderUtil.drawRectangleCorrectly(this.targetHudX.getValue() + 2, this.targetHudY.getValue() + this.renderer.getFontHeight() + 2, (int)(96.0f * (health / 36.0f)), 4, Colors.INSTANCE.getCurrentColor().getRGB());
            if (EntityUtil.isSafe((Entity)target)) {
                this.renderer.drawStringWithShadow("Safe", (float)(this.targetHudX.getValue() + 5), (float)(this.targetHudY.getValue() + 8 + this.renderer.getFontHeight()), new Color(0, 255, 0, 255).getRGB());
            }
            else {
                this.renderer.drawStringWithShadow("NotSafe", (float)(this.targetHudX.getValue() + 5), (float)(this.targetHudY.getValue() + 8 + this.renderer.getFontHeight()), new Color(255, 0, 0, 255).getRGB());
            }
        }
    }
    
    public void drawImageLogo() {
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        Components.mc.getTextureManager().bindTexture(Components.logo);
        drawCompleteImage(this.imageX.getValue(), this.imageY.getValue(), this.imageWidth.getValue(), this.imageHeight.getValue());
        Components.mc.getTextureManager().deleteTexture(Components.logo);
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
    }
    
    public void drawCompass() {
        final ScaledResolution sr = new ScaledResolution(Components.mc);
        if (this.compass.getValue() == Compass.LINE) {
            final float playerYaw = Components.mc.player.rotationYaw;
            final float rotationYaw = MathUtil.wrap(playerYaw);
            RenderUtil.drawRect(this.compassX.getValue(), this.compassY.getValue(), (float)(this.compassX.getValue() + 100), (float)(this.compassY.getValue() + this.renderer.getFontHeight()), 1963986960);
            RenderUtil.glScissor(this.compassX.getValue(), this.compassY.getValue(), (float)(this.compassX.getValue() + 100), (float)(this.compassY.getValue() + this.renderer.getFontHeight()), sr);
            GL11.glEnable(3089);
            final float zeroZeroYaw = MathUtil.wrap((float)(Math.atan2(0.0 - Components.mc.player.posZ, 0.0 - Components.mc.player.posX) * 180.0 / 3.141592653589793) - 90.0f);
            RenderUtil.drawLine(this.compassX.getValue() - rotationYaw + 50.0f + zeroZeroYaw, (float)(this.compassY.getValue() + 2), this.compassX.getValue() - rotationYaw + 50.0f + zeroZeroYaw, (float)(this.compassY.getValue() + this.renderer.getFontHeight() - 2), 2.0f, -61424);
            RenderUtil.drawLine(this.compassX.getValue() - rotationYaw + 50.0f + 45.0f, (float)(this.compassY.getValue() + 2), this.compassX.getValue() - rotationYaw + 50.0f + 45.0f, (float)(this.compassY.getValue() + this.renderer.getFontHeight() - 2), 2.0f, -1);
            RenderUtil.drawLine(this.compassX.getValue() - rotationYaw + 50.0f - 45.0f, (float)(this.compassY.getValue() + 2), this.compassX.getValue() - rotationYaw + 50.0f - 45.0f, (float)(this.compassY.getValue() + this.renderer.getFontHeight() - 2), 2.0f, -1);
            RenderUtil.drawLine(this.compassX.getValue() - rotationYaw + 50.0f + 135.0f, (float)(this.compassY.getValue() + 2), this.compassX.getValue() - rotationYaw + 50.0f + 135.0f, (float)(this.compassY.getValue() + this.renderer.getFontHeight() - 2), 2.0f, -1);
            RenderUtil.drawLine(this.compassX.getValue() - rotationYaw + 50.0f - 135.0f, (float)(this.compassY.getValue() + 2), this.compassX.getValue() - rotationYaw + 50.0f - 135.0f, (float)(this.compassY.getValue() + this.renderer.getFontHeight() - 2), 2.0f, -1);
            this.renderer.drawStringWithShadow("n", this.compassX.getValue() - rotationYaw + 50.0f + 180.0f - this.renderer.getStringWidth("n") / 2.0f, this.compassY.getValue(), -1);
            this.renderer.drawStringWithShadow("n", this.compassX.getValue() - rotationYaw + 50.0f - 180.0f - this.renderer.getStringWidth("n") / 2.0f, this.compassY.getValue(), -1);
            this.renderer.drawStringWithShadow("e", this.compassX.getValue() - rotationYaw + 50.0f - 90.0f - this.renderer.getStringWidth("e") / 2.0f, this.compassY.getValue(), -1);
            this.renderer.drawStringWithShadow("s", this.compassX.getValue() - rotationYaw + 50.0f - this.renderer.getStringWidth("s") / 2.0f, this.compassY.getValue(), -1);
            this.renderer.drawStringWithShadow("w", this.compassX.getValue() - rotationYaw + 50.0f + 90.0f - this.renderer.getStringWidth("w") / 2.0f, this.compassY.getValue(), -1);
            RenderUtil.drawLine((float)(this.compassX.getValue() + 50), (float)(this.compassY.getValue() + 1), (float)(this.compassX.getValue() + 50), (float)(this.compassY.getValue() + this.renderer.getFontHeight() - 1), 2.0f, -7303024);
            GL11.glDisable(3089);
        }
        else {
            final double centerX = this.compassX.getValue();
            final double centerY = this.compassY.getValue();
            for (final Direction dir : Direction.values()) {
                final double rad = getPosOnCompass(dir);
                this.renderer.drawStringWithShadow(dir.name(), (float)(centerX + this.getX(rad)), (float)(centerY + this.getY(rad)), (dir == Direction.N) ? -65536 : -1);
            }
        }
    }
    
    public void drawPvpUtils(final int x, final int y) {
        final int crystalcount = Components.mc.player.inventory.mainInventory.stream().filter(itemStack -> itemStack.getItem() == Items.END_CRYSTAL).mapToInt(ItemStack::getCount).sum();
        final int color = (crystalcount >= 300) ? ColorUtil.toRGBA(0, 255, 0, 255) : ((crystalcount > 200) ? ColorUtil.toRGBA(255, 255, 0, 255) : ColorUtil.toRGBA(255, 0, 0, 255));
        final int experiencecount = Components.mc.player.inventory.mainInventory.stream().filter(itemStack -> itemStack.getItem() == Items.EXPERIENCE_BOTTLE).mapToInt(ItemStack::getCount).sum();
        final int color2 = (experiencecount >= 300) ? ColorUtil.toRGBA(0, 255, 0, 255) : ((experiencecount > 200) ? ColorUtil.toRGBA(255, 255, 0, 255) : ColorUtil.toRGBA(255, 0, 0, 255));
        final int gapplecount = Components.mc.player.inventory.mainInventory.stream().filter(itemStack -> itemStack.getItem() == Items.GOLDEN_APPLE).mapToInt(ItemStack::getCount).sum();
        GlStateManager.enableDepth();
        RenderUtil.itemRender.zLevel = 200.0f;
        RenderUtil.itemRender.renderItemAndEffectIntoGUI(this.crystal, x, y);
        RenderUtil.itemRender.renderItemOverlayIntoGUI(Components.mc.fontRenderer, this.crystal, x, y, "");
        RenderUtil.itemRender.renderItemAndEffectIntoGUI(this.experience, x, y + 18);
        RenderUtil.itemRender.renderItemOverlayIntoGUI(Components.mc.fontRenderer, this.experience, x, y + 18, "");
        RenderUtil.itemRender.renderItemAndEffectIntoGUI(this.gapple, x, y + 38);
        RenderUtil.itemRender.renderItemOverlayIntoGUI(Components.mc.fontRenderer, this.gapple, x, y + 38, "");
        RenderUtil.itemRender.zLevel = 0.0f;
        GlStateManager.enableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        this.renderer.drawString(crystalcount + " ", (float)(x + 20), (float)(y + 5), color, false);
        this.renderer.drawString(experiencecount + " ", (float)(x + 20), (float)(y + 23), color2, false);
        this.renderer.drawString(gapplecount + " ", (float)(x + 20), (float)(y + 43), color2, false);
    }
    
    public void drawPlayer() {
        final EntityPlayerSP ent = Components.mc.player;
        GlStateManager.pushMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enableAlpha();
        GlStateManager.shadeModel(7424);
        GlStateManager.enableAlpha();
        GlStateManager.enableDepth();
        GlStateManager.rotate(0.0f, 0.0f, 5.0f, 0.0f);
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)(this.playerViewerX.getValue() + 25), (float)(this.playerViewerY.getValue() + 25), 50.0f);
        GlStateManager.scale(-50.0f * this.playerScale.getValue(), 50.0f * this.playerScale.getValue(), 50.0f * this.playerScale.getValue());
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(135.0f, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-(float)Math.atan(this.playerViewerY.getValue() / 40.0f) * 20.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.translate(0.0f, 0.0f, 0.0f);
        final RenderManager rendermanager = Components.mc.getRenderManager();
        rendermanager.setPlayerViewY(180.0f);
        rendermanager.setRenderShadow(false);
        try {
            rendermanager.renderEntity((Entity)ent, 0.0, 0.0, 0.0, 0.0f, 1.0f, false);
        }
        catch (Exception ex) {}
        rendermanager.setRenderShadow(true);
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.depthFunc(515);
        GlStateManager.resetColor();
        GlStateManager.disableDepth();
        GlStateManager.popMatrix();
    }
    
    private double getX(final double rad) {
        return Math.sin(rad) * (this.scale.getValue() * 10);
    }
    
    private double getY(final double rad) {
        final double epicPitch = MathHelper.clamp(Components.mc.player.rotationPitch + 30.0f, -90.0f, 90.0f);
        final double pitchRadians = Math.toRadians(epicPitch);
        return Math.cos(rad) * Math.sin(pitchRadians) * (this.scale.getValue() * 10);
    }
    
    public void drawOverlay(final float partialTicks) {
        float yaw = 0.0f;
        final int dir = MathHelper.floor(Components.mc.player.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3;
        switch (dir) {
            case 1: {
                yaw = 90.0f;
                break;
            }
            case 2: {
                yaw = -180.0f;
                break;
            }
            case 3: {
                yaw = -90.0f;
                break;
            }
        }
        final BlockPos northPos = this.traceToBlock(partialTicks, yaw);
        final Block north = this.getBlock(northPos);
        if (north != null && north != Blocks.AIR) {
            final int damage = this.getBlockDamage(northPos);
            if (damage != 0) {
                RenderUtil.drawRect((float)(this.holeX.getValue() + 16), this.holeY.getValue(), (float)(this.holeX.getValue() + 32), (float)(this.holeY.getValue() + 16), 1627324416);
            }
            this.drawBlock(north, (float)(this.holeX.getValue() + 16), this.holeY.getValue());
        }
        final BlockPos southPos;
        final Block south;
        if ((south = this.getBlock(southPos = this.traceToBlock(partialTicks, yaw - 180.0f))) != null && south != Blocks.AIR) {
            final int damage = this.getBlockDamage(southPos);
            if (damage != 0) {
                RenderUtil.drawRect((float)(this.holeX.getValue() + 16), (float)(this.holeY.getValue() + 32), (float)(this.holeX.getValue() + 32), (float)(this.holeY.getValue() + 48), 1627324416);
            }
            this.drawBlock(south, (float)(this.holeX.getValue() + 16), (float)(this.holeY.getValue() + 32));
        }
        final BlockPos eastPos;
        final Block east;
        if ((east = this.getBlock(eastPos = this.traceToBlock(partialTicks, yaw + 90.0f))) != null && east != Blocks.AIR) {
            final int damage = this.getBlockDamage(eastPos);
            if (damage != 0) {
                RenderUtil.drawRect((float)(this.holeX.getValue() + 32), (float)(this.holeY.getValue() + 16), (float)(this.holeX.getValue() + 48), (float)(this.holeY.getValue() + 32), 1627324416);
            }
            this.drawBlock(east, (float)(this.holeX.getValue() + 32), (float)(this.holeY.getValue() + 16));
        }
        final BlockPos westPos;
        final Block west;
        if ((west = this.getBlock(westPos = this.traceToBlock(partialTicks, yaw - 90.0f))) != null && west != Blocks.AIR) {
            final int damage = this.getBlockDamage(westPos);
            if (damage != 0) {
                RenderUtil.drawRect(this.holeX.getValue(), (float)(this.holeY.getValue() + 16), (float)(this.holeX.getValue() + 16), (float)(this.holeY.getValue() + 32), 1627324416);
            }
            this.drawBlock(west, this.holeX.getValue(), (float)(this.holeY.getValue() + 16));
        }
    }
    
    public void drawOverlay(final float partialTicks, final Entity player, final int x, final int y) {
        float yaw = 0.0f;
        final int dir = MathHelper.floor(player.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3;
        switch (dir) {
            case 1: {
                yaw = 90.0f;
                break;
            }
            case 2: {
                yaw = -180.0f;
                break;
            }
            case 3: {
                yaw = -90.0f;
                break;
            }
        }
        final BlockPos northPos = this.traceToBlock(partialTicks, yaw, player);
        final Block north = this.getBlock(northPos);
        if (north != null && north != Blocks.AIR) {
            final int damage = this.getBlockDamage(northPos);
            if (damage != 0) {
                RenderUtil.drawRect((float)(x + 16), (float)y, (float)(x + 32), (float)(y + 16), 1627324416);
            }
            this.drawBlock(north, (float)(x + 16), (float)y);
        }
        final BlockPos southPos;
        final Block south;
        if ((south = this.getBlock(southPos = this.traceToBlock(partialTicks, yaw - 180.0f, player))) != null && south != Blocks.AIR) {
            final int damage = this.getBlockDamage(southPos);
            if (damage != 0) {
                RenderUtil.drawRect((float)(x + 16), (float)(y + 32), (float)(x + 32), (float)(y + 48), 1627324416);
            }
            this.drawBlock(south, (float)(x + 16), (float)(y + 32));
        }
        final BlockPos eastPos;
        final Block east;
        if ((east = this.getBlock(eastPos = this.traceToBlock(partialTicks, yaw + 90.0f, player))) != null && east != Blocks.AIR) {
            final int damage = this.getBlockDamage(eastPos);
            if (damage != 0) {
                RenderUtil.drawRect((float)(x + 32), (float)(y + 16), (float)(x + 48), (float)(y + 32), 1627324416);
            }
            this.drawBlock(east, (float)(x + 32), (float)(y + 16));
        }
        final BlockPos westPos;
        final Block west;
        if ((west = this.getBlock(westPos = this.traceToBlock(partialTicks, yaw - 90.0f, player))) != null && west != Blocks.AIR) {
            final int damage = this.getBlockDamage(westPos);
            if (damage != 0) {
                RenderUtil.drawRect((float)x, (float)(y + 16), (float)(x + 16), (float)(y + 32), 1627324416);
            }
            this.drawBlock(west, (float)x, (float)(y + 16));
        }
    }
    
    private int getBlockDamage(final BlockPos pos) {
        for (final DestroyBlockProgress destBlockProgress : Components.mc.renderGlobal.damagedBlocks.values()) {
            if (destBlockProgress.getPosition().getX() == pos.getX() && destBlockProgress.getPosition().getY() == pos.getY()) {
                if (destBlockProgress.getPosition().getZ() != pos.getZ()) {
                    continue;
                }
                return destBlockProgress.getPartialBlockDamage();
            }
        }
        return 0;
    }
    
    private BlockPos traceToBlock(final float partialTicks, final float yaw) {
        final Vec3d pos = EntityUtil.interpolateEntity((Entity)Components.mc.player, partialTicks);
        final Vec3d dir = MathUtil.direction(yaw);
        return new BlockPos(pos.x + dir.x, pos.y, pos.z + dir.z);
    }
    
    private BlockPos traceToBlock(final float partialTicks, final float yaw, final Entity player) {
        final Vec3d pos = EntityUtil.interpolateEntity(player, partialTicks);
        final Vec3d dir = MathUtil.direction(yaw);
        return new BlockPos(pos.x + dir.x, pos.y, pos.z + dir.z);
    }
    
    private Block getBlock(final BlockPos pos) {
        final Block block = Components.mc.world.getBlockState(pos).getBlock();
        if (block == Blocks.BEDROCK || block == Blocks.OBSIDIAN) {
            return block;
        }
        return Blocks.AIR;
    }
    
    private void drawBlock(final Block block, final float x, final float y) {
        final ItemStack stack = new ItemStack(block);
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.translate(x, y, 0.0f);
        Components.mc.getRenderItem().zLevel = 501.0f;
        Components.mc.getRenderItem().renderItemAndEffectIntoGUI(stack, 0, 0);
        Components.mc.getRenderItem().zLevel = 0.0f;
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.popMatrix();
    }
    
    public void renderInventory() {
        this.boxrender(this.invX.getValue() + this.fineinvX.getValue(), this.invY.getValue() + this.fineinvY.getValue());
        this.itemrender((NonNullList<ItemStack>)Components.mc.player.inventory.mainInventory, this.invX.getValue() + this.fineinvX.getValue(), this.invY.getValue() + this.fineinvY.getValue());
    }
    
    private void boxrender(final int x, final int y) {
        preboxrender();
        Components.mc.renderEngine.bindTexture(Components.box);
        RenderUtil.drawTexturedRect(x, y, 0, 0, 176, 16, 500);
        RenderUtil.drawTexturedRect(x, y + 16, 0, 16, 176, 54 + this.invH.getValue(), 500);
        RenderUtil.drawTexturedRect(x, y + 16 + 54, 0, 160, 176, 8, 500);
        postboxrender();
    }
    
    private void itemrender(final NonNullList<ItemStack> items, final int x, final int y) {
        for (int i = 0; i < items.size() - 9; ++i) {
            final int iX = x + i % 9 * 18 + 8;
            final int iY = y + i / 9 * 18 + 18;
            final ItemStack itemStack = (ItemStack)items.get(i + 9);
            preitemrender();
            Components.mc.getRenderItem().zLevel = 501.0f;
            RenderUtil.itemRender.renderItemAndEffectIntoGUI(itemStack, iX, iY);
            RenderUtil.itemRender.renderItemOverlayIntoGUI(Components.mc.fontRenderer, itemStack, iX, iY, (String)null);
            Components.mc.getRenderItem().zLevel = 0.0f;
            postitemrender();
        }
        if (this.renderXCarry.getValue()) {
            for (int i = 1; i < 5; ++i) {
                final int iX = x + (i + 4) % 9 * 18 + 8;
                final ItemStack itemStack2 = Components.mc.player.inventoryContainer.inventorySlots.get(i).getStack();
                if (!itemStack2.isEmpty) {
                    preitemrender();
                    Components.mc.getRenderItem().zLevel = 501.0f;
                    RenderUtil.itemRender.renderItemAndEffectIntoGUI(itemStack2, iX, y + 1);
                    RenderUtil.itemRender.renderItemOverlayIntoGUI(Components.mc.fontRenderer, itemStack2, iX, y + 1, (String)null);
                    Components.mc.getRenderItem().zLevel = 0.0f;
                    postitemrender();
                }
            }
        }
    }
    
    static {
        box = new ResourceLocation("textures/gui/container/shulker_box.png");
        Components.logo = new ResourceLocation("textures/phobos.png");
    }
    
    public enum TargetHudDesign
    {
        NORMAL, 
        COMPACT, 
        COOLER;
    }
    
    public enum Compass
    {
        NONE, 
        CIRCLE, 
        LINE;
    }
    
    private enum Direction
    {
        N, 
        W, 
        S, 
        E;
    }
}
