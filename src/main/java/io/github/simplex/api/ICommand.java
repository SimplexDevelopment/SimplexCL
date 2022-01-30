package io.github.simplex.api;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

public interface ICommand extends CommandExecutor, TabCompleter {
    boolean execute();
}
