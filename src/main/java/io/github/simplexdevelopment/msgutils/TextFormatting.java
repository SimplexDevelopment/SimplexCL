package io.github.simplexdevelopment.msgutils;

import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextFormat;

public enum TextFormatting {
    BOLD(TextDecoration.BOLD),
    ITALICS(TextDecoration.ITALIC),
    UNDERLINED(TextDecoration.UNDERLINED),
    STRIKETHROUGH(TextDecoration.STRIKETHROUGH),
    MAGIC(TextDecoration.OBFUSCATED);

    final TextDecoration format;

    TextFormatting(TextDecoration format) {
        this.format = format;
    }

    public TextFormat getFormat() {
        return format;
    }
}
