package io.github.simplexdevelopment.cl.impl;

import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.AdvancedColors;
import io.github.simplexdevelopment.msgutils.BasicColors;
import org.bukkit.command.CommandSender;

@Info(name = "example", description = "An example command implementation to see how this works.", usage = "/example [info]", aliases = "ex, impl")
public final class ExampleCommand extends CommandBase {
    public ExampleCommand() {
        super("simplexcl.example",
                "You do not have permission to use this command!",
                true);
    }

    @Override
    public void execute(CommandSender sender, String[] args, boolean allowConsole) {
        if (subCommand("info", sender, getPermission() + ".info", args, () -> sender.sendMessage(msg("SimplexCL was created by SimplexDevelopment!", BasicColors.GOLD)))) {
            return;
        }

        if (subCommand("info more", sender, getPermission() + ".info.more", args, () -> sender.sendMessage(msg("https://github.com/SimplexDevelopment", AdvancedColors.FUCHSIA)))) {
            return;
        }

        sender.sendMessage(msg("This is an example command.", BasicColors.BLUE));
    }
}
