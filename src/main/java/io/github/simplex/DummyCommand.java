package io.github.simplex;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DummyCommand extends BukkitCommand {
    private final CommandBase base;

    protected DummyCommand(@NotNull CommandBase base, @NotNull String name, @NotNull String description, @NotNull String usageMessage, @NotNull List<String> aliases) {
        super(name, description, usageMessage, aliases);
        this.setName(name);
        this.setDescription(description);
        this.setUsage(usageMessage);
        this.setAliases(aliases);
        this.setPermission(base.getPermission());
        this.base = base;
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        base.onCommand(sender, this, commandLabel, args);
        return true;
    }
}
