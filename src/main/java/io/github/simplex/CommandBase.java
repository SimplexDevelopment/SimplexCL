package io.github.simplex;

import io.github.simplex.api.ICommand;
import io.github.simplex.api.annotations.SubCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class CommandBase extends Permissible implements ICommand {
    public CommandBase(String permission, String permissionMessage, boolean allowConsole) {
        super(permission, permissionMessage, allowConsole);
    }

    public CommandBase(String permission, String permissionMessage) {
        this(permission, permissionMessage, true);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String lbl, String[] args) {
        if (!hasPermission(sender)) {
            sender.sendMessage(Component
                    .empty()
                    .content(getPermissionMessage())
                    .color(TextColor.color(255, 3, 62)));
            return true;
        }

        if (!(sender instanceof Player) && !allowConsole()) {
            sender.sendMessage(Component.empty().content("This command may only be run in game."));
        }

        execute(sender, args, allowConsole());
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return new ArrayList<>();
    }

    public TextComponent msg(String text) {
        return Component.empty().content(text);
    }
}
