package io.github.simplex.cl.impl;

import io.github.simplex.cl.CommandBase;
import io.github.simplex.cl.api.annotations.Info;
import io.github.simplex.msgutils.BasicColors;
import net.kyori.adventure.text.format.TextColor;
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
        if (args.length == 1) {
            subCommand("info",
                    args,
                    () -> sender.sendMessage(msg("SimplexCL was created by Simplex Development Group.", BasicColors.GOLD)));
            return;
        }

        sender.sendMessage(msg("This is an example command.", BasicColors.BLUE));
    }
}
