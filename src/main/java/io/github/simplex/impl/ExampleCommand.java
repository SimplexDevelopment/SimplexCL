package io.github.simplex.impl;

import io.github.simplex.CommandBase;
import io.github.simplex.SubCommandBase;
import io.github.simplex.api.annotations.Info;
import io.github.simplex.api.annotations.Permission;
import io.github.simplex.api.annotations.SubCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.command.CommandSender;

@Info(name = "example", description = "An example command implementation to see how this works.", usage = "/example [info]", aliases = "ex, impl")
@Permission(permission = "simplexcl.example", permissionMessage = "You cannot use this command!")
public final class ExampleCommand extends CommandBase {
    public ExampleCommand(String permission, String permissionMessage, boolean allowConsole) {
        super(permission, permissionMessage, allowConsole);
    }

    @Override
    public void execute(CommandSender sender, String[] args, boolean allowConsole) {

    }

    @SubCommand(name = "info")
    @Permission(permission = "simplexcl.example.info")
    public class InfoSubCommand extends SubCommandBase {
        public InfoSubCommand(String permission, String permissionMessage, boolean allowConsole) {
            super(permission, permissionMessage, allowConsole);
        }

        @Override
        public void execute(CommandSender sender, String[] args, boolean allowConsole) {
            TextComponent message = Component.empty();
            message = message.append(msg("SimplexCL was created by SimplexDevelopment!"))
                    .append(msg("https://github.com/SimplexDevelopment/"));
            sender.sendMessage(message);
        }
    }
}
