



package me.earth.phobos.manager;

import me.earth.phobos.features.*;
import me.earth.phobos.features.gui.font.*;
import me.earth.phobos.*;
import java.awt.*;
import me.earth.phobos.util.*;
import net.minecraft.util.math.*;

public class TextManager extends Feature
{
    private final TimerUtil idleTimer;
    public int scaledWidth;
    public int scaledHeight;
    public int scaleFactor;
    private CustomFont customFont;
    private boolean idling;
    
    public TextManager() {
        this.idleTimer = new TimerUtil();
        this.customFont = new CustomFont(new Font("Verdana",  0,  17),  true,  false);
        this.updateResolution();
    }
    
    public void init(final boolean startup) {
        final me.earth.phobos.features.modules.client.CustomFont cFont = (me.earth.phobos.features.modules.client.CustomFont)Phobos.moduleManager.getModuleByClass((Class)me.earth.phobos.features.modules.client.CustomFont.class);
        try {
            this.setFontRenderer(new Font((String)cFont.fontName.getValue(),  (int)cFont.fontStyle.getValue(),  (int)cFont.fontSize.getValue()),  (boolean)cFont.antiAlias.getValue(),  (boolean)cFont.fractionalMetrics.getValue());
        }
        catch (Exception ex) {}
    }
    
    public void drawStringWithShadow(final String text,  final float x,  final float y,  final int color) {
        this.drawString(text,  x,  y,  color,  true);
    }
    
    public float drawString(final String text,  final float x,  final float y,  final int color,  final boolean shadow) {
        if (!Phobos.moduleManager.isModuleEnabled((Class)me.earth.phobos.features.modules.client.CustomFont.class)) {
            return (float)TextManager.mc.fontRenderer.drawString(text,  x,  y,  color,  shadow);
        }
        if (shadow) {
            return this.customFont.drawStringWithShadow(text,  (double)x,  (double)y,  color);
        }
        return this.customFont.drawString(text,  x,  y,  color);
    }
    
    public void drawRainbowString(final String text,  final float x,  final float y,  final int startColor,  final float factor,  final boolean shadow) {
        Color currentColor = new Color(startColor);
        final float hueIncrement = 1.0f / factor;
        final String[] rainbowStrings = text.split("�.");
        float currentHue = Color.RGBtoHSB(currentColor.getRed(),  currentColor.getGreen(),  currentColor.getBlue(),  null)[0];
        final float saturation = Color.RGBtoHSB(currentColor.getRed(),  currentColor.getGreen(),  currentColor.getBlue(),  null)[1];
        final float brightness = Color.RGBtoHSB(currentColor.getRed(),  currentColor.getGreen(),  currentColor.getBlue(),  null)[2];
        int currentWidth = 0;
        boolean shouldRainbow = true;
        boolean shouldContinue = false;
        for (int i = 0; i < text.length(); ++i) {
            final char currentChar = text.charAt(i);
            final char nextChar = text.charAt(MathUtil.clamp(i + 1,  0,  text.length() - 1));
            final boolean equals = (String.valueOf(currentChar) + nextChar).equals("�r");
            if (equals) {
                shouldRainbow = false;
            }
            else if ((String.valueOf(currentChar) + nextChar).equals("�+")) {
                shouldRainbow = true;
            }
            if (shouldContinue) {
                shouldContinue = false;
            }
            else {
                if (equals) {
                    final String escapeString = text.substring(i);
                    this.drawString(escapeString,  x + currentWidth,  y,  Color.WHITE.getRGB(),  shadow);
                    break;
                }
                this.drawString(String.valueOf(currentChar).equals("�") ? "" : String.valueOf(currentChar),  x + currentWidth,  y,  shouldRainbow ? currentColor.getRGB() : Color.WHITE.getRGB(),  shadow);
                if (String.valueOf(currentChar).equals("�")) {
                    shouldContinue = true;
                }
                currentWidth += this.getStringWidth(String.valueOf(currentChar));
                if (!String.valueOf(currentChar).equals(" ")) {
                    currentColor = new Color(Color.HSBtoRGB(currentHue,  saturation,  brightness));
                    currentHue += hueIncrement;
                }
            }
        }
    }
    
    public int getStringWidth(final String text) {
        if (Phobos.moduleManager.isModuleEnabled((Class)me.earth.phobos.features.modules.client.CustomFont.class)) {
            return this.customFont.getStringWidth(text);
        }
        return TextManager.mc.fontRenderer.getStringWidth(text);
    }
    
    public int getFontHeight() {
        if (Phobos.moduleManager.isModuleEnabled((Class)me.earth.phobos.features.modules.client.CustomFont.class)) {
            final String text = "A";
            return this.customFont.getStringHeight(text);
        }
        return TextManager.mc.fontRenderer.FONT_HEIGHT;
    }
    
    public void setFontRenderer(final Font font,  final boolean antiAlias,  final boolean fractionalMetrics) {
        this.customFont = new CustomFont(font,  antiAlias,  fractionalMetrics);
    }
    
    public Font getCurrentFont() {
        return this.customFont.getFont();
    }
    
    public void updateResolution() {
        this.scaledWidth = TextManager.mc.displayWidth;
        this.scaledHeight = TextManager.mc.displayHeight;
        this.scaleFactor = 1;
        final boolean flag = TextManager.mc.isUnicode();
        int i = TextManager.mc.gameSettings.guiScale;
        if (i == 0) {
            i = 1000;
        }
        while (this.scaleFactor < i && this.scaledWidth / (this.scaleFactor + 1) >= 320 && this.scaledHeight / (this.scaleFactor + 1) >= 240) {
            ++this.scaleFactor;
        }
        if (flag && this.scaleFactor % 2 != 0 && this.scaleFactor != 1) {
            --this.scaleFactor;
        }
        final double scaledWidthD = this.scaledWidth / (double)this.scaleFactor;
        final double scaledHeightD = this.scaledHeight / (double)this.scaleFactor;
        this.scaledWidth = MathHelper.ceil(scaledWidthD);
        this.scaledHeight = MathHelper.ceil(scaledHeightD);
    }
    
    public String getIdleSign() {
        if (this.idleTimer.passedMs(500L)) {
            this.idling = !this.idling;
            this.idleTimer.reset();
        }
        if (this.idling) {
            return "_";
        }
        return "";
    }
}
