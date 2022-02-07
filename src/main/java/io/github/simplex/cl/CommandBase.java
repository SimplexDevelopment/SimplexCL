package io.github.simplex.cl;

import io.github.simplex.api.ICommand;
import io.github.simplex.api.SubCommand;
import io.github.simplex.msgutils.AdvancedColors;
import io.github.simplex.msgutils.BasicColors;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class CommandBase extends Permissible implements ICommand {
    public CommandBase(String permission, String permissionMessage, boolean allowConsole) {
        super(permission, permissionMessage, allowConsole);
    }

    public CommandBase(String permission, String permissionMessage) {
        this(permission, permissionMessage, true);
    }

    public CommandBase(String permission, boolean allowConsole) {
        this(permission, "You do not have permission to use this command!", allowConsole);
    }

    public CommandBase(String permission) {
        this(permission, "You do not have permission to use this command!", true);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String lbl, String[] args) {
        if (!hasPermission(sender)) {
            sender.sendMessage(msg(getPermissionMessage(), BasicColors.RED));
            return true;
        }

        if (!(sender instanceof Player) && !allowConsole()) {
            sender.sendMessage(msg("This command can only be run in game."));
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

    public TextComponent msg(String text, BasicColors color) {
        return Component.empty().content(text).color(color.getColor());
    }

    public TextComponent msg(String text, AdvancedColors color) {
        return Component.empty().content(text).color(color.getColor());
    }

    public void subCommand(String name, String[] args, SubCommand command) {
        if (args[0].equalsIgnoreCase(name)) {
            command.execute();
        }
    }

    public Player getPlayer(String name) {
        return Bukkit.getServer().getPlayer(name);
    }

    public Player getPlayer(UUID uuid) {
        return Bukkit.getServer().getPlayer(uuid);
    }

    public List<? extends Player> getOnlinePlayers() {
        return Bukkit.getOnlinePlayers().stream().toList();
    }

    public void broadcast(String text) {
        Bukkit.getServer().broadcast(msg(text));
    }

    public void broadcast(String text, BasicColors color) {
        Bukkit.getServer().broadcast(msg(text, color));
    }

    public void broadcast(String text, AdvancedColors color) {
        Bukkit.getServer().broadcast(msg(text, color));
    }

    public void enablePlugin(Plugin plugin) {
        Bukkit.getServer().getPluginManager().enablePlugin(plugin);
    }

    public void disablePlugin(Plugin plugin) {
        Bukkit.getServer().getPluginManager().disablePlugin(plugin);
    }
}
