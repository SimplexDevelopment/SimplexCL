package io.github.simplex.cl;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class DummyCommand extends Command implements PluginIdentifiableCommand {
    private final CommandBase base;
    private final Plugin plugin;

    DummyCommand(@NotNull Plugin plugin, @NotNull CommandBase base, @NotNull String name, @NotNull String description, @NotNull String usageMessage, @NotNull List<String> aliases) {
        super(name, description, usageMessage, aliases);
        this.setName(name);
        this.setDescription(description);
        this.setUsage(usageMessage);
        this.setAliases(aliases);
        this.setPermission(base.getPermission());
        this.base = base;
        this.plugin = plugin;
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        base.onCommand(sender, this, commandLabel, args);
        return true;
    }

    @Override
    public @NotNull Plugin getPlugin() {
        return plugin;
    }
}
