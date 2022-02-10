package io.github.simplexdevelopment.msgutils;

import net.kyori.adventure.text.format.TextColor;

public enum AdvancedColors {
    AMETHYST(TextColor.color(253, 103, 204)),
    AQUAMARINE(TextColor.color(127, 255, 212)),
    AZURE(TextColor.color(0, 127, 255)),
    BRONZE(TextColor.color(205, 127, 50)),
    BURLYWOOD(TextColor.color(222, 184, 135)),
    CHARTREUSE(TextColor.color(223, 255, 0)),
    CORAL(TextColor.color(255, 127, 80)),
    CORNFLOWER(TextColor.color(100, 149, 237)),
    CRIMSON(TextColor.color(220, 20, 60)),
    FUCHSIA(TextColor.color(255, 0, 255)),
    GOLDENROD(TextColor.color(218, 165, 32)),
    GRAPE(TextColor.color(111, 45, 168)),
    HONEYDEW(TextColor.color(240, 255, 240)),
    INDIGO(TextColor.color(75, 0, 130)),
    IVORY(TextColor.color(255, 255, 240)),
    MAROON(TextColor.color(128, 0 , 0)),
    MEDIUM_VIOLET_RED(TextColor.color(199, 21, 133)),
    MOCCASIN(TextColor.color(255, 228, 181)),
    OLIVE(TextColor.color(128, 128, 0)),
    PALE_VIOLET_RED(TextColor.color(219, 112, 147)),
    PLUM(TextColor.color(142, 69, 133)),
    SALMON(TextColor.color(250, 128, 114)),
    SEA_GREEN(TextColor.color(46, 139, 87)),
    SILVER(TextColor.color(192, 192, 192)),
    SLATE(TextColor.color(192, 194, 201)),
    SLATE_BLUE(TextColor.color(106, 90, 205)),
    STEEL_BLUE(TextColor.color(70, 130, 180)),
    TOMATO(TextColor.color(255, 99, 71)),
    TURQUOISE(TextColor.color(48, 213, 200)),
    WHEAT(TextColor.color(245, 222, 179));

    final TextColor color;

    AdvancedColors(TextColor color) {
        this.color = color;
    }

    public TextColor getColor() {
        return color;
    }
}
