package io.github.simplex;

import io.github.simplex.api.ICommand;
import io.github.simplex.api.annotations.Permission;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.util.RGBLike;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public abstract class CommandBase extends Permissible implements ICommand {
    private final Plugin plugin;

    public CommandBase(Plugin plugin, String permission, String permissionMessage) {
        super(permission, permissionMessage);
        this.plugin = plugin;
    }

    public CommandBase(Plugin plugin, String permission) {
        this(plugin, permission, "You do not have permission to use this command.");
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
        execute();
        return true;
    }
}
