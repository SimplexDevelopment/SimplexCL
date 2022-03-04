package io.github.simplexdevelopment.cl.api;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public interface ICommand extends CommandExecutor, TabCompleter {
    /**
     * This is the actual onCommand method. This should be used when you want to execute the command itself.
     *
     * @param sender       The user who sent the command. (Provided by Paper)
     * @param args         The additional arguments to the command, if applicable (Provided by Paper)
     * @param allowConsole Whether the command should be allowed anywhere, or only in game.
     */
    void execute(CommandSender sender, String[] args);
}
